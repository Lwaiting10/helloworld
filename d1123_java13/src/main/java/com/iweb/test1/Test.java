package com.iweb.test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Liu Xiong
 * @date 23/11/2023 下午4:25
 */
// 实例化一个有三条连接的数据库连接池 然后创建100个线程
// 每一个线程都会从连接池借用连接 并且再借用之后归还
// 拿到连接之后 每个线程执行一个耗时1s的sql语句
public class Test {
    public static void main(String[] args) {
        ConnectionPool cp = new ConnectionPool(10);
        for (int i = 0; i < 100; i++) {
            new WorkingThread("工作线程" + i, cp).start();
        }
    }

    static class WorkingThread extends Thread {
        private ConnectionPool cp;

        public WorkingThread(String name, ConnectionPool cp) {
            super(name);
            this.cp = cp;
        }

        @Override
        public void run() {
            Connection c = cp.getConnection();
            System.out.println(this.getName() + ":\t获取到了连接 开始执行sql语句");
            try (PreparedStatement ps = c.prepareStatement("select * from student")
            ) {
                Thread.sleep(1000);
                ps.executeQuery();
            } catch (Exception e) {
                e.printStackTrace();
            }
            cp.returnConnection(c);
        }
    }
}
