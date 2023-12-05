package com.muc.service;

import com.muc.pojo.Audience;
import com.muc.pojo.MuseumTicket;
import com.muc.pojo.MuseumTicketInformation;
import com.muc.pojo.Order;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
public interface BookTicketService {
    MuseumTicketInformation getmuseumTicketInfo(String visitTime,LocalDate visitDate, String season);

    void insertOrder(Order order);

    void payOrder(String orderId);


    List<List<MuseumTicket>> getOtherMuseumTicketInfo(String visitTime, LocalDate visitDate, String season,List<String> type);

    Audience getOrderedAudience(String id, String visitDate);
}
