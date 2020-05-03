package com.pytap.project.web.service.impl;

import com.pytap.project.dao.ProjectDeveloperMapper;
import com.pytap.project.entity.ProjectDeveloper;
import com.pytap.project.entity.ProjectDeveloperExample;
import com.pytap.project.web.service.ProjectDeveloperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Ecin520
 * @date 2020/4/30 23:57
 */
@Service
public class ProjectDeveloperServiceImpl implements ProjectDeveloperService {

	@Resource
	private ProjectDeveloperMapper projectDeveloperMapper;

	@Override
	public Integer insertProjectDeveloper(ProjectDeveloper projectDeveloper) {
		projectDeveloper.setCreateTime(new Date());
		return projectDeveloperMapper.insert(projectDeveloper);
	}

	@Override
	public Integer deleteByProjectDeveloperId(Long id) {
		return projectDeveloperMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer deleteByProjectAndDeveloperId(Long projectId, Long developerId) {
		ProjectDeveloperExample projectDeveloperExample = new ProjectDeveloperExample();
		ProjectDeveloperExample.Criteria criteria = projectDeveloperExample.createCriteria();
		criteria.andProjectIdEqualTo(projectId);
		criteria.andDeveloperIdEqualTo(developerId);
		return projectDeveloperMapper.deleteByExample(projectDeveloperExample);
	}
}
