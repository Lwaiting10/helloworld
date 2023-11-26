package com.iweb.test2;

import java.util.LinkedList;

/**
 * 线程池思想本质和生产者消费者模型是类似的
 * 准备一个任务容器 以及 若干个消费者线程
 * 一开始 任务容器是空的 所有线程都wait在其上
 * 直到有一个外部线程向这个任务线程中扔了一个任务 就会有一个消费者线程被唤醒notify
 * 这个消费者线程取出任务 并且执行任务 执行完毕后 继续wait 直到下次消费任务
 * 整个过程中 都不需要创建新的线程 而是循环使用这些已经存在的线程
 *
 * @author Liu Xiong
 * @date 22/11/2023 下午8:15
 */
public class ThreadPool {
    /**
     * 线程池大小 可以通过构造方法初始化
     */
    int threadPollSize;

    // 存放所有任务的任务容器
    LinkedList<Runnable> tasks = new LinkedList<>();

    // 线程池的初始化
    public ThreadPool() {
        // 初始化线程池的大小
        threadPollSize = 10;
        // 向线程池中存入10个消费任务的消费者线程 并且启动
        synchronized (tasks) {
            for (int i = 0; i < threadPollSize; i++) {
                new TaskConsumeThread("负责消费任务的消费者线程" + i).start();
            }
        }
    }

    // 向任务容器添加任务
    public void add(Runnable r) {
        synchronized (tasks) {
            tasks.add(r);
            // 如果消费者线程处于wait 则唤醒他们
            tasks.notifyAll();
        }
    }

    class TaskConsumeThread extends Thread {
        public TaskConsumeThread(String name) {
            super(name);
        }

        // 定义消费任务线程所需要消费的任务
        Runnable task;

        @Override
        public void run() {
            System.out.println(this.getName() + "启动了！");
            while (true) {
                // 获取tasks任务容器的时候要避免多个消费者线程同时从任务容器获取任务
                // 导致多个消费者获取同一个线程的情况
                synchronized (tasks) {
                    // 只要任务容器是空的 通过wait方法 让所有的线程都处于等待状态
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 如果任务容器不为空 则当前负责消费任务的消费者线程就可以操作了
                    // 从任务容器中 取出一个任务 存放在定义的task成员变量中
                    task = tasks.removeFirst();
                    // 唤醒其他线程
                    tasks.notifyAll();
                }
                System.out.println(this.getName() + "成功获取到任务，准备执行");
                // new Thread(task).start();
                // 为了方便观察到任务的执行 我们这里直接调用任务线程的run方法
                task.run();
            }
        }
    }
}
