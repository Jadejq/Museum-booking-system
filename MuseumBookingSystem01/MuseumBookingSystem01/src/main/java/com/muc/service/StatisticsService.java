package com.muc.service;

import com.muc.pojo.StatisticTickets;
import com.muc.pojo.StatisticTurnover;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
public interface StatisticsService {
    List<StatisticTickets> statisticTickets(LocalDate start, LocalDate end, String span);

    List<StatisticTickets> statisticPeople(LocalDate start, LocalDate end, String span);

    List<StatisticTurnover> statisticTurnover(LocalDate start, LocalDate end, String span);

}
