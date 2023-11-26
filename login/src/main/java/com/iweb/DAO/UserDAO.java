package com.iweb.DAO;

import com.iweb.entity.User;

import java.util.List;

/**
 * @author Liu Xiong
 * @date 16/11/2023 下午10:19
 */
public interface UserDAO {
    /**
     * 插入用户信息方法
     *
     * @param user 要插入的用户对象
     */
    void insert(User user);

    /**
     * 删除指定id的数据
     *
     * @param id 要删除的数据的id
     */
    void delete(Integer id);

    /**
     * 更新用户信息
     *
     * @param user 要更新的用户对象
     */
    void update(User user);

    /**
     * 默认查询所有用户的信息
     *
     */
    List<User> listAll(String key);

    /**
     * 根据提供的关键字key对用户查询
     *
     */
    User listByName(String key);

}
