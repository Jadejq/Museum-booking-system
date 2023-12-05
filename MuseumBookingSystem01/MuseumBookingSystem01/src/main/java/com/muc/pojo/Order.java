package com.muc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String orderId;
    private String orderTime;
    private LocalDate visitDate;
    private String visitTime;
    private Double totalPrice;
    private String state;
    private String phone;
    private List<Audience> audienceList;
    private Double actualPayment;

}
