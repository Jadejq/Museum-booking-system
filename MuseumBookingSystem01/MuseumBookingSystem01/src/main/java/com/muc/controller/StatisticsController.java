package com.muc.controller;

import com.muc.pojo.Order;
import com.muc.pojo.Result;
import com.muc.pojo.StatisticTickets;
import com.muc.pojo.StatisticTurnover;
import com.muc.service.GuestService;
import com.muc.service.StatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/statistics")
@CrossOrigin
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;
    @GetMapping("museum")
    public Result statisticsOrderTickets(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start,@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,String span ){
        log.info("统计售票数据，参数：{},{},{}",start,end,span);
        List<StatisticTickets> statisticTicketsList;
        statisticTicketsList = statisticsService.statisticTickets(start,end,span);
        return Result.success(statisticTicketsList);
    }

    @GetMapping("people")
    public Result statisticsOrderPeople(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start,@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,String span ){
        log.info("统计进馆人群类型，参数：{},{},{}",start,end,span);
        List<StatisticTickets> statisticTicketsList;
        statisticTicketsList = statisticsService.statisticPeople(start,end,span);
        return Result.success(statisticTicketsList);
    }

    @GetMapping("turnover")
    public Result statisticsOrderTurnover(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start,@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,String span ){
        log.info("统计进馆人群类型，参数：{},{},{}",start,end,span);
        List<StatisticTurnover> statisticTurnoverList;
        statisticTurnoverList = statisticsService.statisticTurnover(start,end,span);
        return Result.success(statisticTurnoverList);
    }
}
