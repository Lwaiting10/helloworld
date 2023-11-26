package com.iweb.homework;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Liu Xiong
 * @date 23/11/2023 下午9:42
 */
public class Number {
    volatile AtomicInteger a;

    public Number(AtomicInteger a) {
        this.a = a;
    }

    public void sub() {
        a.decrementAndGet();
    }

    public void add() {
        a.incrementAndGet();
    }
}
