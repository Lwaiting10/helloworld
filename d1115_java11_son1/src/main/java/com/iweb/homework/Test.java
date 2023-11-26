package com.iweb.homework;

/**
 * @author Liu Xiong
 * @date 17/11/2023 下午2:27
 */
public class Test {
    public static void main(String[] args) {
        int a = 'a' + 5;
        System.out.println(a);
        Double d = new Double(1.23);
        dec(d);
        System.out.println(d);
    }

    public static void dec(Double d) {
        d -= 0.1;
    }
}
