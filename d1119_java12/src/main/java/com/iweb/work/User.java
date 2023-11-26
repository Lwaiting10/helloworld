package com.iweb.work;

/**
 * @author Liu Xiong
 * @date 19/11/2023 上午11:20
 */
public class User extends Thread {
    public User(String name) {
        super(name);
    }

    @Override
    public void run() {
        if (!Test2.tickets.isEmpty()) {
            String ticket = Test2.getTicket();
            System.out.println(this.getName() + "抢到" + ticket);
        }
    }
}
