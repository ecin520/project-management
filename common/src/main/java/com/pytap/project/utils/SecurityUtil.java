package com.pytap.project.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Ecin520
 * @date 2020/4/14 0:48
 */
public class SecurityUtil {

	private static UserDetails getUserDetails() {
		return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public static String getUsername() {
		return getUserDetails().getUsername();
	}
}
