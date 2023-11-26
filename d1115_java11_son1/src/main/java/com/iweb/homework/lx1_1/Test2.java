package com.iweb.homework.lx1_1;

/**
 * @author Liu Xiong
 * @date 16/11/2023 下午9:00
 */
public class Test2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + i * j + "\t");
            }
            System.out.println();
        }
    }
}
