package com.iweb.test4;

/**
 * @author Liu Xiong
 * @date 24/11/2023 下午2:19
 */
public class ST {
    private static ST st = new ST();
    private ST(){
    }

    public static ST getSt() {
        return st;
    }
}
