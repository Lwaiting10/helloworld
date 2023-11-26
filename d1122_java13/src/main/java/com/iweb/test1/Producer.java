package com.iweb.test1;

/**
 * @author Liu Xiong
 * @date 22/11/2023 下午6:55
 */
public class Producer implements Runnable {
    Basket bt;

    public Producer(Basket bt) {
        this.bt = bt;
    }

    @Override
    public void run() {
        // 假设一个生产者放20个馒头
        for (int i = 0; i < 20; i++) {
            ManTou mt = new ManTou(i);
            bt.push(mt);
            System.out.println("生产者 生产了馒头" + mt);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
