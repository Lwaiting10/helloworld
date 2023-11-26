package com.iweb.homework.lx1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

/**
 * @author Liu Xiong
 * @date 20/11/2023 下午5:18
 */
@Data
@AllArgsConstructor
public class InsertThread extends Thread {
    private String insertName;
    private Number number;

    @Override
    public void run() {
        Random r = new Random();
        int insertNumber = r.nextInt(100) + 1;
        if (number.insert(insertNumber)) {
            System.out.println(insertName + "插入数据:" + insertNumber);
        } else {
            System.out.println("容器满了！" + insertName + "插入数据失败！");
        }
    }
}
