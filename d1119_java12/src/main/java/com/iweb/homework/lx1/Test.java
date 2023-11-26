package com.iweb.homework.lx1;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.定义一个长度固定为20的容器 存储数据 定义30个线程不断往容器中存入数据
 * 定义30个线程不断往容器中取出数据 当容器满的时候
 * 不允许继续添加数据 当容器为空的时候 不允许继续取出数据
 * 使用今天所学的线程知识实现 要求存入和取出的时候都有打印显示
 *
 * @author Liu Xiong
 * @date 20/11/2023 下午4:46
 */
public class Test {
    public static void main(String[] args) {
        Number number = new Number();
        List<InsertThread> insertThreads = new ArrayList<>();
        List<FetchThread> fetchThreads = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            InsertThread insertThread = new InsertThread("插入线程" + (i + 1), number);
            FetchThread fetchThread = new FetchThread("取出线程" + (i + 1), number);
            insertThreads.add(insertThread);
            fetchThreads.add(fetchThread);
        }

        for (Thread t : insertThreads) {
            t.start();
        }
        for (Thread t : fetchThreads) {
            t.start();
        }

    }
}
