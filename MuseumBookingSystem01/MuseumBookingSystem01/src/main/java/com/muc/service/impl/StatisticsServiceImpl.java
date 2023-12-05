package com.muc.service.impl;

import com.muc.mapper.BookTicketMapper;
import com.muc.mapper.StatisticsMapper;
import com.muc.pojo.StatisticTickets;
import com.muc.pojo.StatisticTurnover;
import com.muc.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private StatisticsMapper statisticsMapper;
    @Override
    public List<StatisticTickets> statisticTickets(LocalDate start, LocalDate end, String span) {
        List<StatisticTickets> statisticTicketsList = new ArrayList<>();
        if("month".equals(span)){
            statisticTicketsList=statisticsMapper.selectStatisticTicketByMonth(start,end);
            List<StatisticTickets> sum =statisticsMapper.selectStatisticTicketByMonthSum(start,end);
            for (StatisticTickets statisticTickets :sum) {
                statisticTickets.setTime("总计");
            }
            statisticTicketsList.addAll(sum);
        }
        else if("day".equals(span)){
            statisticTicketsList=statisticsMapper.selectStatisticTicketByDay(start,end);
            List<StatisticTickets> sum =statisticsMapper.selectStatisticTicketByDaySum(start,end);
            for (StatisticTickets statisticTickets :sum) {
                statisticTickets.setTime("总计");
            }
            statisticTicketsList.addAll(sum);
        }
        else{
            statisticTicketsList=statisticsMapper.selectStatisticTicketByYear(start,end);
            List<StatisticTickets> sum =statisticsMapper.selectStatisticTicketByYearSum(start,end);
            for (StatisticTickets statisticTickets :sum) {
                statisticTickets.setTime("总计");
            }
            statisticTicketsList.addAll(sum);
        }
        System.out.println(statisticTicketsList);
        return statisticTicketsList;
    }

    @Override
    public List<StatisticTickets> statisticPeople(LocalDate start, LocalDate end, String span) {
        List<StatisticTickets> statisticTicketsList = new ArrayList<>();
        if("month".equals(span)){
            statisticTicketsList=statisticsMapper.selectStatisticPeopleByMonth(start,end);
            List<StatisticTickets> sum =statisticsMapper.selectStatisticPeopleByMonthSum(start,end);
            for (StatisticTickets statisticTickets :sum) {
                statisticTickets.setTime("总计");
            }
            statisticTicketsList.addAll(sum);
        }
        else if("day".equals(span)){
            statisticTicketsList=statisticsMapper.selectStatisticPeopleByDay(start,end);
            List<StatisticTickets> sum =statisticsMapper.selectStatisticPeopleByDaySum(start,end);
            for (StatisticTickets statisticTickets :sum) {
                statisticTickets.setTime("总计");
            }
            statisticTicketsList.addAll(sum);
        }
        else{
            statisticTicketsList=statisticsMapper.selectStatisticPeopleByYear(start,end);
            List<StatisticTickets> sum =statisticsMapper.selectStatisticPeopleByYearSum(start,end);
            for (StatisticTickets statisticTickets :sum) {
                statisticTickets.setTime("总计");
            }
            statisticTicketsList.addAll(sum);
        }
        System.out.println(statisticTicketsList);
        return statisticTicketsList;
    }

    @Override
    public List<StatisticTurnover> statisticTurnover(LocalDate start, LocalDate end, String span) {
        List<StatisticTurnover> statisticTurnoverList = new ArrayList<>();

        String timeFormat="%Y";
        if("month".equals(span)){
            timeFormat="%Y-%m";
        }
        else if("day".equals(span)){
            timeFormat="%Y-%m-%d";
        }

        statisticTurnoverList=statisticsMapper.selectStatisticTurnover(start,end,timeFormat);
        List<StatisticTurnover> sum =statisticsMapper.selectStatisticTurnoverSum(start,end,timeFormat);
        for (StatisticTurnover statisticTurnover :sum) {
            statisticTurnover.setTime("总计");
        }
        statisticTurnoverList.addAll(sum);
        System.out.println(statisticTurnoverList);
        return statisticTurnoverList;
    }
}
