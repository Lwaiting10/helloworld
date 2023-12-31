package com.iweb.client;

import java.net.Socket;
import java.util.Scanner;

/**
 * @author Liu Xiong
 * @date 24/11/2023 下午7:01
 */
public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("输入聊天室ip地址:");
            String ip = new Scanner(System.in).nextLine();
            Socket socket = new Socket(ip, 8888);
            // 启动发送消息线程和接受消息线程
            new SendThread(socket).start();
            new ReceiveThread(socket).start();
        } catch (Exception e) {

        }
    }
}
