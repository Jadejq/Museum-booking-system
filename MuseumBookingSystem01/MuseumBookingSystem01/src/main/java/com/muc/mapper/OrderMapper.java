package com.muc.mapper;

import com.muc.pojo.Audience;
import com.muc.pojo.MuseumTicket;
import com.muc.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Mapper
public interface OrderMapper {

    List<Order> searchOrderList(String phone,String state);

    List<Audience> searchAudienceList(String orderId);

    List<MuseumTicket> searchMuseumTicketList(String orderId,String audienceNo);

//    List<Order> getExpiredOrders(String currentTime);

    void updateExpiredOrders();

    String searchTicketName(String id);

    void updateTicketState(String orderId, String audienceNo, String id);

    List<String> getTicketState(String orderId);

    void updateRefundOrders(String orderId);

    Order searchOrderDetail(String orderId);

    String selectOrderId(String orderTime, String phone);



//    void updateTicketState(Order);
}
