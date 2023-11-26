package com.iweb.test;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Liu Xiong
 * @date 19/11/2023 上午9:06
 */
public class ThreadTest {
    @Test
    public void threadTest1() {
        // 实例化线程
        FightRice fr1 = new FightRice("李宇航");
        FightRice fr2 = new FightRice("张天保");
        FightRice fr3 = new FightRice("顶针");
        // 线程的职责是运行完成自己的run方法
        // 线程需要通过调用start方法使线程自己 进入到就绪态
        // 进入到就绪态的线程 才会有机会被jvm进行调度
        // 单位时间内 只会有一个线程被jvm进行调度
        // jvm选择哪一个线程运行 运行多长时间 是线程不可控的
        // 哪一个线程先被执行和start顺序无关 也和线程对象的创建时间无关
        fr1.start();
        fr2.start();
        fr3.start();
    }
}
