package com.iweb.homework.lx4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 28、使用线程演示交替打印A B
 *
 * @author Liu Xiong
 * @date 24/11/2023 下午9:58
 */
public class Test {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (true) {
                        lock.notify();
                        System.out.println("A");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (true) {
                        lock.notify();
                        System.out.println("B");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
