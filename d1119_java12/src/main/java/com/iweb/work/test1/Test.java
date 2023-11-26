package com.iweb.work.test1;

/**
 * @author Liu Xiong
 * @date 19/11/2023 上午11:52
 */
public class Test {
    public static void main(String[] args) {
        Hercules dls = new Hercules();
        TeacherMa mbg = new TeacherMa(dls);
        dls.setDaemon(true);
        mbg.start();
        dls.start();
    }
}
