package com.iweb.work;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liu Xiong
 * @date 19/11/2023 上午11:17
 */
public class Test2 {
    public static List<String> tickets = new ArrayList<>();

    public synchronized static String getTicket() {
        String ticket = tickets.get(tickets.size() - 1);
        tickets.remove(tickets.size() - 1);
        return ticket;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            tickets.add("票-" + (i + 1));
        }

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            users.add(new User("用户-" + (i + 1)));
        }

        for (User user : users) {
            user.start();
        }

    }
}
