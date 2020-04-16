package com.pytap.project.service;

import com.pytap.project.dto.ErrorLogDTO;
import com.pytap.project.dto.WebLogDTO;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/4/15 23:46
 */
public interface ErrorLogService {

	/**
	 * 插入异常日志信息
	 * @param errorLogDTO 日志信息 */
	void insertErrorLog(ErrorLogDTO errorLogDTO);

	/**
	 * 获取异常日志信息
	 * @param errorLogDTO 日志对象
	 * @return List<ErrorLogDTO>
	 * */
	List<ErrorLogDTO> getErrorLogs(ErrorLogDTO errorLogDTO);

	/**
	 * 返回所有异常日志信息
	 * @return List<ErrorLogDTO>
	 * */
	List<Object> listErrorLogs();

	/**
	 * 清空日志
	 * @return Integer
	 * */
	Integer deleteAllErrorLogs();

}
