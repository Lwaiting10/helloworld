package com.iweb.homework;

/**
 * @author Liu Xiong
 * @date 17/11/2023 下午7:15
 */
public class Test3 {
    public static void main(String[] args) {
        double molecule = 2;
        double denominator = 1;
        double temp;
        double count = 0;
        for (int i = 0; i < 20; i++) {
            count += molecule / denominator;
            temp = molecule;
            molecule += denominator;
            denominator = temp;
        }
        System.out.println(count);
    }
}
