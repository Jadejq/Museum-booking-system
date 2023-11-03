package com.muc.mapper;


import com.muc.pojo.Ticket;
import org.apache.ibatis.annotations.Mapper;
import java.time.LocalDate;
import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Mapper
public interface TicketMapper {
    List<Ticket> list(LocalDate date, String time, String museum);

    void insert(Ticket ticket);
}
