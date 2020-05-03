package com.pytap.project.web.service;

import com.pytap.project.entity.User;
import com.pytap.project.web.model.dto.UserDTO;

/**
 * @author Ecin520
 * @date 2020/4/27 21:13
 */
public interface UserService {
	/**
	 * 删除用户
	 *
	 * @param id 用户id
	 * @return Integer
	 */
	Integer deleteByUserId(Long id);

	/**
	 * 更新用户
	 *
	 * @param user 用户实体
	 * @return Integer
	 */
	Integer updateByUserId(User user);

	/**
	 * 主键获得用户
	 *
	 * @param id 用户主键
	 * @return User
	 */
	User getByUserId(Long id);

	/**
	 * 用户名获得用户
	 *
	 * @param username 用户名
	 * @return User
	 */
	User getByUsername(String username);

	/**
	 * 主键获得用户
	 *
	 * @param id 用户主键
	 * @return UserDTO
	 */
	UserDTO getDtoByUserId(Long id);

	/**
	 * 用户名获得用户
	 *
	 * @param username 用户名
	 * @return UserDTO
	 */
	UserDTO getDtoByUsername(String username);
}
