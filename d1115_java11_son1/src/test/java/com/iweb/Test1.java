package com.iweb;

import com.iweb.test.DAO.StudentDAO;
import com.iweb.test.DAO.impl.StudentDAOImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Liu Xiong
 * @date 15/11/2023 下午8:37
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({JDBCTest.class,JDBCTest1.class})
public class Test1 {
}
