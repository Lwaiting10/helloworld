package com.iweb.work.lx1;

import com.iweb.work.lx1.dao.ReplyDAO;
import com.iweb.work.lx1.dao.impl.ReplyDAOImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Random;


/**
 * @author Liu Xiong
 * @date 24/11/2023 下午3:52
 */
public class Server {
    private static ReplyDAO replyDAO = new ReplyDAOImpl();

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("正在监听8888端口");
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        DataInputStream dis = new DataInputStream(is);
        DataOutputStream dos = new DataOutputStream(os);
        while (true) {
            String getString = dis.readUTF();
            List<String> responses = replyDAO.select(getString);
            if (responses == null) {
                dos.writeUTF("这边看不懂您的请求，亲！");
            } else {
                Random r = new Random();
                dos.writeUTF(responses.get(r.nextInt(responses.size())));
            }
        }
    }
}
