package com.iweb.homework.lx3;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liu Xiong
 * @date 20/11/2023 下午7:58
 */
@Data
public class Basket {
    private List<Egg> eggs = new ArrayList<>();
    private final static int EGG_NUMBER = 10;

    public Basket() {
        for (int i = 0; i < 5; i++) {
            eggs.add(new Egg());
        }
    }

    public boolean isFull() {
        if (eggs.size() == EGG_NUMBER) {
            System.out.println("篮子满了！哥哥不要下蛋了！");
            return true;
        }
        return false;
    }

    public synchronized void insert(Egg egg) {
        while (isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        eggs.add(egg);
        notifyAll();
    }

    public synchronized Egg fetch() {
        while (eggs.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        return eggs.remove(eggs.size() - 1);
    }
}
