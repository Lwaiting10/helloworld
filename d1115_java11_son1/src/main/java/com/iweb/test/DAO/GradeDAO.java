package com.iweb.test.DAO;

import com.iweb.test.entity.Grade;

import java.util.List;

/**
 * @author Liu Xiong
 * @date 15/11/2023 下午6:26
 */
public interface GradeDAO {
    List<Grade> listById(Integer sid);
}
