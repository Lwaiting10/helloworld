package com.iweb.homework.lx7;

/**
 * @author Liu Xiong
 * @date 24/11/2023 下午11:00
 */
public class Test {
    public static void main(String[] args) {
        FakeMap<Integer, String> map = new FakeHashMap<>();
        int stringNumber = 1000;
        for (int i = 0; i < stringNumber; i++) {
            map.put(i, "string" + i);
        }
        for (int i = 0; i < stringNumber; i = i + 3) {
            map.remove(i);
        }
        for (int i = 0; i < map.size(); i++) {
            System.out.println(i + ":" + map.get(i));
        }
    }
}
