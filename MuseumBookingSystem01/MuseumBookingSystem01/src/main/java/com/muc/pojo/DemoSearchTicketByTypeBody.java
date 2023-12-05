package com.muc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoSearchTicketByTypeBody{
    LocalDate visitDate;
    String visitTime;
    List<String> type;
}
