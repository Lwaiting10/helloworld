package com.iweb.homework.lx5;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Liu Xiong
 * @date 21/11/2023 上午9:20
 */
@Data
@AllArgsConstructor
public class Player extends Thread {
    private String playerName;
    private TaskHall taskHall;

    @Override
    public void run() {
        while (true) {
            Task task = taskHall.fetch();
            System.out.println(playerName + "接取到了:" + task.getTno() + "号任务！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
