package com.iweb.homework.lx5;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

/**
 * @author Liu Xiong
 * @date 21/11/2023 上午9:20
 */
@Data
@AllArgsConstructor
public class NPC extends Thread {
    private String npcName;
    private TaskHall taskHall;

    @Override
    public void run() {
        Random r = new Random();
        while (true) {
            Task task = new Task(r.nextInt(100) + 1);
            taskHall.insert(task);
            System.out.println(npcName + "发布了:" + task.getTno() + "号任务！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
