package com.iweb.homework.lx3;

import java.util.ArrayList;
import java.util.List;

/**
 * 3.假设有一个kun线程 kun线程会不断的下蛋
 * 蛋要装在篮子里
 * 篮子应该提供两个方法 负责提供给其他类调用
 * 一个是装蛋方法
 * 一个是取蛋方法
 * 篮子最多能装10个蛋
 * 有10个小黑子线程负责调用篮子的取蛋方法 获取蛋
 * 当篮子为空的时候 所有小黑子线程进入wait状态 进行等待
 * 当篮子不为空的时候 唤醒所有小黑子
 * 当篮子满了的时候 让哥哥暂时不要下蛋
 *
 * @author Liu Xiong
 * @date 20/11/2023 下午4:47
 */
public class Test {
    public static void main(String[] args) {
        Basket basket = new Basket();
        Kun kun = new Kun(basket);
        List<LittleBlack> littleBlacks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LittleBlack littleBlack = new LittleBlack("小黑子" + (i + 1), basket);
            littleBlacks.add(littleBlack);
        }
        kun.start();
        for (Thread t : littleBlacks) {
            t.start();
        }
    }
}
