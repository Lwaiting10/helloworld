package com.iweb.client;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author Liu Xiong
 * @date 24/11/2023 下午6:57
 */
public class ReceiveThread extends Thread {
    Socket socket;

    public ReceiveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        DataInputStream dis = null;
        try {
            while (true) {
                if (socket.isConnected()) {
                    is = socket.getInputStream();
                    dis = new DataInputStream(is);
                    System.out.println(dis.readUTF());
                }else {
                    break;
                }
            }
        } catch (Exception e) {

        } finally {
            try{
                socket.close();
                dis.close();
                is.close();
                System.out.println("聊天结束");
            }catch (Exception e){

            }
        }
    }
}
