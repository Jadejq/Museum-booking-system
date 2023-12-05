package com.muc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MuseumTicket {
    private String id;
    private String museum;
    private String type;
    private String season;
    private String price;
    private String state;
    private String remain;
}
