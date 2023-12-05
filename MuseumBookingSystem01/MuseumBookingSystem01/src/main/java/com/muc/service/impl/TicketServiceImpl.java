package com.muc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.muc.mapper.TicketMapper;
import com.muc.pojo.PageBean;
import com.muc.pojo.Ticket;
import com.muc.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketMapper ticketMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize, LocalDate date, String time, String museum) {
        PageHelper.startPage(page,pageSize);
        List<Ticket> ticketList = ticketMapper.list(date,time,museum);
        Page<Ticket> p = (Page<Ticket>) ticketList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void add(Ticket ticket) {
        ticket.setTicketsRemain(ticket.getTotalTickets());
        ticket.setTicketsSold(0);
        ticketMapper.insert(ticket);
    }
}
