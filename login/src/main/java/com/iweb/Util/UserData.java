package com.iweb.Util;

import com.iweb.DAO.UserDAO;
import com.iweb.DAO.impl.UserDAOImpl;
import com.iweb.entity.User;

import java.util.List;

/**
 * 用于提供给登录注册业务所需的数据
 * <p>
 * 在这里 由于没有学习jdbc 使用该类模拟数据库数据
 *
 * @author Liu Xiong
 * @date 10/11/2023 下午2:18
 */
public class UserData {
    public static Integer MAX_USER_NUMBER = 10;
    public static UserDAO userDAO = new UserDAOImpl();
    /**
     * 用来存储用户数组
     */
    public static List<User> users = userDAO.listAll(null);
    /**
     * 记录数组中已经被使用的元素对应下标 用于后续判断注册是否超出数组上限
     * <p>
     * 后续如果实现了数组的扩容 也可以继续使用
     */
    public static int count = users.size();
    /**
     * 用来在用户登录成功之后 将用户的引用传递给该属性
     * <p>
     * 后续如果需要访问当前登录的用户信息 直接访问该静态变量即可
     */
    public static User currentLoginUser;
}
