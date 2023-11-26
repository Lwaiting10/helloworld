package com.iweb.homework.lx1;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Liu Xiong
 * @date 20/11/2023 下午5:04
 */
@Data
public class Number {
    private List<Integer> numbers;
    private final static int MAX_LENGTH = 20;

    public Number() {
        numbers = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(r.nextInt(100) + 1);
        }
    }

    /**
     * 判断数组是否已满
     *
     * @return 如果数组已满，返回true；否则返回false
     */
    public boolean isFull() {
        return numbers.size() == MAX_LENGTH;
    }

    public synchronized boolean insert(int number) {
        if (isFull()) {
            return false;
        }
        return numbers.add(number);
    }

    public synchronized Integer fetch() {
        if (numbers.isEmpty()) {
            return null;
        }
        return numbers.remove(numbers.size() - 1);
    }
}
