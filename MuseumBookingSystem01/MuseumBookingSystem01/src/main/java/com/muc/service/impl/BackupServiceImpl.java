package com.muc.service.impl;

import com.muc.constants.BackupConstants;
import com.muc.service.BackupService;
import com.muc.utils.FileUtils;
import com.muc.utils.MySqlBackupRestoreUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Service
public class BackupServiceImpl implements BackupService {
    @Override
    public List<Map<String, String>> queryBackup(){
        List<Map<String, String>> backupRecords = new ArrayList<>();
        File restoreFolderFile = new File(BackupConstants.RESTORE_FOLDER);
        if(restoreFolderFile.exists()) {
            for(File file:restoreFolderFile.listFiles()) {
                Map<String, String> backup = new HashMap<>();
                backup.put("fileName", file.getName());
                backupRecords.add(backup);
            }
        }
        // 按时间戳排序，新备份在前面
        backupRecords.sort((o1, o2) -> o2.get("fileName").compareTo(o1.get("fileName")));
        return backupRecords;
    }

    @Override
    public String backup(String name){
        String s= null;
        String host = BackupConstants.HOST;
        String userName = BackupConstants.USER_NAME;
        String password = BackupConstants.PASSWORD;
        String database = BackupConstants.DATABASE;
        String backupFolderPath = BackupConstants.BACKUP_FOLDER + name + File.separator;
        String fileName = name;
        try {
            boolean success = MySqlBackupRestoreUtils.backup(host, userName, password, backupFolderPath, fileName, database);
            if(!success) {
                System.out.println("数据备份失败");
                s="数据备份失败";
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        finally {
            return s;
        }
    }

    @Override
    public void restore(String name){
        String host = BackupConstants.HOST;
        String userName = BackupConstants.USER_NAME;
        String password = BackupConstants.PASSWORD;
        String database = BackupConstants.DATABASE;
        String restoreFilePath = BackupConstants.RESTORE_FOLDER + name;
        try {
            MySqlBackupRestoreUtils.restore(restoreFilePath, host, userName, password, database);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void delBackup(String name){
        String restoreFilePath = BackupConstants.BACKUP_FOLDER + name;
        try {
            FileUtils.deleteFile(new File(restoreFilePath));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
