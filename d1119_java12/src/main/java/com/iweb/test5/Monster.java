package com.iweb.test5;

import lombok.Data;

/**
 * @author Liu Xiong
 * @date 19/11/2023 下午2:27
 */
@Data
public class Monster {
    public String name;
    private float hp;

    public synchronized void recover() {
        // 1. 先获取hp 2.计算hp+1 3.对hp赋值
        hp++;
        System.out.println("为:" + name + "恢复了一点生命值,当前生命值为:" + hp);
        this.notify();
    }

    public synchronized void hurt() {
        if (hp == 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp--;
        System.out.println("为:" + name + "降低了一点生命值,当前生命值为:" + hp);
    }
}
