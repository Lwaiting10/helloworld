package com.iweb.test;

import javax.crypto.spec.PSource;

/**
 * @author Liu Xiong
 * @date 25/11/2023 上午9:03
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.iweb.test.Test");
        Class c2 = new Test().getClass();
        Class c3 = Test.class;

        System.out.println(c1==c2);
        System.out.println(c1==c3);
    }
}
