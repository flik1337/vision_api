package cn.flik1337.vision.service.impl;

import cn.flik1337.vision.common.exception.Asserts;
import cn.flik1337.vision.common.utils.OrderNoUtil;
import cn.flik1337.vision.common.utils.SeatUtil;
import cn.flik1337.vision.dao.FilmDao;
import cn.flik1337.vision.dao.FilmScheduleDao;
import cn.flik1337.vision.dao.OrderDao;
import cn.flik1337.vision.mbg.mapper.*;
import cn.flik1337.vision.mbg.model.*;
import cn.flik1337.vision.service.OrderService;
import cn.flik1337.vision.service.RedisService;
import cn.flik1337.vision.vo.FilmScheduleVo;
import cn.flik1337.vision.vo.FilmVo;
import cn.flik1337.vision.vo.OrderDetailVo;
import cn.flik1337.vision.vo.OrderVo;
import cn.hutool.db.sql.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static cn.flik1337.vision.common.api.ResultCode.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private FilmScheduleMapper filmScheduleMapper;
    @Autowired
    private HallMapper hallMapper;
    @Autowired
    private FilmScheduleDao filmScheduleDao;
    @Autowired
    private FilmOrderMapper filmOrderMapper;
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private RedisService redisService;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private FilmDao filmDao;
    @Autowired
    private CinemaMapper cinemaMapper;


    private static final int UN_PAY = 0;
    private static final int BANNED = 1;

    private static final int STATUS_UN_PAY  = 0;
    private static final int STATUS_PAYED  = 1;
    private static final int UN_FETCHED  = 0;
    private static final int FETCHED  = 1;

    private static final long LOCK_SECONDS = 60 * 15;


    private static final String lockPrefix  = "seat_sc_";
    private static final String lockSuffix  = "_u_";
    private static final String lockInfix_x  = "_row_";
    private static final String lockInfix_y  = "_column_";

    private static final String SPLIT = "_";

    public boolean checkSeatLockedBySelf(int scheduleId,int userId,int row,int column){

        String seatKey = lockPrefix + scheduleId + lockSuffix + userId + lockInfix_x + row + lockInfix_y + column;
        String seatPattern = lockPrefix + scheduleId + lockSuffix + "*" + lockInfix_x + row + lockInfix_y + column;
        Set<String > keys = redisService.keys(seatPattern);

        return keys.contains(seatKey);

    }
    /**
    * @Description:
    * @Param: x,y ????????????
    * @Date: 2021/6/5 01:01:26
    */
    @Override
    public void lockSeat(int scheduleId,int userId,int row,int column){
        // 1.???????????????????????????????????????
        String seatKey = lockPrefix + scheduleId + lockSuffix + userId + lockInfix_x + row + lockInfix_y + column;
        String seatValue = redisService.get(seatKey);
        if (seatValue != null){
            int valueId = Integer.parseInt(seatValue);
            if (valueId != userId){
                Asserts.fail(SEAT_LOCKED);
            }
        }

        // 2.redis?????????
        redisService.set(seatKey,String.valueOf(userId));
        redisService.expire(seatKey,LOCK_SECONDS);

    }

    @Override
    public void lockSeatList(OrderVo orderVo) {
        int scheduleId = orderVo.getFilmOrder().getFilmScheduleId();
        int userId = orderVo.getFilmOrder().getUserId();

        for (Ticket ticket : orderVo.getTicketList()){
            lockSeat(scheduleId,userId,ticket.getPosX(),ticket.getPosY());
        }
    }


    @Override
    public void unlockSeat(int scheduleId,int userId,int row,int column){
        // 1.??????????????????????????????
        String seatKey = lockPrefix + scheduleId + lockSuffix + userId + lockInfix_x + row + lockInfix_y + column;
        System.out.println(seatKey);
        String seatValue = redisService.get(seatKey);
        // ???????????????
//        if (seatValue == null){
//            Asserts.fail(SEAT_NOT_LOCKED);
//        }else{
//            redisService.remove(seatKey);
//        }
        if(seatValue != null){
            redisService.remove(seatKey);
        }
    }
    @Override
    public void unlockSeatList(OrderVo orderVo){
        int scheduleId = orderVo.getFilmOrder().getFilmScheduleId();
        int userId = orderVo.getFilmOrder().getUserId();

        for (Ticket ticket : orderVo.getTicketList()){
            unlockSeat(scheduleId,userId,ticket.getPosX(),ticket.getPosY());
        }

    }
    /**
    * @Description: ????????????
    * @Param: 
    * @Date: 2021/6/2 08:13:42
    */
    @Override
    public String createOrder(OrderVo orderVo) {
        Integer ticketNum = orderVo.getTicketList().size();
        // ????????????????????????
        if (ticketNum == 0){
            Asserts.fail(SEAT_NOT_SEL);
        }
        // ??????????????????????????????
        List<Ticket> ticketList = orderVo.getTicketList();
        ticketList.forEach(ticket -> {
            boolean seatLocked = checkSeatLockedBySelf(orderVo.getFilmOrder().getFilmScheduleId(),orderVo.getFilmOrder().getUserId(),ticket.getPosX(),ticket.getPosY());
            if (!seatLocked){
                Asserts.fail(SEAT_LOCKED);
            }
        });

        // ???????????????
        String orderNo = OrderNoUtil.createBookingOrderNo();
        System.out.println("?????????="+orderNo);


        //????????????ID
        // todo ???token??????????????? ,???????????????

        // ????????????
        Integer schedulePrice = filmScheduleDao.getSchedulePrice(orderVo.getFilmOrder().getFilmScheduleId());
        Integer price = schedulePrice * ticketNum;
        // ???????????????
        if (price < 200){
            Asserts.fail(ORDER_ERROR);
        }
        orderVo.getFilmOrder().setFilmOrderId(orderNo);
        orderVo.getFilmOrder().setActualMoney(price);
        orderVo.getFilmOrder().setFilmOrderId(orderNo);
        // ??????????????????
        orderVo.getFilmOrder().setPayStatus(UN_PAY);
        orderVo.getFilmOrder().setFetchStatus(UN_FETCHED);

        orderVo.getFilmOrder().setCreateTime(new Date());

        // ??????order??????
        filmOrderMapper.insertSelective(orderVo.getFilmOrder());

        // ??????ticket??????
        orderVo.getTicketList().forEach( ticket ->{
            ticket.setFilmOrderId(orderNo);
            //ticket.setQrCode("1");
            ticketMapper.insertSelective(ticket);
        });
        // redis?????????????????????????????????

        
        return orderNo;

    }
    /**
    * @Description: ???????????????????????????
    * @Param:
    * @Date: 2021/6/6 01:47:25
    */
    @Override
    public int[][] getBannedSeats(int scheduleId){
        // 1.?????????schedule????????????
        FilmSchedule filmSchedule = filmScheduleMapper.selectByPrimaryKey(scheduleId);
        int  hallId = filmSchedule.getHallId();
        Hall hall =   hallMapper.selectByPrimaryKey(hallId);

        if (hall == null){
            Asserts.fail(FAILED);

        };
        String seatPattern = hall.getSeatInfo();

        // 2.??????????????????
        int[][] emptySeats = SeatUtil.calcEmptySeatInfo(seatPattern);
        int[][] seats = SeatUtil.calcSeatInfo(seatPattern);

        // 3.??????????????????????????????
        List<Ticket> ticketList =  orderDao.getTicketListByScheduleId(scheduleId);

        ticketList.forEach(ticket -> {
            HashMap<String,Integer> seat = SeatUtil.calcReverseXY(ticket.getPosX(),ticket.getPosY(),seats);
            int x = seat.get("row");
            int y = seat.get("column");
            emptySeats[x][y] = BANNED;
        });

        // 4.??????redis???????????????
        String redisSchedulePattern = lockPrefix + scheduleId + "*";
        Set<String> keySet = redisService.keys(redisSchedulePattern);

        if (keySet.size() == 0){
            return emptySeats;
        }
        for(String key : keySet){
            int row = Integer.parseInt(key.split(SPLIT)[6]);
            int column = Integer.parseInt(key.split(SPLIT)[8]);

            HashMap<String,Integer> seat = SeatUtil.calcReverseXY(row,column,seats);
            int x = seat.get("row");
            int y = seat.get("column");

            emptySeats[x][y] = BANNED;
        }

        return emptySeats;

    }

    /**
    * @Description: ????????????????????????
    * @Param:
    * @Date: 2021/6/6 01:47:07
    */
    @Override
    public List<OrderDetailVo> getUserOrderVoList(int userId){
        List<OrderDetailVo> orderDetailVoList = new ArrayList<>();
        List<OrderVo> orderVoList = orderDao.getOrderVoListByUid(userId);
        if (orderVoList.size() == 0){
            return new ArrayList<>();
        }
        for (int i = 0;i < orderVoList.size();i++){
            OrderDetailVo orderDetailVo = new OrderDetailVo();
            OrderVo orderVo = orderVoList.get(i);
            System.out.println("??????id="+orderVo.getFilmOrder().getFilmScheduleId());
            // 1.??????FilmScheduleVo
            FilmScheduleVo filmScheduleVo = filmScheduleDao.getFilmScheduleById(orderVo.getFilmOrder().getFilmScheduleId());

            // 2.??????FilmVo

            List<FilmVo> filmVoList= filmDao.getFilmVoById(filmScheduleVo.getFilmSchedule().getFilmId());

            if (filmVoList.size() == 0){
                continue;
            }
            FilmVo filmVo = filmVoList.get(0);
            // 3.???????????????
            Cinema cinema = cinemaMapper.selectByPrimaryKey(filmScheduleVo.getHall().getCinemaId());

            orderDetailVo.setFilmOrder(orderVo.getFilmOrder());
            orderDetailVo.setTicketList(orderVo.getTicketList());
            orderDetailVo.setFilmScheduleVo(filmScheduleVo);
            orderDetailVo.setFilmVo(filmVo);
            orderDetailVo.setCinema(cinema);
            orderDetailVoList.add(orderDetailVo);
        }

        return orderDetailVoList;
    }
    @Override
    public OrderDetailVo getUserOrderDetail(String orderNo){
            OrderDetailVo orderDetailVo = new OrderDetailVo();
            OrderVo orderVo = orderDao.getOrderVoByNo(orderNo);
            // 1.??????FilmScheduleVo
            FilmScheduleVo filmScheduleVo = filmScheduleDao.getFilmScheduleById(orderVo.getFilmOrder().getFilmScheduleId());
            // 2.??????FilmVo
            List<FilmVo> filmVoList= filmDao.getFilmVoById(filmScheduleVo.getFilmSchedule().getFilmId());
            if (filmVoList.size() == 0){
                Asserts.fail("????????????");
            }
            FilmVo filmVo = filmVoList.get(0);
            // 3.???????????????
            Cinema cinema = cinemaMapper.selectByPrimaryKey(filmScheduleVo.getHall().getCinemaId());

            orderDetailVo.setFilmOrder(orderVo.getFilmOrder());
            orderDetailVo.setTicketList(orderVo.getTicketList());
            orderDetailVo.setFilmScheduleVo(filmScheduleVo);
            orderDetailVo.setFilmVo(filmVo);
            orderDetailVo.setCinema(cinema);
            return orderDetailVo;

    }

    @Override
    public void setPayStatus(String orderNo,int status){
        FilmOrder filmOrder = new FilmOrder();
        filmOrder.setFilmOrderId(orderNo);
        filmOrder.setPayStatus(status);

        filmOrderMapper.updateByPrimaryKeySelective(filmOrder);
    }
    @Override
    public void setPaySuccess(String orderNo){
        // ??????redis?????????
        OrderVo orderVo = orderDao.getOrderVoByNo(orderNo);
        unlockSeatList(orderVo);

        // ????????????????????????
        setPayStatus(orderNo,1);
    }
    @Override
    public void fetchTicket(String code){
        System.out.println("code=="+code);
        String orderNo = OrderNoUtil.authCode(code);
        FilmOrder filmOrder = filmOrderMapper.selectByPrimaryKey(orderNo);
        if (filmOrder == null){
            Asserts.fail(WRONG_CODE);
        }
        if (filmOrder.getPayStatus() != STATUS_PAYED){
            Asserts.fail(ORDER_ERROR);
        }
        if (filmOrder.getFetchStatus() == FETCHED){
            Asserts.fail(TICKET_FETCHED);
        }
        filmOrder.setFetchStatus(FETCHED);
        filmOrderMapper.updateByPrimaryKeySelective(filmOrder);
    }
}
