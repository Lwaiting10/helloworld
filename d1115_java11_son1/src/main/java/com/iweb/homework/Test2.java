package com.iweb.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

/**
 * 2、有n顶帽子，每顶帽子的售价是随机整数，现在编写一段代码，价格从低到高的第三顶帽子的价格是多少
 *
 * @author Liu Xiong
 * @date 14/11/2023 下午10:40
 */
public class Test2 {
    public static final int HAT_NUMBER = 100;
    public static TreeMap<Integer, List<String>> hat = new TreeMap<>();

    static {
        Random random = new Random();
        for (int i = 0; i < HAT_NUMBER; i++) {
            int price = random.nextInt(900) + 100;
            if (!hat.containsKey(price)) {
                hat.put(price, new ArrayList<>());
            }
            hat.get(price).add("hat" + i);
        }
    }


    public static void main(String[] args) {
        System.out.println("价格从低到高的第三顶帽子的价格是：" + hat.firstKey());
    }
}
