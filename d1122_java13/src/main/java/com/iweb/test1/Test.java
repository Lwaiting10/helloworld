package com.iweb.test1;

/**
 * @author Liu Xiong
 * @date 22/11/2023 下午6:34
 */
public class Test {
    public static void main(String[] args) {

        Basket bt = new Basket();
        Producer p = new Producer(bt);
        Consumer c = new Consumer(bt);

        new Thread(p).start();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(c).start();
    }
}
