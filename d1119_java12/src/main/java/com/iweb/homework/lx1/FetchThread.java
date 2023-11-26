package com.iweb.homework.lx1;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @author Liu Xiong
 * @date 20/11/2023 下午5:18
 */
@Data
@AllArgsConstructor
public class FetchThread extends Thread {
    private String fetchName;
    private Number number;

    @Override
    public void run() {
        Integer fetchNumber = number.fetch();
        if (fetchNumber == null) {
            System.out.println("容器空了！" + fetchName + "没有获取到数据！");
        } else {
            System.out.println(fetchName + "获取到了:" + fetchNumber);
        }
    }
}
