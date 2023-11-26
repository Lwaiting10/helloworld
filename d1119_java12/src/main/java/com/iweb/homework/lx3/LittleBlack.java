package com.iweb.homework.lx3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liu Xiong
 * @date 20/11/2023 下午8:03
 */
@Data
@AllArgsConstructor
public class LittleBlack extends Thread {
    private String littleBlackName;
    private List<Egg> eggs;
    private Basket basket;

    public LittleBlack(String littleBlackName, Basket basket) {
        this.littleBlackName = littleBlackName;
        this.basket = basket;
        eggs = new ArrayList<>();
    }

    @Override
    public void run() {
        while (true) {
            Egg egg = basket.fetch();
            if (egg != null) {
                eggs.add(egg);
                System.out.println(littleBlackName + "拿到了哥哥的一个蛋!他一共拿到了:" + eggs.size() + "个蛋");
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
