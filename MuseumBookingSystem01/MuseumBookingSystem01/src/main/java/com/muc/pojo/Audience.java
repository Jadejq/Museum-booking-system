package com.muc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Audience {
    private LocalDate date;//参观日期
    private String time;//参观时间
    private String docType;//证件类型
    private String id;//证件号
    private String name;//姓名
    private List<MuseumTicket> museumTicketList;
    private String audienceNo;//观众唯一编号

}
