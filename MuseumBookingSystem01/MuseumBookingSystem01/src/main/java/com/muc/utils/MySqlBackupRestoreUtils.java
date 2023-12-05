package com.muc.utils;

/**
 * @author 朱佳琦
 * @version 1.0
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * MySQL备份还原工具类
 */
public class MySqlBackupRestoreUtils {

    /**
     * 备份数据库
     * @param host host地址，可以是本机也可以是远程
     * @param userName 数据库的用户名
     * @param password 数据库的密码
     * @param backupFolderPath 备份的路径
     * @param fileName 备份的文件名
     * @param database 需要备份的数据库的名称
     * @return
     * @throws IOException
     */
    public static boolean backup(String host, String userName, String password, String backupFolderPath, String fileName,
                                 String database) throws Exception {
        File backupFolderFile = new File(backupFolderPath);
        if (!backupFolderFile.exists()) {
            // 如果目录不存在则创建
            backupFolderFile.mkdirs();
        }
        if (!backupFolderPath.endsWith(File.separator) && !backupFolderPath.endsWith("/")) {
            backupFolderPath = backupFolderPath + File.separator;
        }

        String mysqldumpPath = "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump";

        // 拼接命令行的命令
        String backupFilePath = backupFolderPath + fileName;
        String command = mysqldumpPath + " --opt --add-drop-database --add-drop-table -h " + host + " -u " + userName +
                " -p" + password + " --result-file=" + backupFilePath + ".sql --default-character-set=utf8 " + database;

        System.out.println(command);

        // 调用外部执行 exe 文件的 Java API
        Process process = Runtime.getRuntime().exec(command);
        if (process.waitFor() == 0) {
            // 0 表示线程正常终止
            System.out.println("数据已经备份到 " + backupFilePath + " 文件中");
            return true;
        }
        else {
            System.out.println("数据备份失败");

            // 输出错误信息
            InputStream errorStream = process.getErrorStream();
            byte[] errorBytes = new byte[errorStream.available()];
            errorStream.read(errorBytes);
            System.out.println(new String(errorBytes));

            return false;
        }

    }

    /**
     * 还原数据库
     * @param restoreFilePath 数据库备份的脚本路径
     * @param host IP地址
     * @param database 数据库名称
     * @param userName 用户名
     * @param password 密码
     * @return
     */

    public static boolean restore(String restoreFilePath, String host, String userName, String password, String database)
            throws Exception {
        File restoreFile = new File(restoreFilePath);
        if (restoreFile.isDirectory()) {
            for (File file : restoreFile.listFiles()) {
                if (file.exists() && file.getPath().endsWith(".sql")) {
                    restoreFilePath = file.getAbsolutePath();
                    break;
                }
            }
        }

        String mysqlPath = "\"C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysql\"";
        String command = "cmd /c " + mysqlPath + " -h " + host + " -u " + userName + " -p" + password + " " + database + " < " + restoreFilePath;

        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", command);
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            // 读取输出（标准和错误）
            InputStream inputStream = process.getInputStream();
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            System.out.println(new String(bytes));

            if (exitCode == 0) {
                System.out.println("数据已从 " + restoreFilePath + " 导入到数据库中");
                return true;
            } else {
                System.out.println("数据从 " + restoreFilePath + " 导入到数据库失败");
                return false;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

}
