package com.iweb.test3;

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
    }

    public synchronized void hurt() {
        hp--;
    }
}
