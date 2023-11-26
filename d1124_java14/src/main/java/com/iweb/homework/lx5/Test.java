package com.iweb.homework.lx5;

/**
 * 29、演示线程死锁
 *
 * @author Liu Xiong
 * @date 24/11/2023 下午10:08
 */
public class Test {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println("t1获取到了lock1的锁！");
                    System.out.println("t1尝试获取lock2的锁……");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2) {
                        System.out.println("t1获取到了lock2的锁！");
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println("t2获取到了lock2的锁！");
                    System.out.println("t2尝试获取lock1的锁……");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1) {
                        System.out.println("t2获取到了lock1的锁！");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
