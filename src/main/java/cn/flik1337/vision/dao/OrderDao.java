package cn.flik1337.vision.dao;

import cn.flik1337.vision.mbg.model.Ticket;
import cn.flik1337.vision.vo.OrderVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface OrderDao {
    OrderVo getOrderVoByNo(@Param("orderNo") String orderNo);

    List<OrderVo> getOrderVoListByUid(@Param("userId")int userId);

    List<Ticket> getTicketListByScheduleId(@Param("scheduleId")int scheduleId);

    List<Ticket> getTicketListByOrderNo(@Param("orderNo") String orderNo);
}
