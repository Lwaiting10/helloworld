package com.iweb.test3;

import com.sun.org.apache.regexp.internal.RE;
import sun.util.resources.cldr.ja.TimeZoneNames_ja;

/**
 * @author Liu Xiong
 * @date 23/11/2023 下午8:14
 */
public class Lyh extends Thread {
    private  boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag的值为:" + flag);
    }
}
