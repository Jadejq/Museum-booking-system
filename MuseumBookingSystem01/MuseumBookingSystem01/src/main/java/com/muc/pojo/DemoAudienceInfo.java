package com.muc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoAudienceInfo {
    private String visitDate;
    private String visitTime;
    private List<String> ticketCounters;
    private String phone;
    private List<Audience> audienceInfo;
}
