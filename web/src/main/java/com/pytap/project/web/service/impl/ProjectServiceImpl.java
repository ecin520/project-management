package com.pytap.project.web.service.impl;

import com.pytap.project.dao.ProjectMapper;
import com.pytap.project.dao.UserAdditionalPermissionMapper;
import com.pytap.project.entity.Project;
import com.pytap.project.entity.ProjectExample;
import com.pytap.project.entity.UserAdditionalPermission;
import com.pytap.project.web.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/4/29 12:26
 */
@Service
public class ProjectServiceImpl implements ProjectService {

	@Resource
	private ProjectMapper projectMapper;

	@Resource
	private UserAdditionalPermissionMapper userAdditionalPermissionMapper;

	@Override
	public List<Project> listUserProjects(Long id) {
		ProjectExample projectExample = new ProjectExample();
		ProjectExample.Criteria criteria = projectExample.createCriteria();
		criteria.andCreaterEqualTo(id);
		return projectMapper.selectByExample(projectExample);
	}

	@Override
	public Integer insertProject(Project project) {

		int result = projectMapper.insert(project);

		// 插入用户与项目关系
		UserAdditionalPermission userAdditionalPermission = new UserAdditionalPermission();
		userAdditionalPermission.setUserId(project.getCreater());
		userAdditionalPermission.setAdditionalPermissionId(project.getId());
		userAdditionalPermissionMapper.insert(userAdditionalPermission);

		return result == 1 ? 1 : 0;

	}

	@Override
	public Integer deleteProjectById(Long id) {
		return projectMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer updateProject(Project project) {
		return projectMapper.updateByPrimaryKey(project);
	}

	@Override
	public Project getUserProject(Long id) {
		return projectMapper.selectByPrimaryKey(id);
	}
}
