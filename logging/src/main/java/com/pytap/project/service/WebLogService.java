package com.pytap.project.service;

import com.pytap.project.dto.WebLogDTO;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/4/7 2:20
 */
public interface WebLogService {

	/**
	 * 插入日志信息
	 * @param webLog 日志信息 */
	void insertWebLog(WebLogDTO webLog);

	/**
	 * 获取web日志
	 * @param webLogDTO 日志对象
	 * @return List<WebLogDO>
	 * */
	List<WebLogDTO> getWebLogs(WebLogDTO webLogDTO);

	/**
	 * 返回所有web日志
	 * @return List<WebLogDO>
	 * */
	List<Object> listWebLogs();

	/**
	 * 清空日志
	 * @return Integer
	 * */
	Integer deleteAllWebLogs();

}
