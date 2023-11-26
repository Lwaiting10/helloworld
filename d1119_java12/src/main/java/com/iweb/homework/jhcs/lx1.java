package com.iweb.homework.jhcs;

/**
 * @author Liu Xiong
 * @date 20/11/2023 下午3:35
 */
public class lx1 {
    // 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int last = x % 10;
            x = x / 10;
            if (Integer.toString(result).contains(Integer.toString(last))) {
                continue;
            }
            result = result * 10 + last;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(9876673));
    }
}
