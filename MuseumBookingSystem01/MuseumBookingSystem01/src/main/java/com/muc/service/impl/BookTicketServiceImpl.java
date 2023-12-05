package com.muc.service.impl;

import com.muc.mapper.BookTicketMapper;
import com.muc.mapper.GuestMapper;
import com.muc.pojo.Audience;
import com.muc.pojo.MuseumTicket;
import com.muc.pojo.MuseumTicketInformation;
import com.muc.pojo.Order;
import com.muc.service.BookTicketService;
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
public class BookTicketServiceImpl implements BookTicketService {
    @Autowired
    private BookTicketMapper bookTicketMapper;

    @Override
    public MuseumTicketInformation getmuseumTicketInfo(String visitTime, LocalDate visitDate,String season) {

        MuseumTicketInformation museumTicketInformation
                =new MuseumTicketInformation(bookTicketMapper.selectTicketRemain(visitTime,visitDate), bookTicketMapper.selectTicketType(season));
        return museumTicketInformation;
    }

    @Override
    public void insertOrder(Order order) {
        bookTicketMapper.insertOrder(order);
        order.setOrderId(bookTicketMapper.selectOrderId(order));

        String season;
        int month = order.getVisitDate().getMonthValue();

        // 判断 visitDate 是否在4月到10月之间
        if (month >= 4 && month <= 10) {
            season="旺季";
        } else {
            season="淡季";
        }
        for (Audience audience : order.getAudienceList()) {
            String audienceNo1=bookTicketMapper.selectVisitorById(audience.getId());
            if(audienceNo1==null){
                bookTicketMapper.insertAudience(audience);
                audienceNo1 = bookTicketMapper.selectVisitorById(audience.getId());
            }
            for (MuseumTicket museumTicket1 : audience.getMuseumTicketList()) {
                museumTicket1.setSeason(season);
                String museumTicketNo1 = bookTicketMapper.selectTicketNo(museumTicket1);
                bookTicketMapper.insertBookTicket(order.getOrderId(),audienceNo1,museumTicketNo1);
            }
        }


    }

    @Override
    public void payOrder(String orderId) {
        bookTicketMapper.updateStateAndPayment(orderId);
    }

    @Override
    public List<List<MuseumTicket>> getOtherMuseumTicketInfo(String visitTime, LocalDate visitDate, String season,List<String> types) {
        List<List<MuseumTicket>> museumTicketLists = new ArrayList<>();
        for (String type :types) {
            List<MuseumTicket> museumTicketList
                    =bookTicketMapper.selectOtherTicketInfoByTime(visitTime,visitDate,season,type);
            museumTicketLists.add(museumTicketList);
        }

//
//        return museumTicketInformation;
        return museumTicketLists;
    }

    @Override
    public Audience getOrderedAudience(String id, String visitDate) {
        return bookTicketMapper.getOrderedAudience(id,visitDate);
    }


}
