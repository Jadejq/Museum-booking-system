package com.muc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.muc.mapper.AudienceMapper;
import com.muc.pojo.Audience;
import com.muc.pojo.PageBean;
import com.muc.service.AudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Service
public class AudienceServiceImpl implements AudienceService {
    @Autowired
    private AudienceMapper audienceMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize, LocalDate date, String time, String id) {
        PageHelper.startPage(page,pageSize);
        List<Audience> audienceList = audienceMapper.list(date,time,id);
        Page<Audience> p = (Page<Audience>) audienceList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;

    }
}
