package com.iweb.test;

import javax.xml.crypto.Data;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Liu Xiong
 * @date 24/11/2023 下午3:38
 */
public class TestClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 8888);
        OutputStream os = s.getOutputStream();
        // 封装输出流
        DataOutputStream dos = new DataOutputStream(os);
        // 写入数据
        dos.writeUTF("zyn是常州人");
    }
}
