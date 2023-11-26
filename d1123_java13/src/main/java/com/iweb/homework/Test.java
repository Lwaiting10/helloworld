package com.iweb.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1.有一个类 存放了一个成员变量a
 * 500个线程调用方法对a进行-1操作
 * 500个线程调用犯法对a进行+1操作
 * 请你分别使用三种方式保证a数据的线程安全
 * synchronized
 * Lock
 * volatile
 *
 * @author Liu Xiong
 * @date 23/11/2023 下午9:42
 */
public class Test {
    public static void main(String[] args) {
        List<Thread> threads1 = new ArrayList<>();
        List<Thread> threads2 = new ArrayList<>();
        int threadNumber = 500;
        Number number = new Number(new AtomicInteger(1000));
        for (int i = 0; i < threadNumber; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    number.sub();
                }
            };
            threads1.add(t);
            t.start();
        }
        for (int i = 0; i < threadNumber; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    number.add();
                }
            };
            threads2.add(t);
            t.start();
        }
        for (int i = 0; i < threadNumber; i++) {
            try {
                threads1.get(i).join();
                threads2.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("执行完上述操作后，number的值为:" + number.a);
    }
}
