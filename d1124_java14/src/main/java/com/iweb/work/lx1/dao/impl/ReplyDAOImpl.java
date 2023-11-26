package com.iweb.work.lx1.dao.impl;

import com.iweb.work.lx1.dao.ReplyDAO;
import com.iweb.work.lx1.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Liu Xiong
 * @date 24/11/2023 下午4:44
 */
public class ReplyDAOImpl implements ReplyDAO {
    @Override
    public List<String> select(String receive) {
        List<String> responses = new ArrayList<>();
        String sql = "select response from reply where receive like '%" + receive + "%'";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                responses.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return responses.isEmpty() ? null : responses;
    }
}
