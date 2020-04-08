package com.pytap.project.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ecin520
 * @date 2020/4/7 1:50
 */
public class WebUtil {

	public static String getIpAddress(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

}
