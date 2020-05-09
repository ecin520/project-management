package com.pytap.project.web.service.impl;

import com.pytap.project.dao.AdditionalPermissionMapper;
import com.pytap.project.dao.ProjectManagerMapper;
import com.pytap.project.dao.ProjectMapper;
import com.pytap.project.dao.UserAdditionalPermissionMapper;
import com.pytap.project.entity.*;
import com.pytap.project.utils.FinalUtil;
import com.pytap.project.utils.SecurityUtil;
import com.pytap.project.web.service.CommonService;
import com.pytap.project.web.service.ProjectService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/4/29 12:26
 */
@Service
@CacheConfig(cacheNames = {"admin"})
public class ProjectServiceImpl implements ProjectService {

	@Resource
	private ProjectMapper projectMapper;

	@Resource
	private ProjectManagerMapper projectManagerMapper;

	@Resource
	private UserAdditionalPermissionMapper userAdditionalPermissionMapper;

	@Resource
	private AdditionalPermissionMapper additionalPermissionMapper;

	@Resource
	private CommonService commonService;

	@Override
	public List<Project> listUserProjects(Long id) {
		ProjectExample projectExample = new ProjectExample();
		ProjectExample.Criteria criteria = projectExample.createCriteria();
		criteria.andCreaterEqualTo(id);
		return projectMapper.selectByExampleWithBLOBs(projectExample);
	}

	@Override
	@CacheEvict(allEntries = true)
	@Transactional(rollbackFor = {RuntimeException.class, Error.class})
	public Integer insertProject(Project project) {
		project.setStatus(Short.parseShort("1"));
		project.setCreateTime(new Date());
		int result = projectMapper.insert(project);

		// 向数据库插入项目id的SUPER权限
		AdditionalPermission superAdditionalPermission = new AdditionalPermission();
		superAdditionalPermission.setName(FinalUtil.AP_PROJECT_SUPER + project.getId());
		superAdditionalPermission.setDescription("Additional Permission By Project Super " + project.getId());
		superAdditionalPermission.setCreateTime(new Date());

		additionalPermissionMapper.insert(superAdditionalPermission);

		// 向数据库插入项目id的MANAGER权限
		AdditionalPermission managerAdditionalPermission = new AdditionalPermission();
		managerAdditionalPermission.setName(FinalUtil.AP_PROJECT_MANAGER + project.getId());
		managerAdditionalPermission.setDescription("Additional Permission By Project Manager " + project.getId());
		managerAdditionalPermission.setCreateTime(new Date());

		additionalPermissionMapper.insert(managerAdditionalPermission);

		// 插入项目创建者SUPER权限
		UserAdditionalPermission userSuperAdditionalPermission = new UserAdditionalPermission();
		userSuperAdditionalPermission.setUserId(project.getCreater());
		userSuperAdditionalPermission.setAdditionalPermissionId(superAdditionalPermission.getId());
		userSuperAdditionalPermission.setCreateTime(new Date());
		userAdditionalPermissionMapper.insert(userSuperAdditionalPermission);

		// 插入项目创建者MANAGER权限
		UserAdditionalPermission userManagerAdditionalPermission = new UserAdditionalPermission();
		userManagerAdditionalPermission.setUserId(project.getCreater());
		userManagerAdditionalPermission.setAdditionalPermissionId(managerAdditionalPermission.getId());
		userManagerAdditionalPermission.setCreateTime(new Date());
		userAdditionalPermissionMapper.insert(userManagerAdditionalPermission);

		// 添加项目管理者关系
		ProjectManager projectManager = new ProjectManager();
		projectManager.setProjectId(project.getId());
		projectManager.setManagerId(project.getCreater());
		projectManager.setCreateTime(new Date());
		projectManagerMapper.insert(projectManager);

		commonService.refreshUser(SecurityUtil.getUsername());

		return result == 1 ? 1 : 0;

	}

	@Override
	public Integer deleteProjectById(Long id) {
		return projectMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer updateProject(Project project) {
		return projectMapper.updateByPrimaryKeyWithBLOBs(project);
	}

	@Override
	public Project getUserProject(Long id) {
		return projectMapper.selectByPrimaryKey(id);
	}
}
