package com.muc.mapper;

import com.muc.pojo.StatisticTickets;
import com.muc.pojo.StatisticTurnover;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Mapper
public interface StatisticsMapper {
    List<StatisticTickets> selectStatisticTicketByMonth(LocalDate start, LocalDate end);

    List<StatisticTickets> selectStatisticTicketByMonthSum(LocalDate start, LocalDate end);

    List<StatisticTickets> selectStatisticTicketByDay(LocalDate start, LocalDate end);

    List<StatisticTickets> selectStatisticTicketByDaySum(LocalDate start, LocalDate end);

    List<StatisticTickets> selectStatisticTicketByYear(LocalDate start, LocalDate end);

    List<StatisticTickets> selectStatisticTicketByYearSum(LocalDate start, LocalDate end);

    List<StatisticTickets> selectStatisticPeopleByMonth(LocalDate start, LocalDate end);

    List<StatisticTickets> selectStatisticPeopleByMonthSum(LocalDate start, LocalDate end);

    List<StatisticTickets> selectStatisticPeopleByDay(LocalDate start, LocalDate end);

    List<StatisticTickets> selectStatisticPeopleByDaySum(LocalDate start, LocalDate end);

    List<StatisticTickets> selectStatisticPeopleByYear(LocalDate start, LocalDate end);

    List<StatisticTickets> selectStatisticPeopleByYearSum(LocalDate start, LocalDate end);

    List<StatisticTurnover> selectStatisticTurnover(LocalDate start, LocalDate end, String timeFormat);

    List<StatisticTurnover> selectStatisticTurnoverSum(LocalDate start, LocalDate end, String timeFormat);
}
