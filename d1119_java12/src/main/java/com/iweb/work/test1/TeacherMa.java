package com.iweb.work.test1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Liu Xiong
 * @date 19/11/2023 上午11:42
 */

@Data
@AllArgsConstructor
public class TeacherMa extends Thread {
    private Hercules marble;

    public void cd(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean test() {
        return marble.getCount() <= 10;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("接");
            if (test()) {
                break;
            }
            cd(1000);
            System.out.println("化");
            if (test()) {
                break;
            }
            cd(1000);
            System.out.println("发");
            if (test()) {
                break;
            }
            cd(1000);
            System.out.println("闪电五连鞭");
            if (test()) {
                break;
            }
            cd(2000);
        }
    }
}
