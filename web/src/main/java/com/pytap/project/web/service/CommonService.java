package com.pytap.project.web.service;

import com.pytap.project.entity.AdditionalPermission;
import com.pytap.project.entity.UserAdditionalPermission;

/**
 * @author Ecin520
 * @date 2020/4/27 21:04
 */
public interface CommonService {

	/**
	 * 用户注册
	 * @param username 用户名
	 * @param password 密码
	 * @return Integer
	 * */
	Integer register(String username, String password);

	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return String
	 * */
	String login(String username, String password);

	/**
	 * 刷新token
	 * @param username 用户名
	 * @return String Token
	 * */
	String refreshToken(String username);

	/**
	 * 刷新token
	 * @param username 用户名
	 * */
	void refreshUser(String username);

}
