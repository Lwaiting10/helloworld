package com.iweb.test2;

/**
 * @author Liu Xiong
 * @date 22/11/2023 下午8:04
 */
public class Test {
    public static void main(String[] args) {
        // 实例化一个线程池对象
        ThreadPool pool = new ThreadPool();
        // 定义若干个任务线程 用来代表需要被执行的任务
        // for (int i = 0; i < 5; i++) {
        //     Runnable task = new Runnable() {
        //         @Override
        //         public void run() {
        //             System.out.println("我是任务需要执行的操作");
        //         }
        //     };
        //     // 将生成的任务添加到线程池的任务容器中
        //     pool.add(task);
        // }
        // // 延长主线程运行时间 观察运行结果
        // try {
        //     Thread.sleep(1000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // System.out.println("运行结束");

        // 创建一个场景
        // 假设任务运行需要1s的时间
        // 开始的时候 间隔1s向线程池添加任务 然后不断减少投放任务的时间间隔
        // 执行任务的线程还没有来得及结束 新的任务又来了
        int sleep = 1000;
        while (true) {
            pool.add(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            try {
                Thread.sleep(sleep);
                sleep = sleep > 100 ? sleep - 100 : 100;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
