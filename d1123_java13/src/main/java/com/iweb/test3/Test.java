package com.iweb.test3;

/**
 * @author Liu Xiong
 * @date 23/11/2023 下午8:12
 */
public class Test {
    public static void main(String[] args) {
        Lyh ldt = new Lyh();
        ldt.start();
        while (true) {
            synchronized (ldt) {
                if (ldt.isFlag()) {
                    System.out.println("发现flag的值变化了");
                    break;
                }
            }
        }
    }
}
