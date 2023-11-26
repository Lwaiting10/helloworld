package com.iweb.homework.lx1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 25、编写一个程序输出指定路径下的所有文件
 *
 * @author Liu Xiong
 * @date 24/11/2023 下午9:30
 */
public class Test {
    public static List<File> list = new ArrayList<>();

    public static void getAllFile(File file) {
        if (file.isFile()) {
            list.add(file);
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    getAllFile(f);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入指定路径:");
        File file = new File(sc.nextLine());
        if (file.isDirectory()) {
            getAllFile(file);
            for (File f : list) {
                System.out.println(f.getAbsolutePath());
            }
        } else {
            System.out.println("目录不存在！");
        }

    }
}
