package com.iweb.test;

/**
 * @author Liu Xiong
 * @date 19/11/2023 上午9:03
 */
public class FightRice extends Thread {
    public FightRice(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("老师我饿了，能不能先吃饭，来自:" + this.getName());
        }
    }
}
