package com.iweb.homework.lx3;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Liu Xiong
 * @date 20/11/2023 下午7:56
 */
@Data
@AllArgsConstructor
public class Kun extends Thread {
    private Basket basket;

    @Override
    public void run() {
        int count = 0;
        while (true) {
            basket.insert(new Egg());
            System.out.println("哥哥下了一个蛋！哥哥已经下了:" + ++count + "个蛋");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
