package com.muc.controller;

import com.muc.pojo.Admin;
import com.muc.pojo.Guest;
import com.muc.pojo.Result;
import com.muc.service.GuestService;
import com.muc.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/LoginComponent_guest")
@CrossOrigin
public class GuestLoginController {
    @Autowired
    private GuestService guestService;
    @PostMapping
    public Result login(@RequestBody Guest guest){
        log.info("游客登录：{}",guest);
        Guest g = guestService.login(guest);
//        if(g != null){
//            Map<String,Object> claims = new HashMap<>();
//            claims.put("phone",g.getPhone());
//            claims.put("uid",g.getUid());
//            String jwt = JwtUtils.generateJwt(claims);
//            return Result.success(jwt);
//        }

        return g != null?Result.success():Result.error("手机号未注册");
    }
}
