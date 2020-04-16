package com.pytap.project.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Ecin520
 * @date 2020/4/14 0:48
 */
public class SecurityUtil {

	private static final Logger logger = LoggerFactory.getLogger(SecurityUtil.class);

	private static UserDetails getUserDetails() {
		UserDetails userDetails;
		try {
			userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return userDetails;
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return null;
	}

	public static String getUsername() {
		return null == getUserDetails() ? "" : getUserDetails().getUsername();
	}
}
