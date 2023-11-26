package com.iweb.test;

/**
 * @author Liu Xiong
 * @date 19/11/2023 上午9:42
 */
public class TestThread1 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                int times = 0;
                while (true) {
                    System.out.println("我要休眠10ms了");
                    try {
                        Thread.sleep(10);
                        System.out.println("我恢复了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    times += 1;
                    System.out.println("线程已经运行的时间为:" + times);
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("t2抢到了调度资源！");
                }
            }
        };
        t1.start();
        t2.start();
    }
}
