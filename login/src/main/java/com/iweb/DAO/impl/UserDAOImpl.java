package com.iweb.DAO.impl;

import com.iweb.DAO.UserDAO;
import com.iweb.Util.DBUtil;
import com.iweb.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liu Xiong
 * @date 16/11/2023 下午10:19
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public void insert(User user) {
        String sql = "insert into user(name,password) values(?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from user where id = " + id;
        try (Connection c = DBUtil.getConnection();
             Statement s = c.createStatement();) {
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        String sql = "update user set name =?,password=? where id =?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> listAll(String key) {
        List<User> users = new ArrayList<>();
        String sql;
        if (key == null || "".equals(key)) {
            sql = "select * from user";
        } else {
            sql = "select * from user where name = '" + key + "'";
        }
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users.isEmpty() ? null : users;
    }

    @Override
    public User listByName(String key) {
        List<User> users = listAll(key);
        return users == null ? null : users.get(0);
    }
}
