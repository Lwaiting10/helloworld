package com.iweb.homework.lx3;

/**
 * @author Liu Xiong
 * @date 24/11/2023 下午9:54
 */
public class Test3 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程t1启动了！");
                for (int i = 0; i < 20; i++) {
                    System.out.println("线程t1第" + (i + 1) + "次打印！");
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程t2启动了！");
                for (int i = 0; i < 20; i++) {
                    System.out.println("线程t2第" + (i + 1) + "次打印！");
                }
            }
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("两个线程都完成了各自的工作！");
    }
}
