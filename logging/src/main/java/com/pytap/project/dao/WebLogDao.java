package com.pytap.project.dao;

import com.pytap.project.model.WebLogDO;
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
	List<WebLogDO> listWebLogs();

}
