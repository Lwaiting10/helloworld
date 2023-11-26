package com.iweb.homework.lx2;

import java.io.*;

/**
 * 26、编写一个程序用于文件的拷贝
 *
 * @author Liu Xiong
 * @date 24/11/2023 下午9:43
 */
public class Test {
    public static boolean fileCopy(File copyFile, File pasteFile) {
        try (FileReader fr = new FileReader(copyFile);
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(pasteFile);
             PrintWriter pw = new PrintWriter(fw)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                pw.println(line);
            }
            pw.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        File copyFile = new File("D:\\OneDrive\\桌面\\java测试文件\\url.txt");
        File pasteFile = new File("D:\\OneDrive\\桌面\\java测试文件\\java\\url.txt");
        if (fileCopy(copyFile, pasteFile)) {
            System.out.println("复制成功！");
        } else {
            System.out.println("复制失败！");
        }
    }
}
