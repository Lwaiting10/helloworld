package com.iweb.homework.lx4;

import java.util.Random;

/**
 * 4 生成一个长度是3的随机字符串，把这个字符串当作 密码
 * 创建一个破解线程，使用穷举法，匹配这个密码
 * 创建一个日志线程，打印都用过哪些字符串去匹配，这个日志线程设计为守护线程
 *
 * @author Liu Xiong
 * @date 20/11/2023 下午4:47
 */
public class Test {
    public final static String STR_POOL = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    public static Random random = new Random();

    public static void main(String[] args) {
        // 生成一个长度是3的随机字符串
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            password.append(STR_POOL.charAt(random.nextInt(STR_POOL.length())));
        }
        HackThread hackThread = new HackThread(STR_POOL, password.toString());
        hackThread.start();
        try {
            hackThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (hackThread.isResult()) {
            System.out.println("破解成功！");
        } else {
            System.out.println("破解失败！");
        }
    }
}
