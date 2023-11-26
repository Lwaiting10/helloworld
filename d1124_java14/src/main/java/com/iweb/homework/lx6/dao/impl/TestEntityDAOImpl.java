package com.iweb.homework.lx6.dao.impl;

import com.iweb.homework.lx6.DBUtil;
import com.iweb.homework.lx6.dao.TestEntityDAO;
import com.iweb.homework.lx6.entity.TestEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liu Xiong
 * @date 24/11/2023 下午10:32
 */
public class TestEntityDAOImpl implements TestEntityDAO {
    @Override
    public void insert(TestEntity testEntity) {
        String sql = "insert into d1124_test(name) values(?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, testEntity.getName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                testEntity.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from d1124_test where id =" + id;
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TestEntity testEntity) {
        String sql = "update d1124_test set name=? where id=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1, testEntity.getName());
            ps.setInt(2, testEntity.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TestEntity> selectByNameLike(String name) {
        List<TestEntity> testEntities = new ArrayList<>();
        String sql = "select * from d1124_test where name like '%" + name + "%'";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TestEntity t = new TestEntity();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                testEntities.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testEntities.isEmpty() ? null : testEntities;
    }
}
