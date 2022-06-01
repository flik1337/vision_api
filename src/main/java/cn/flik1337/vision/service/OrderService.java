package cn.flik1337.vision.service;

import cn.flik1337.vision.vo.FilmScheduleVo;
import cn.flik1337.vision.vo.OrderDetailVo;
import cn.flik1337.vision.vo.OrderVo;

import java.util.HashMap;
import java.util.List;

public interface OrderService {

    public String createOrder(OrderVo orderVo);
    public void lockSeat(int scheduleId,int userId,int row,int column);
    public void lockSeatList(OrderVo orderVo);
    public void unlockSeatList(OrderVo orderVo);
    public void unlockSeat(int scheduleId,int userId,int row,int column);
    public int[][] getBannedSeats(int scheduleId);

    public List<OrderDetailVo>  getUserOrderVoList(int userId);
    public OrderDetailVo getUserOrderDetail(String orderNo);
    public void setPayStatus(String orderNo,int status);
    public void setPaySuccess(String orderNo);
    public void fetchTicket(String orderNo);
}
