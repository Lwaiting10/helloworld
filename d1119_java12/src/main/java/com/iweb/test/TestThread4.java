package com.iweb.test;

/**
 * @author Liu Xiong
 * @date 19/11/2023 上午10:35
 */
public class TestThread4 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                int time = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("已经过去了" + ++time + "秒");
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是线程t2 当前运行次数为:" + (i + 1));
                }
            }
        };
        // t1设置为守护线程
        t1.setDaemon(true);
        t1.start();
        t2.start();
        System.out.println("主线程开始sleep");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程运行结束");
    }
}
