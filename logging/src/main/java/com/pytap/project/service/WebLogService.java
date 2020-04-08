package com.pytap.project.service;

import com.pytap.project.model.WebLogDO;

/**
 * @author Ecin520
 * @date 2020/4/7 2:20
 */
public interface WebLogService {
	/**
	 * 插入日志信息
	 * @param webLog 日志信息
	 * @return int
	 * */
	int insertWebLog(WebLogDO webLog);
}
