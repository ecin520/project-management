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
	 * */
	void insertWebLog(WebLogDO webLog);

	/**
	 * 获取web日志
	 * @param webLogDO 日志对象
	 * @return WebLogDO
	 * */
	WebLogDO getWebLog(WebLogDO webLogDO);

	/**
	 * 返回所有web日志
	 * @param pageNum 第几页
	 * @param pageSize 每页数量
	 * @return List<WebLogDO>
	 * */
	List<WebLogDO> listWebLogs(Integer pageNum, Integer pageSize);

	/**
	 * 清空日志
	 * @return Integer
	 * */
	Integer deleteAllWebLogs();

}
