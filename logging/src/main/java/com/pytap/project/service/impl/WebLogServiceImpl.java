package com.pytap.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.pytap.project.dao.WebLogDao;
import com.pytap.project.model.WebLogDO;
import com.pytap.project.service.WebLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/4/7 2:21
 */
@Service
public class WebLogServiceImpl implements WebLogService {

	@Resource
	private WebLogDao webLogDao;


	@Override
	public void insertWebLog(WebLogDO webLog) {
		webLogDao.insertWebLog(webLog);
	}

	@Override
	public WebLogDO getWebLog(WebLogDO webLogDO) {
		return webLogDao.getWebLog(webLogDO);
	}

	@Override
	public List<WebLogDO> listWebLogs(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return webLogDao.listWebLogs();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer deleteAllWebLogs() {
		return webLogDao.deleteAllWebLogs();
	}


}
