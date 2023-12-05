package com.muc.controller;

import com.muc.pojo.Admin;
import com.muc.pojo.Result;
import com.muc.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/LoginComponent_admin")
@CrossOrigin
public class AdminLoginController {
    @Autowired
    private AdminService adminService;
    @PostMapping
    public Result login(@RequestBody Admin admin){
        log.info("管理员登录：{}",admin);
        Admin a = adminService.login(admin);
        return a != null? Result.success():Result.error("用户名或密码错误");
    }
}
