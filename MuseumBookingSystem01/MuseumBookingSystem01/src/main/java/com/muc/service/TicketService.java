package com.muc.service;

import com.muc.pojo.PageBean;
import com.muc.pojo.Ticket;

import java.time.LocalDate;

/**
 * @author 朱佳琦
 * @version 1.0
 */
public interface TicketService {
    PageBean page(Integer page, Integer pageSize,LocalDate date, String time, String museum);

    void add(Ticket ticket);

}
