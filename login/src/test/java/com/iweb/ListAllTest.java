package com.iweb;

import com.iweb.DAO.UserDAO;
import com.iweb.DAO.impl.UserDAOImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Liu Xiong
 * @date 16/11/2023 下午10:53
 */
public class ListAllTest {
    private UserDAO userDAO;

    @Before
    public void init() {
        userDAO = new UserDAOImpl();
    }

/*     @Test
    public void testListAll() {
        // System.out.println(studentDAO.listAllWithGrade());
        System.out.println(userDAO.listAll(null));
    } */

    @Test
    public void testListByName() {
        System.out.println("test:" + userDAO.listByName("user1"));
    }

/*     @After
    public void destroy() {
        System.out.println("你可以在这个方法中进行资源销毁或者是对象处理");
    } */
}

