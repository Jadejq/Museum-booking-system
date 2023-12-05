package com.muc.controller;

import com.muc.pojo.Guest;
import com.muc.pojo.Result;
import com.muc.service.GuestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/signin_guest")
@CrossOrigin
public class GuestSignInController {
    @Autowired
    private GuestService guestService;
    @PostMapping
    public Result signIn(@RequestBody Guest guest){
        log.info("游客注册：{}",guest);
        Guest g = guestService.login(guest);
        if(g==null){
            guestService.signIn(guest);
        }
        return g != null? Result.error("手机号已注册"):Result.success();
    }
}
