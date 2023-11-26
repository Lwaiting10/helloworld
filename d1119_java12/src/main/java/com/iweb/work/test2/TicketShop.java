package com.iweb.work.test2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Liu Xiong
 * @date 19/11/2023 下午1:41
 */
public class TicketShop {
    private LinkedList<Ticket> ticketList;

    public TicketShop() {
        ticketList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ticketList.add(new Ticket(i + 1));
        }
    }

    public synchronized Ticket getTicket() {
        return ticketList.isEmpty() ? null : ticketList.removeLast();
    }
}
