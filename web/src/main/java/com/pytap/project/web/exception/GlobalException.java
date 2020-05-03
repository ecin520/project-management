package com.pytap.project.web.exception;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Ecin520
 * @date 2020/3/31 12:29
 */
@RestControllerAdvice
public class GlobalException {

	private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);

	/**
	 * 一般异常
	 * */
	@ExceptionHandler(value = Exception.class)
	public void exception(Exception e) {
		logger.info("Error: {}", e.getMessage());
	}

	/**
	 * 空指针异常
	 * */
	@ExceptionHandler(value = NullPointerException.class)
	public JSONObject nullPointerException(NullPointerException e) {
		return JsonUtil.backInfo(500, "空指针异常" + e.getMessage());
	}

	/**
	 * 用户不存在
	 * */
	@ExceptionHandler(value = UsernameNotFoundException.class)
	public JSONObject usernameNotFoundException(UsernameNotFoundException e) {
		return JsonUtil.backInfo(403, e.getMessage());
	}

	/**
	 * 用户已被禁用
	 * */
	@ExceptionHandler(value = DisabledException.class)
	public JSONObject disabledException(DisabledException e) {
		return JsonUtil.backInfo(403, e.getMessage());
	}

	/**
	 * 坏的凭据
	 * */
	@ExceptionHandler(value = BadCredentialsException.class)
	public JSONObject badCredentialsException(BadCredentialsException e) {
		return JsonUtil.backInfo(403, e.getMessage());
	}

	/**
	 * 账户锁定
	 * */
	@ExceptionHandler(value = LockedException.class)
	public JSONObject lockedException(LockedException e) {
		return JsonUtil.backInfo(403, e.getMessage());
	}

	/**
	 * 认证异常
	 * */
	@ExceptionHandler(value = AuthenticationException.class)
	public JSONObject authenticationException(AuthenticationException e) {
		return JsonUtil.backInfo(403, e.getMessage());
	}

	/**
	 * 无访问权限异常
	 * */
	@ExceptionHandler(value = AccessDeniedException.class)
	public JSONObject accessDeniedException(AccessDeniedException e) {
		return JsonUtil.backInfo(403, e.getMessage());
	}

	/**
	 * 请求类型错误
	 * */
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public JSONObject httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		return JsonUtil.backInfo(404, e.getMessage());
	}
}
