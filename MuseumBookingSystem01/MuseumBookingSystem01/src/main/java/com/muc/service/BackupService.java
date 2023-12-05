package com.muc.service;

import java.util.List;
import java.util.Map;

/**
 * @author 朱佳琦
 * @version 1.0
 */
public interface BackupService {
    List<Map<String, String>> queryBackup();
    String backup(String name);
    void restore(String name);
    void delBackup(String name);
}

