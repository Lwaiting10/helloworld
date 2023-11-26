package com.iweb.homework.lx2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 2.基于我们之前所写的指定目录下最大最小文件的查找 进行优化
 * 如果发现目录 则新开一个线程去进行遍历,而不是之前的单线程等待遍历结果
 *
 * @author Liu Xiong
 * @date 20/11/2023 下午4:47
 */
public class Test {
    private static TreeMap<Long, List<File>> tm = new TreeMap<>();

    public static void listFile(File f) {
        if (f.isFile() && f.length() != 0) {
            synchronized (tm) {
                if (!tm.containsKey(f.length())) {
                    tm.put(f.length(), new ArrayList<>());
                }
                tm.get(f.length()).add(f);
            }
        } else if (f.isDirectory()) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    File[] fs = f.listFiles();
                    for (File file : fs) {
                        listFile(file);
                    }
                }
            };
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入查找的路径!");
        String filePath = sc.nextLine();
        File f = new File(filePath);
        if (!f.isDirectory()) {
            System.out.println("输入有误!");
        } else {
            listFile(f);
        }
        System.out.println("最小文件长度为:" + tm.firstKey() + ",对应文件列表为:" + tm.firstEntry().getValue());
        System.out.println("最大文件长度为:" + tm.lastKey() + ",对应文件列表为:" + tm.lastEntry().getValue());

    }
}
