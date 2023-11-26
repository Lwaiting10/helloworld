package com.iweb.test6;

/**
 * @author Liu Xiong
 * @date 19/11/2023 下午3:57
 */
public class Test {
    public static void main(String[] args) {
        Object o = new Object();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (o) {
                        o.notify();
                        System.out.println("A");
                        try {
                            o.wait();
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
                while (true) {
                    synchronized (o) {
                        o.notify();
                        System.out.println("B");
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t1.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
