package com.pytap.project.service;

import com.pytap.project.entity.User;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/30 14:38
 */
public interface UserService {

    /**
     * 插入用户
     * @param user 用户实体
     * @return Integer 插入后的自增主键
     * */
    Integer insertUser(User user);

    /**
     * 删除用户
     * @param id 用户id
     * @return Integer
     * */
    Integer deleteByUserId(Long id);

    /**
     * 更新用户
     * @param user 用户实体
     * @return Integer
     * */
    Integer updateByUserId(User user);

    /**
     * 主键获得用户
     * @param id 用户主键
     * @return user
     * */
    User getByUserId(Long id);

    /**
     * 用户名获得用户
     * @param username 用户名
     * @return user
     * */
    User getByUsername(String username);

    /**
     * 获取所有用户
     * @return List<User>
     * */
    List<User> listAllUsers();

}
