package com.iweb.test4;

import lombok.Data;

import java.sql.Connection;

/**
 * @author Liu Xiong
 * @date 25/11/2023 上午11:46
 */
@Data
public class DataSource {
    private Connection conn;
}
