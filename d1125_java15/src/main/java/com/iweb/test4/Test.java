package com.iweb.test4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Liu Xiong
 * @date 25/11/2023 上午11:27
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(DBUtil.getDataSource().getConn());
    }
}
