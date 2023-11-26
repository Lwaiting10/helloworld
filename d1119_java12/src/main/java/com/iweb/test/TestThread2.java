package com.iweb.test;

/**
 * @author Liu Xiong
 * @date 19/11/2023 上午9:53
 */
public class TestThread2 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是t1");
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是t2");
                }
            }
        };
        t1.start();
        t2.start();

        try {
            // 代码执行到这一行的时候 一直都是主线程在运行
            // 当t1 join了主线程之后 只有t1线程的run方法于完成之后 主线程才会运行
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t3 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是t3");
                }
            }
        };
        t3.start();
    }
}
