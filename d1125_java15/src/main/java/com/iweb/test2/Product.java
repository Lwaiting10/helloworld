package com.iweb.test2;

import lombok.Data;

/**
 * @author Liu Xiong
 * @date 25/11/2023 上午10:43
 */
@Data
public class Product {
    private Integer id;
    private String name;
    private Float price;

    public void sell() {
        System.out.println(name + "清仓大甩卖，原价" + price + ",现在只要998");
    }
}
