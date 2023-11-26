package com.iweb.work.test2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Liu Xiong
 * @date 19/11/2023 下午1:50
 */
public class Test {
    public static void main(String[] args) {
        TicketShop ticketShop = new TicketShop();
        List<Ikun> littleBlack = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Ikun ikun = new Ikun("ikun" + (i + 1), ticketShop);
            littleBlack.add(ikun);
        }
        for (Ikun ikun : littleBlack) {
            ikun.start();
        }
    }
}
