package com.iweb.work.test2;

/**
 * @author Liu Xiong
 * @date 19/11/2023 下午1:45
 */
public class Ikun extends Thread {
    private String name;
    private TicketShop ticketShop;

    public Ikun(String name, TicketShop ticketShop) {
        this.name = name;
        this.ticketShop = ticketShop;
    }

    @Override
    public void run() {
        Ticket ticket = ticketShop.getTicket();
        if (ticket == null) {
            System.out.println(name + "没有抢到票");
        } else {
            System.out.println(name + "抢到了票" + ticket.getSno());
        }
    }
}
