package com.iweb.test5;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Liu Xiong
 * @date 25/11/2023 下午2:16
 */
@JDBCConfig(url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8",
        username = "root", password = "a12345")
public class DBUtil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        // 获取当前贴在类上的注解对象
        JDBCConfig config = DBUtil.class.getAnnotation(JDBCConfig.class);
        String url = config.url();
        String username = config.username();
        String password = config.password();
        return DriverManager.getConnection(url, username, password);
    }
}
