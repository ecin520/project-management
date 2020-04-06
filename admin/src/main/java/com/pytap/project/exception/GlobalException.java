package com.pytap.project.exception;

import com.pytap.project.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Ecin520
 * @date 2020/3/31 12:29
 */
@RestControllerAdvice
public class GlobalException {

	private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);

	@ExceptionHandler(value = Exception.class)
	public void exception(Exception e) {
		e.printStackTrace();
		logger.info("Error: {}", e.getMessage());
	}
}
