package com.pytap.project.web.service.impl;

import com.pytap.project.dao.ProjectManagerMapper;
import com.pytap.project.dao.UserAdditionalPermissionMapper;
import com.pytap.project.entity.*;
import com.pytap.project.utils.FinalUtil;
import com.pytap.project.web.service.ProjectManagerService;
import com.pytap.project.web.service.UtilService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Ecin520
 * @date 2020/4/30 22:44
 */
@Service
@CacheConfig(cacheNames = {"admin"})
public class ProjectManagerServiceImpl implements ProjectManagerService {

	@Resource
	private ProjectManagerMapper projectManagerMapper;

	@Resource
	private UserAdditionalPermissionMapper userAdditionalPermissionMapper;

	@Resource
	private UtilService utilService;

	@Override
	@CacheEvict(allEntries = true)
	@Transactional(rollbackFor = {RuntimeException.class, Error.class})
	public Integer insertProjectManager(ProjectManager projectManager) {
		projectManager.setCreateTime(new Date());

		AdditionalPermission additionalPermission = utilService.getByAdditionalPermissionName(FinalUtil.AP_PROJECT_MANAGER + projectManager.getProjectId());

		UserAdditionalPermission userAdditionalPermission = new UserAdditionalPermission();
		userAdditionalPermission.setUserId(projectManager.getManagerId());
		userAdditionalPermission.setAdditionalPermissionId(additionalPermission.getId());

		userAdditionalPermissionMapper.insert(userAdditionalPermission);

		return projectManagerMapper.insert(projectManager);
	}

	@Override
	public Integer deleteByProjectManagerId(Long id) {
		return projectManagerMapper.deleteByPrimaryKey(id);
	}

	@Override
	@CacheEvict(allEntries = true)
	@Transactional(rollbackFor = {RuntimeException.class, Error.class})
	public Integer deleteByProjectAndManagerId(Long projectId, Long managerId) {

		ProjectManagerExample projectManagerExample = new ProjectManagerExample();
		ProjectManagerExample.Criteria criteria = projectManagerExample.createCriteria();
		criteria.andProjectIdEqualTo(projectId);
		criteria.andProjectIdEqualTo(managerId);

		AdditionalPermission additionalPermission = utilService.getByAdditionalPermissionName(FinalUtil.AP_PROJECT_MANAGER + projectId);

		UserAdditionalPermissionExample userAdditionalPermissionExample = new UserAdditionalPermissionExample();
		UserAdditionalPermissionExample.Criteria criteria2 = userAdditionalPermissionExample.createCriteria();
		criteria2.andUserIdEqualTo(managerId);
		criteria2.andAdditionalPermissionIdEqualTo(additionalPermission.getId());

		userAdditionalPermissionMapper.deleteByExample(userAdditionalPermissionExample);

		return projectManagerMapper.deleteByExample(projectManagerExample);
	}

}
