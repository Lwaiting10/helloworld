package com.iweb.test;

/**
 * @author Liu Xiong
 * @date 19/11/2023 上午10:27
 */
public class TestThread3 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(this.getName());
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(this.getName());
                }
            }
        };
        t1.setName("t1");
        t2.setName("t2");
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();
    }
}
