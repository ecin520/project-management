package com.pytap.project.web.service.impl;

import com.pytap.project.dao.ProjectDeveloperMapper;
import com.pytap.project.dao.UserAdditionalPermissionMapper;
import com.pytap.project.entity.*;
import com.pytap.project.utils.FinalUtil;
import com.pytap.project.web.service.ProjectDeveloperService;
import com.pytap.project.web.service.UtilService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Ecin520
 * @date 2020/4/30 23:57
 */
@Service
@CacheConfig(cacheNames = {"admin"})
public class ProjectDeveloperServiceImpl implements ProjectDeveloperService {

	@Resource
	private ProjectDeveloperMapper projectDeveloperMapper;

	@Resource
	private UserAdditionalPermissionMapper userAdditionalPermissionMapper;

	@Resource
	private UtilService utilService;

	@Override
	@CacheEvict(allEntries = true)
	public Integer insertProjectDeveloper(ProjectDeveloper projectDeveloper) {
		projectDeveloper.setCreateTime(new Date());

		AdditionalPermission additionalPermission = utilService.getByAdditionalPermissionName(FinalUtil.AP_PROJECT_DEVELOPER + projectDeveloper.getProjectId());

		UserAdditionalPermission userAdditionalPermission = new UserAdditionalPermission();
		userAdditionalPermission.setUserId(projectDeveloper.getDeveloperId());
		userAdditionalPermission.setAdditionalPermissionId(additionalPermission.getId());

		userAdditionalPermissionMapper.insert(userAdditionalPermission);

		return projectDeveloperMapper.insert(projectDeveloper);
	}

	@Override
	public Integer deleteByProjectDeveloperId(Long id) {
		return projectDeveloperMapper.deleteByPrimaryKey(id);
	}

	@Override
	@CacheEvict(allEntries = true)
	@Transactional(rollbackFor = {RuntimeException.class, Error.class})
	public Integer deleteByProjectAndDeveloperId(Long projectId, Long developerId) {

		ProjectDeveloperExample projectDeveloperExample = new ProjectDeveloperExample();
		ProjectDeveloperExample.Criteria criteria = projectDeveloperExample.createCriteria();
		criteria.andProjectIdEqualTo(projectId);
		criteria.andDeveloperIdEqualTo(developerId);

		AdditionalPermission additionalPermission = utilService.getByAdditionalPermissionName(FinalUtil.AP_PROJECT_DEVELOPER + projectId);

		UserAdditionalPermissionExample userAdditionalPermissionExample = new UserAdditionalPermissionExample();
		UserAdditionalPermissionExample.Criteria criteria2 = userAdditionalPermissionExample.createCriteria();
		criteria2.andUserIdEqualTo(developerId);
		criteria2.andAdditionalPermissionIdEqualTo(additionalPermission.getId());
		userAdditionalPermissionMapper.deleteByExample(userAdditionalPermissionExample);


		return projectDeveloperMapper.deleteByExample(projectDeveloperExample);
	}
}
