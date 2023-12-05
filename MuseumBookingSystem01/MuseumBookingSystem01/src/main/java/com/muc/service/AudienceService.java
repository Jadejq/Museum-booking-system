package com.muc.service;

import com.muc.pojo.PageBean;

import java.time.LocalDate;

/**
 * @author 朱佳琦
 * @version 1.0
 */
public interface AudienceService {
    PageBean page(Integer page, Integer pageSize, LocalDate date, String time, String id);
}
