package com.iweb.homework.lx4;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Liu Xiong
 * @date 20/11/2023 下午9:23
 */
@Data
@AllArgsConstructor
public class LogThread extends Thread {
    private String message;
    private long count;
    private boolean flag;

    public LogThread() {
        message = "";
        count = 0;
        flag = false;
    }

    public synchronized void setMessage(String message) {
        flag = true;
        this.message = message;
        this.notify();
    }

    @Override
    public synchronized void run() {
        while (flag) {
            System.out.println("第" + ++count + "次尝试:" + message);
            flag = false;
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
