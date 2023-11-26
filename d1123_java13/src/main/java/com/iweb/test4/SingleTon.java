package com.iweb.test4;

/**
 * @author Liu Xiong
 * @date 24/11/2023 下午2:11
 */
public class SingleTon {
    private static SingleTon singleTon;

    private SingleTon() {
    }

    public static synchronized SingleTon getSingleTon() {
        if (singleTon == null) {
            singleTon = new SingleTon();
        }
        return singleTon;
    }
}
