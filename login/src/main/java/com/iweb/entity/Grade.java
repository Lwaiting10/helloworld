package com.iweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Liu Xiong
 * @date 10/11/2023 上午1:18
 */
@Data
@AllArgsConstructor
public class Grade {
    private String subject;
    private double grade;
}
