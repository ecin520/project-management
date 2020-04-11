package com.pytap.project.service;

import com.pytap.project.model.WebLogDO;

import java.util.List;

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
	Integer insertWebLog(WebLogDO webLog);

	/**
	 * @param webLogDO 日志对象
	 * @return WebLogDO
	 * */
	WebLogDO getWebLog(WebLogDO webLogDO);

	/**
	 * @return List<WebLogDO>
	 * */
	List<WebLogDO> listWebLogs(Integer pageNum, Integer pageSize);

}
