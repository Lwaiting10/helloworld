package com.iweb.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Liu Xiong
 * @date 15/11/2023 下午6:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    private Integer id;
    private String subject;
    private BigDecimal grade;
    private Integer sid;
}
