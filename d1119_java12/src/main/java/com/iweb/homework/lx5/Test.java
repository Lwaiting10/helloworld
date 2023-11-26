package com.iweb.homework.lx5;

import java.util.ArrayList;
import java.util.List;

/**
 * 5.假设我们设计一个rpg游戏
 * npc发布任务在任务大厅 玩家从任务大厅接受并执行任务
 * npc有若干个 任务大厅同时显示的任务上限为20个
 * 玩家也有若干个
 * 当任务大厅任务满了的时候 npc停止发布任务
 * 当任务大厅任务全被接完的时候 玩家进入wait状态
 * 知道有新的任务被发布在任务大厅中 再次唤醒
 * 在任务大厅满了之后 只要有玩家获取任务 npc继续发布任务
 *
 * @author Liu Xiong
 * @date 20/11/2023 下午4:47
 */
public class Test {
    public static void main(String[] args) {
        int npcNumber = 5;
        int playerNumber = 10;
        TaskHall taskHall = new TaskHall();
        List<NPC> npcList = new ArrayList<>();
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < npcNumber; i++) {
            npcList.add(new NPC("NPC" + (i + 1), taskHall));
        }
        for (int i = 0; i < playerNumber; i++) {
            playerList.add(new Player("player" + (i + 1), taskHall));
        }
        for (Thread t : npcList) {
            t.start();
        }
        for (Thread t : playerList) {
            t.start();
        }
    }
}
