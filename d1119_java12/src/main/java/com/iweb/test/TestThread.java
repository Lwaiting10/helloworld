package com.iweb.test;

/**
 * @author Liu Xiong
 * @date 19/11/2023 上午8:48
 */
public class TestThread {

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("老师我再也不上课启动了，我是:" + this.getName());
                }
            }
        };
        t1.setName("sxl");
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("老师我就启动，我是:" + this.getName());
                }
            }
        };
        t2.setName("lyh");
        t1.start();
        t2.start();
    }
}
