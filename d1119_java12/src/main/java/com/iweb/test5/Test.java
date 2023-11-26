package com.iweb.test5;

/**
 * @author Liu Xiong
 * @date 19/11/2023 下午3:35
 */
public class Test {
    public static void main(String[] args) {
        Monster goblin = new Monster();
        goblin.setName("哥布林");
        goblin.setHp(100);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    goblin.hurt();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    goblin.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
