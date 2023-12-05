package com.muc.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.muc.pojo.*;
import com.muc.service.BookTicketService;
import com.muc.service.OrderService;
import com.muc.service.RegularAudienceService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/book_ticket")
@CrossOrigin
public class BookTicketController {
    @Autowired
    private BookTicketService bookTicketService;
    @Autowired
    private RegularAudienceService regularAudienceService;
    @Autowired
    private OrderService orderService;

    @PostMapping("submit")
    public Result bookTicket(@RequestBody Order order){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        order.setOrderTime(LocalDateTime.now().format(formatter));
        order.setTotalPrice(0.0);
//        System.out.println(LocalDateTime.now().format(formatter));
        log.info("提交订单：{}",order);
        bookTicketService.insertOrder(order);
        String orderId = orderService.getOrderId(order);
        return Result.success(orderId);
    }
    @GetMapping
    public Result getMuseumTicketInformation(String visitTime, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate visitDate){

        log.info("查询大门票信息：{},{}",visitDate,visitTime);
        String season;
        int month = visitDate.getMonthValue();
        // 判断 visitDate 是否在4月到10月之间
        if (month >= 4 && month <= 10) {
            season="旺季";
        } else {
            season="淡季";
        }
        MuseumTicketInformation museumTicketInformation = bookTicketService.getmuseumTicketInfo(visitTime,visitDate,season);
        if(museumTicketInformation.getTicketRemain() == null){
            return Result.error("暂无余票");
        }
        if(museumTicketInformation.getTicketRemain()<=0)
            return Result.error("暂无余票");
        return  Result.success(museumTicketInformation);
    }
    @PostMapping
    public Result Next(){
        return  Result.success();
    }
    @GetMapping("pay")
    public Result payOrder(String orderId){
        log.info("{}订单支付",orderId);
        bookTicketService.payOrder(orderId);
        return Result.success();
    }
    @GetMapping("audience_info")
    public Result searchRegularAudienceById(@RequestParam String phone){
        log.info("根据phone查询常用观众，{}",phone);
        List<RegularAudience> regularAudienceList = regularAudienceService.selectByPhone(phone);
        return Result.success(regularAudienceList);
    }
    @PostMapping("audience_info")
    public Result AudienceNext(@RequestBody DemoAudienceInfo demoAudienceInfo){
        log.info("检查观众信息，{}",demoAudienceInfo);
        List<String> ids=new ArrayList<>();
        for (Audience audience :demoAudienceInfo.getAudienceInfo()) {
            ids.add(audience.getId());
        }
        Set<String> set = new HashSet<>();
        Boolean repeat=false;
        for (String element : ids) {
            // 如果添加失败（即已经存在相同的元素），说明有重复
            if (!set.add(element)) {
                repeat =true;
                return Result.error("有重复观众");
            }
        }
        for (Audience audience :demoAudienceInfo.getAudienceInfo()) {
            System.out.println();
            System.out.println("进入for");
            System.out.println(bookTicketService.getOrderedAudience(audience.getId(),demoAudienceInfo.getVisitDate())!=null);
            if(bookTicketService.getOrderedAudience(audience.getId(),demoAudienceInfo.getVisitDate())!=null){
                System.out.println("观众："+audience.getName()+"已预约"+demoAudienceInfo.getVisitDate()+"参观");
                return Result.error("观众："+audience.getName()+"已预约"+demoAudienceInfo.getVisitDate()+"参观");
            }

        }
        return Result.success();
    }


    @PostMapping("ticket_info")
    public Result searchTicketByType(@RequestBody DemoSearchTicketByTypeBody searchTicketByTypeBody){
        log.info("根据观众类型查询票信息，{},{},{}",searchTicketByTypeBody.getVisitDate(),searchTicketByTypeBody.getVisitTime(),searchTicketByTypeBody.getType());
        String season;
        int month = searchTicketByTypeBody.getVisitDate().getMonthValue();
        // 判断 visitDate 是否在4月到10月之间
        if (month >= 4 && month <= 10) {
            season="旺季";
        } else {
            season="淡季";
        }
        List<List<MuseumTicket>> museumTicketLists = bookTicketService.getOtherMuseumTicketInfo(searchTicketByTypeBody.getVisitTime(),searchTicketByTypeBody.getVisitDate(),season,searchTicketByTypeBody.getType());

        return  Result.success(museumTicketLists);
    }
}
