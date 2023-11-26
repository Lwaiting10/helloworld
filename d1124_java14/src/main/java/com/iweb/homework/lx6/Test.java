package com.iweb.homework.lx6;

import com.iweb.homework.lx6.dao.TestEntityDAO;
import com.iweb.homework.lx6.dao.impl.TestEntityDAOImpl;
import com.iweb.homework.lx6.entity.TestEntity;

import java.util.List;

/**
 * 30、Java操作数据库增删改查
 *
 * @author Liu Xiong
 * @date 24/11/2023 下午10:14
 */
public class Test {
    public static void main(String[] args) {
        TestEntityDAO testEntityDAO = new TestEntityDAOImpl();
        // TestEntity t = new TestEntity();
        // t.setName("LiuXiong");
        // testEntityDAO.insert(t);

        // TestEntity t1 = new TestEntity();
        // t1.setName("LiuXiong1");
        // testEntityDAO.delete(t1);

        // TestEntity updateT = new TestEntity(1, "LX");
        // testEntityDAO.update(updateT);

        List<TestEntity> list = testEntityDAO.selectByNameLike("L");
        if (list != null) {
            for (TestEntity t : list) {
                System.out.println(t);
            }
        } else {
            System.out.println("未查询到相关数据！");
        }

    }

}
