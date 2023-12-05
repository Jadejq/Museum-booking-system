package com.muc.service;

import com.muc.pojo.Order;

import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
public interface OrderService {
    List<Order> searchOrder(String phone,String state);

    void getRefundOfTicket(Order order);
    public void updateExpiredOrders();

    Order searchOrderDetail(String orderId);

    String getOrderId(Order order);

}
