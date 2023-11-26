package com.iweb.homework.lx6.dao;

import com.iweb.homework.lx6.entity.TestEntity;

import java.util.List;

/**
 * @author Liu Xiong
 * @date 24/11/2023 下午10:27
 */
public interface TestEntityDAO {
    void insert(TestEntity testEntity);

    void delete(Integer id);

    void update(TestEntity testEntity);

    List<TestEntity> selectByNameLike(String name);
}
