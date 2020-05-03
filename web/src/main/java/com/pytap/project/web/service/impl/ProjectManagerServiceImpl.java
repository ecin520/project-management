package com.pytap.project.web.service.impl;

import com.pytap.project.dao.ProjectManagerMapper;
import com.pytap.project.entity.ProjectManager;
import com.pytap.project.entity.ProjectManagerExample;
import com.pytap.project.web.service.ProjectManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Ecin520
 * @date 2020/4/30 22:44
 */
@Service
public class ProjectManagerServiceImpl implements ProjectManagerService {

	@Resource
	private ProjectManagerMapper projectManagerMapper;

	@Override
	public Integer insertProjectManager(ProjectManager projectManager) {
		projectManager.setCreateTime(new Date());
		return projectManagerMapper.insert(projectManager);
	}

	@Override
	public Integer deleteByProjectManagerId(Long id) {
		return projectManagerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer deleteByProjectAndManagerId(Long projectId, Long managerId) {
		ProjectManagerExample projectManagerExample = new ProjectManagerExample();
		ProjectManagerExample.Criteria criteria = projectManagerExample.createCriteria();
		criteria.andProjectIdEqualTo(projectId);
		criteria.andProjectIdEqualTo(managerId);
		return projectManagerMapper.deleteByExample(projectManagerExample);
	}

}
