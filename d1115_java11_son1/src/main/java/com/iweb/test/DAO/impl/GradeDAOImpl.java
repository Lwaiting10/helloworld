package com.iweb.test.DAO.impl;

import com.iweb.test.DAO.GradeDAO;
import com.iweb.test.DBUtil;
import com.iweb.test.entity.Grade;
import com.iweb.test.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liu Xiong
 * @date 15/11/2023 下午6:39
 */
public class GradeDAOImpl implements GradeDAO {
    @Override
    public List<Grade> listById(Integer sid) {
        List<Grade> grades = new ArrayList<>();
        String sql = "select * from grade where s_id = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setInt(1, sid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Grade g = new Grade();
                // 从结果集遍历当前行中 将每一个字段的值单独取出
                g.setId(rs.getInt("id"));
                g.setSubject(rs.getString("subject"));
                g.setGrade(rs.getBigDecimal("grade"));
                g.setSid(rs.getInt("s_id"));
                grades.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades.isEmpty() ? null : grades;
    }
}
