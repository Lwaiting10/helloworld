package com.iweb.homework.lx1_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Liu Xiong
 * @date 16/11/2023 下午9:46
 */
public class Test4 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String username = "root";
        String password = "a12345";
        String url = "jdbc:mysql://localhost:3306/test?character=utf8";
        try (Connection c = DriverManager.getConnection(url, username, password);
             Statement s = c.createStatement();
        ) {
            String sql = "INSERT INTO student(NAME,gender,birthday,address,qqnumber)\n" +
                    "VALUES('刘雄','男','2001-10-11','四川',2352226072)";
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
