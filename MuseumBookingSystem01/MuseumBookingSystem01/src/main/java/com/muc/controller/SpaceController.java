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
@RequestMapping("/space")
@CrossOrigin
public class SpaceController {
    @Autowired
    private GuestService guestService;
    @GetMapping
    public Result getInfoByPhone(@RequestParam String phone){
        log.info("游客个人信息：{}",phone);
        Guest guest = guestService.getInfoByPhone(phone);
        return Result.success(guest);
    }
}
