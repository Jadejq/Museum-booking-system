package com.muc.controller;

import com.muc.pojo.RegularAudience;
import com.muc.pojo.Result;
import com.muc.service.RegularAudienceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */

@Slf4j
@RestController
@RequestMapping("/g_regular")
@CrossOrigin
public class RegularAudienceController {
    @Autowired
    private RegularAudienceService regularAudienceService;


    @PostMapping
    public Result add(@RequestBody RegularAudience regularAudience){//@RequestBody ：将json类的数据封装到实体类中
        log.info("新增常用观众"+regularAudience.getName());
        if (regularAudienceService.add(regularAudience)) {
            return Result.success();
        }
        else {
            return Result.error("常用观众信息重复");
        }
    }
    @GetMapping
    public Result searchById(@RequestParam String phone){
        log.info("根据phone查询常用观众");
        List<RegularAudience> regularAudienceList = regularAudienceService.selectByPhone(phone);
        return Result.success(regularAudienceList);

    }

    @DeleteMapping
    public Result delete(@RequestParam String phone,@RequestParam String id){
        log.info("根据id和电话删除常用观众");
        regularAudienceService.delete(phone,id);
        return Result.success();
    }

    @PutMapping
    public Result modify(@RequestBody RegularAudience regularAudience){//@RequestBody ：将json类的数据封装到实体类中
        log.info("修改常用观众");
        regularAudienceService.modify(regularAudience);
        return Result.success();
    }

}
