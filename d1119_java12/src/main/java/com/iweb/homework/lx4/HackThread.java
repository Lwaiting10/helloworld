package com.iweb.homework.lx4;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Liu Xiong
 * @date 20/11/2023 下午9:09
 */
@Data
@AllArgsConstructor
public class HackThread extends Thread {
    private String strPool;
    private String password;
    private boolean result;
    private LogThread logThread;

    public HackThread(String strPool, String password) {
        this.strPool = strPool;
        this.password = password;
        result = false;
        logThread = new LogThread();
        logThread.setDaemon(true);
    }

    @Override
    public void run() {
        logThread.start();
        StringBuilder tempStr = new StringBuilder();
        for (int i = 0; i < strPool.length(); i++) {
            for (int j = 0; j < strPool.length(); j++) {
                for (int k = 0; k < strPool.length(); k++) {
                    if (!logThread.isFlag()) {
                        tempStr.append(strPool.charAt(i));
                        tempStr.append(strPool.charAt(j));
                        tempStr.append(strPool.charAt(k));
                        logThread.setMessage(tempStr.toString());
                        if (tempStr.toString().equals(password)) {
                            result = true;
                            return;
                        }
                        tempStr.setLength(0);
                    } else {
                        k--;
                    }
                }
            }
        }
    }
}
