package com.muc.controller;

import com.muc.pojo.PageBean;
import com.muc.pojo.Result;
import com.muc.service.AudienceService;
import com.muc.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/audiences")
@CrossOrigin
public class AudienceController {
    @Autowired
    private AudienceService audienceService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                       String time,
                       String id){
        log.info("分页查询，参数：{},{},{},{},{}",page,pageSize,date,time,id);

        PageBean pageBean = audienceService.page(page, pageSize,date,time,id);
        return Result.success(pageBean);


    }
}
