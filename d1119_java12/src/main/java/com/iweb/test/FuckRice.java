package com.iweb.test;

/**
 * @author Liu Xiong
 * @date 19/11/2023 上午9:18
 */
public class FuckRice implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("别骂了，我错了，我是:" + Thread.currentThread().getName());
        }
    }
}
