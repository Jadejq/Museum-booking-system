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
public class TicketController {
    @Autowired
    private TicketService ticketService;


    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                       String time,
                       String museum){
        log.info("分页查询，参数：{},{},{},{},{}",page,pageSize,date,time,museum);

        PageBean pageBean = ticketService.page(page, pageSize,date,time,museum);
        return Result.success(pageBean);


    }

//    @DeleteMapping("/{id}")
//    public Result delete(@PathVariable Integer id) {
//        log.info("根据id删除部门");
//        deptService.delete(id);
//        return Result.success();
//    }
//
    @PostMapping
    public Result add(@RequestBody Ticket ticket) {//@RequestBody ：将json类的数据封装到实体类中
        log.info("新增部门");
        ticketService.add(ticket);
        return Result.success();
    }
//
//    @GetMapping("/{id}")
//    public Result searchById(@PathVariable Integer id) {
//        log.info("根据id查询部门");
//        Dept dept = deptService.selectById(id);
//        return Result.success(dept);
//    }
//
//    @PutMapping
//    public Result modify(@RequestBody Dept dept) {//@RequestBody ：将json类的数据封装到实体类中
//        log.info("修改部门");
//        deptService.modify(dept);
//        return Result.success();
//    }
}
