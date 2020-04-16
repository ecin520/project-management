package com.pytap.project.dao;

import com.pytap.project.dto.WebLogDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/4/7 2:22
 */
@Mapper
public interface WebLogDao {

	/**
	 * 插入日志信息
	 * @param webLog 日志信息
	 * */
	void insertWebLog(WebLogDTO webLog);

	/**
	 * 获取web日志
	 * @param webLogDTO 日志对象
	 * @return WebLogDO
	 * */
	WebLogDTO getWebLog(WebLogDTO webLogDTO);

	/**
	 * 返回所有web日志
	 * @return List<WebLogDO>
	 * */
	List<WebLogDTO> listWebLogs();

	/**
	 * 清空日志
	 * @return Integer
	 * */
	Integer deleteAllWebLogs();

}
