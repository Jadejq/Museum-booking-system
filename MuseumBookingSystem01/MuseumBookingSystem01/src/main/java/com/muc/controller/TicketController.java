package com.muc.controller;


import com.muc.pojo.PageBean;
import com.muc.pojo.Result;
import com.muc.pojo.Ticket;
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
@RequestMapping("/tickets")
@CrossOrigin
public class TicketController {
    @Autowired
    private TicketService ticketService;


    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pageSize,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                       String time,
                       String museum){
        log.info("分页查询，参数：{},{},{},{},{}",page,pageSize,date,time,museum);

        PageBean pageBean = ticketService.page(page, pageSize,date,time,museum);
        return Result.success(pageBean);


    }

    @PostMapping
    public Result add(@RequestBody Ticket ticket) {//@RequestBody ：将json类的数据封装到实体类中
        log.info("新增票");
        ticketService.add(ticket);
        return Result.success();
    }

}
