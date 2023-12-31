package com.iweb.work.lx1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Liu Xiong
 * @date 24/11/2023 下午4:08
 */
public class DBUtil {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "a12345";

    private static final String URL = "jdbc:mysql://localhost:3306/test?character=utf8";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
