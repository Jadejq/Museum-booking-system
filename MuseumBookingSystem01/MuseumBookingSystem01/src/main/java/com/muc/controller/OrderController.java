package com.muc.controller;

import com.muc.pojo.Order;
import com.muc.pojo.PageBean;
import com.muc.pojo.Result;
import com.muc.service.GuestService;
import com.muc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public Result searchOrder(String phone,String state){
        log.info("用户查询订单，参数：{}",phone);
        List<Order> orderList;
        orderList = orderService.searchOrder(phone,state);
        return Result.success(orderList);
    }

    @GetMapping("detail")
    public Result searchOrderDetail(String phone,String orderId){
        log.info("用户查询订单详情，参数：{}",phone,orderId);
        Order orderDetail;
        orderDetail = orderService.searchOrderDetail(orderId);
        return Result.success(orderDetail);
    }

    @PostMapping
    public Result getRefundOfTicket(@RequestBody Order order){
        orderService.getRefundOfTicket(order);
        String orderId = orderService.getOrderId(order);
        return Result.success(orderId);
    }
}
