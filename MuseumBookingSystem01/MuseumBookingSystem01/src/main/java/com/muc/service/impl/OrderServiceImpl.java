package com.muc.service.impl;

import com.muc.mapper.OrderMapper;
import com.muc.pojo.Audience;
import com.muc.pojo.MuseumTicket;
import com.muc.pojo.Order;
import com.muc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> searchOrder(String phone,String state) {
        List<Order> orderList = orderMapper.searchOrderList(phone,state);
        for(Order order :orderList){
            if(order==null){
                break;
            }
            order.setAudienceList(orderMapper.searchAudienceList(order.getOrderId()));
            for(Audience audience :order.getAudienceList()){
                if(audience!=null){
                    audience.setMuseumTicketList(orderMapper.searchMuseumTicketList(order.getOrderId(),audience.getAudienceNo()));
                }
            }
        }
        return orderList;
    }

    @Override
    public void getRefundOfTicket(Order order) {
        for (Audience audience : order.getAudienceList()) {
            for (MuseumTicket museumTicket : audience.getMuseumTicketList()) {
                String ticketName = orderMapper.searchTicketName(museumTicket.getId());
                if(ticketName.equals("大门票")){
                    orderMapper.updateTicketState(order.getOrderId(),audience.getAudienceNo(),null);
                    break;
                }
                orderMapper.updateTicketState(order.getOrderId(),audience.getAudienceNo(),museumTicket.getId());
            }
        }

        List<String> ticketState = orderMapper.getTicketState(order.getOrderId());
        Boolean allRefund=true;
        for (String state :ticketState) {
            if(!"已退".equals(state)){
                allRefund = false;
                break;
            }
        }
        if(allRefund){
            orderMapper.updateRefundOrders(order.getOrderId());
        }
    }
    @Override
    public String getOrderId(Order order) {
        return orderMapper.selectOrderId(order.getOrderTime(),order.getPhone());
    }


    @Scheduled(cron = "0 30 15 * * ?") // 每天15:30更新过期订单
    public void updateExpiredOrders() {

        // 更新过期订单
        orderMapper.updateExpiredOrders();
//
//        // 更新订单状态为已过期
//        for (Order order : expiredOrders) {
//            order.setState("已过期");
//            orderMapper.updateOrderStatus(order);
//        }
    }

    @Override
    public Order searchOrderDetail(String orderId) {

        Order orderDetail = orderMapper.searchOrderDetail(orderId);
        if(orderDetail==null){
            return null;
        }
        orderDetail.setAudienceList(orderMapper.searchAudienceList(orderDetail.getOrderId()));
        for(Audience audience :orderDetail.getAudienceList()){
            if(audience!=null){
                audience.setMuseumTicketList(orderMapper.searchMuseumTicketList(orderDetail.getOrderId(),audience.getAudienceNo()));
            }
        }
        return orderDetail;
    }


}
