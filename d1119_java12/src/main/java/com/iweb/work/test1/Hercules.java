package com.iweb.work.test1;

import lombok.Data;

import java.util.Random;

/**
 * @author Liu Xiong
 * @date 19/11/2023 上午11:41
 */
@Data
public class Hercules extends Thread {
    private int count;

    @Override
    public void run() {
        Random r = new Random();
        while (true) {
            count = r.nextInt(100) + 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
