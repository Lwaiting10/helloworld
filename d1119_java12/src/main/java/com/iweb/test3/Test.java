package com.iweb.test3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liu Xiong
 * @date 19/11/2023 下午2:31
 */
public class Test {
    public static void main(String[] args) {
        Monster goblin = new Monster();
        goblin.setName("哥布林");
        goblin.setHp(10000);
        int n = 10000;
        List<Thread> addThreads = new ArrayList<>();
        List<Thread> reduceThreads = new ArrayList<>();
        // 定义1W个负责调用recover方法给哥布林回血的线程
        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    goblin.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads.add(t);
        }
        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    goblin.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads.add(t);
        }
        // 我们最终需要在主线程中访问哥布林的血量
        // 所以必须保证主线程会等待上面2W个线程跑完代码之后 再继续运行读取血量
        // 所以需要将2W个线程 join主线程
        for (Thread t : addThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Thread t : reduceThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("哥布林的血量是:" + goblin.getHp());
    }
}
