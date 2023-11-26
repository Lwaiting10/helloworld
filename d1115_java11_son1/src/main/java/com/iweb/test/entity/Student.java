package com.iweb.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author Liu Xiong
 * @date 14/11/2023 下午7:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private String address;
    private Long qqnumber;
    private List<Grade> grades;
}
