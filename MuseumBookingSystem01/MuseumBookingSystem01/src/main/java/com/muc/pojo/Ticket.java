package com.muc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author 朱佳琦
 * @version 1.0
 * 售票信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private LocalDate date; //参观日期
    private String time;//参观时间
    private String museum;//馆票名称
    private Integer totalTickets;//总票数
    private Integer ticketsSold;//售票数量
    private Integer ticketsRemain;//余票数量
}
