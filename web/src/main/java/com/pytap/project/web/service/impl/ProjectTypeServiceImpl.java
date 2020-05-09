package com.pytap.project.web.service.impl;

import com.pytap.project.dao.ProjectTypeMapper;
import com.pytap.project.entity.ProjectType;
import com.pytap.project.entity.ProjectTypeExample;
import com.pytap.project.web.service.ProjectTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/5 20:26
 */
@Service
public class ProjectTypeServiceImpl implements ProjectTypeService {

	@Resource
	private ProjectTypeMapper projectTypeMapper;

	@Override
	public Integer insertProjectType(ProjectType projectType) {
		projectType.setCreateTime(new Date());
		return projectTypeMapper.insert(projectType);
	}

	@Override
	public Integer deleteByProjectTypeId(Long id) {
		return projectTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer deleteByProjectTypeName(String name) {
		ProjectTypeExample projectTypeExample = new ProjectTypeExample();
		ProjectTypeExample.Criteria criteria = projectTypeExample.createCriteria();
		criteria.andNameEqualTo(name);
		return projectTypeMapper.deleteByExample(projectTypeExample);
	}

	@Override
	public Integer updateProjectType(ProjectType projectType) {
		return projectTypeMapper.updateByPrimaryKey(projectType);
	}

	@Override
	public List<ProjectType> listProjectTypes() {
		return projectTypeMapper.selectByExample(null);
	}
}
