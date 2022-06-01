package cn.flik1337.vision.controller;

import cn.flik1337.vision.common.api.CommonResult;
import cn.flik1337.vision.common.utils.OrderNoUtil;
import cn.flik1337.vision.common.utils.QrCodeUtil;
import cn.flik1337.vision.mbg.model.FilmSchedule;
import cn.flik1337.vision.service.OrderService;
import cn.flik1337.vision.vo.FilmScheduleVo;
import cn.flik1337.vision.vo.OrderDetailVo;
import cn.flik1337.vision.vo.OrderVo;
import cn.hutool.db.sql.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public CommonResult createOrder(@RequestBody OrderVo orderVo){
        String orderNo =  orderService.createOrder(orderVo);
        return CommonResult.success(orderNo);

    }

    @RequestMapping(value = "/lock",method = RequestMethod.POST)
    public CommonResult lockSeat(@RequestBody OrderVo orderVo){
        orderService.lockSeatList(orderVo);
        return CommonResult.success(null);

    }
    @RequestMapping(value = "/unlock",method = RequestMethod.POST)
    public CommonResult unlockSeat(@RequestBody OrderVo orderVo){
        orderService.unlockSeatList(orderVo);
        return CommonResult.success(null);

    }
    @RequestMapping(value = "/bannedSeats",method = RequestMethod.GET)
    public CommonResult getBannedSeats(@RequestParam("scheduleId")int scheduleId){
        int[][] seats =  orderService.getBannedSeats(scheduleId);
        if (seats != null) {
            return CommonResult.success(seats);
        }
        return CommonResult.failed();

    }
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult getUserOrderVoList(@RequestParam("userId")int userId){
        List<OrderDetailVo> orderVoList = orderService.getUserOrderVoList(userId);
        return CommonResult.success(orderVoList);
    }
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public CommonResult getUserOrderDetail(@RequestParam("orderNo")String orderNo){
        OrderDetailVo orderDetail = orderService.getUserOrderDetail(orderNo);
        return CommonResult.success(orderDetail);
    }

    @RequestMapping(value = "/pay/success",method = RequestMethod.GET)
    public CommonResult setOrderPaySuccess(@RequestParam("orderNo")String orderNo){
        orderService.setPaySuccess(orderNo);
        return CommonResult.success();
    }

    @RequestMapping(value = "/code",method = RequestMethod.GET)
    public CommonResult getOrderCode(@RequestParam("orderNo")String orderNo) throws Exception {

        String code = OrderNoUtil.generateAuthCode(orderNo);
        String imgBase64 =  QrCodeUtil.encodeToBase64(code);
        HashMap<String,Object> results = new HashMap<>();
        results.put("code",code);
        results.put("qrCode",imgBase64);
        return CommonResult.success(results);

    }
    @RequestMapping(value = "/fetch",method = RequestMethod.GET)
    public CommonResult fetchTicket(@RequestParam("code")String code) throws Exception {

        orderService.fetchTicket(code);
        return CommonResult.success();

    }

}
