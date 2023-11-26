package com.iweb.test;

/**
 * @author Liu Xiong
 * @date 22/11/2023 下午6:15
 */
public class Test {
    public synchronized static void li(){

    }
    public static void l(){
        synchronized (Test.class){

        }
    }
    public static void main(String[] args) {

    }
}
