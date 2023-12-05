package com.muc.controller;

import com.muc.pojo.Result;
import com.muc.service.BackupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/backup")
@CrossOrigin
public class BackupController {

    @Autowired
    private BackupService backupService;
    // 获取备份记录
    @GetMapping
    public Result getBackup(){
        return Result.success(backupService.queryBackup());
    }
    // 备份
    @PostMapping
    public Result backup(@RequestParam String fileName){
        String s =backupService.backup(fileName);
        return "数据备份失败".equals(s)?Result.error(s):Result.success();
    }
    // 恢复
    @PostMapping("restore")
    public Result restore(@RequestParam String fileName){
        backupService.restore(fileName);
        return Result.success();
    }
    // 删除备份记录
    @DeleteMapping
    public Result delBackup(@RequestParam String fileName){
        backupService.delBackup(fileName);
        return Result.success();
    }
}

