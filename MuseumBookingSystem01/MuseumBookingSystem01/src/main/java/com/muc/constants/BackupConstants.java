package com.muc.constants;



import java.io.File;

/**
 * @author 朱佳琦
 * @version 1.0
 */
public interface BackupConstants {
    /** 备份目录名称 */
    public static final String BACKUP_FOLDER_NAME = "_backup";
    public static final String FOLDER_NAME="D:\\study\\junior\\database\\MuseumBookingSystem01\\";
    /** 备份目录 */
    public static final String BACKUP_FOLDER = FOLDER_NAME + BACKUP_FOLDER_NAME + File.separator;
    /** 还原目录，默认就是备份目录 */
    public static final String RESTORE_FOLDER = BACKUP_FOLDER;
    /** SQL拓展名 */
    public static final String SQL_EXT = ".sql";

    /** 目标备份数据库信息 */
    public static final String HOST = "localhost";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "zjq123";
    public static final String DATABASE = "backuptest";
}
