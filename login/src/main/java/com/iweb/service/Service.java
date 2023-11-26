package com.iweb.service;

import com.iweb.DAO.UserDAO;
import com.iweb.DAO.impl.UserDAOImpl;
import com.iweb.Util.UserData;
import com.iweb.entity.User;

import java.util.List;

/**
 * @author Liu Xiong
 * @date 16/11/2023 下午11:22
 */
public class Service {
    public static UserDAO userDAO = new UserDAOImpl();

    public static boolean login(User inputUser) {
        // 查找是否数据匹配
        User user = userDAO.listByName(inputUser.getName());
        if (user != null) {
            UserData.currentLoginUser = user;
            return true;
        }
        return false;
    }

    public static boolean register(User inputUser) {
        // 查找用户是否已达上限
        if (isFull()) {
            return false;
        }
        // 查找是否用户名重复
        User user = userDAO.listByName(inputUser.getName());
        // 用户名重复
        if (user != null) {
            return false;
        }
        // 没有重复用户名，执行插入数据库操作
        userDAO.insert(inputUser);
        return true;
    }

    public static boolean isFull() {
        return UserData.count == UserData.MAX_USER_NUMBER;
    }
}
