package com.iweb;

import com.iweb.test.DAO.StudentDAO;
import com.iweb.test.DAO.impl.StudentDAOImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Liu Xiong
 * @date 15/11/2023 下午8:24
 */
public class JDBCTest {
    private StudentDAO studentDAO;

    // 在其他测试方法运行之前 会被该注解修饰的方法会自动执行
    @Before
    public void init() {
        studentDAO = new StudentDAOImpl();
    }

    @Test
    public void testListAllWithGrade() {
        // System.out.println(studentDAO.listAllWithGrade());
        Assert.assertNotNull(studentDAO.listByNameLike("管"));
        // Assert.assertEquals(10, studentDAO.listAll().size());
    }

    @Test
    public void testListAl() {
        // System.out.println(studentDAO.listAll());
    }

    @After
    public void destroy() {
        System.out.println("你可以在这个方法中进行资源销毁或者是对象处理");
    }
}
