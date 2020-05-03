package com.pytap.project.web.service;

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
}
