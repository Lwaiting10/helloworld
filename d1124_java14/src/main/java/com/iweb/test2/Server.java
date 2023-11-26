package com.iweb.test2;

import javax.naming.ldap.SortKey;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Liu Xiong
 * @date 24/11/2023 下午3:52
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("正在监听8888端口");
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        DataInputStream dis = new DataInputStream(is);
        DataOutputStream dos = new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("收到客户端消息:" + dis.readUTF());
            dos.writeUTF(sc.nextLine());
        }
    }
}
