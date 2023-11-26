package com.iweb.work;

import java.util.Random;

/**
 * @author Liu Xiong
 * @date 19/11/2023 上午10:54
 */
public class Test1 {

    public static void main(String[] args) {
        Thread maBaoGuo = new Thread() {
            int cd = 1000;
            int cdBig = 2000;

            @Override
            public void run() {
                while (true) {
                    System.out.println("接");
                    try {
                        Thread.sleep(cd);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("化");
                    try {
                        Thread.sleep(cd);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("发");
                    try {
                        Thread.sleep(cd);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("闪电五连鞭！");
                    try {
                        Thread.sleep(cdBig);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread marble = new Thread() {
            Random r = new Random();

            @Override
            public void run() {
                int cd = 1000;
                while (true) {
                    try {
                        Thread.sleep(cd);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int interrupt = r.nextInt(100) + 1;
                    if (interrupt <= 10) {
                        System.out.println("英国大理石打断了技能!");
                        break;
                    }
                }
            }
        };
        maBaoGuo.setDaemon(true);
        maBaoGuo.start();
        marble.start();
    }
}
