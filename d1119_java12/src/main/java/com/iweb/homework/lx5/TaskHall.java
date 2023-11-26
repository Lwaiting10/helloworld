package com.iweb.homework.lx5;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;

/**
 * @author Liu Xiong
 * @date 21/11/2023 上午9:25
 */
@Data
public class TaskHall {
    private LinkedList<Task> tasks;
    private final static int TASK_NUMBER = 20;

    public TaskHall() {
        tasks = new LinkedList<>();
    }

    public boolean isFull() {
        return tasks.size() == TASK_NUMBER;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public synchronized void insert(Task task) {
        while (isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        tasks.add(task);
        notifyAll();
    }

    public synchronized Task fetch() {
        while (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        return tasks.removeLast();
    }
}
