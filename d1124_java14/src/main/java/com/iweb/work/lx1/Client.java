package com.iweb.work.lx1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Liu Xiong
 * @date 24/11/2023 下午3:52
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 8888);
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        DataInputStream dis = new DataInputStream(is);
        DataOutputStream dos = new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);

        while (true) {
            dos.writeUTF(sc.nextLine());
            System.out.println("客服回复:" + dis.readUTF());
        }
    }
}
