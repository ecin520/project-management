package com.pytap.project.web.service.impl;

import com.pytap.project.dao.AdditionalPermissionMapper;
import com.pytap.project.dao.ProjectVerificationMapper;
import com.pytap.project.dao.UserAdditionalPermissionMapper;
import com.pytap.project.entity.*;
import com.pytap.project.utils.FinalUtil;
import com.pytap.project.web.service.ProjectDeveloperService;
import com.pytap.project.web.service.ProjectManagerService;
import com.pytap.project.web.service.ProjectVerificationService;
import com.pytap.project.web.service.UtilService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/6 17:47
 */
@Service
public class ProjectVerificationServiceImpl implements ProjectVerificationService {

	@Resource
	private ProjectVerificationMapper projectVerificationMapper;

	@Resource
	private ProjectDeveloperService projectDeveloperService;

	@Resource
	private ProjectManagerService projectManagerService;

	@Resource
	private UserAdditionalPermissionMapper userAdditionalPermissionMapper;

	@Resource
	private AdditionalPermissionMapper additionalPermissionMapper;

	@Resource
	private UtilService utilService;

	@Override
	public Integer insertProjectVerification(ProjectVerification projectVerification) {

		projectVerification.setStatus(Short.parseShort("0"));

		// 临时添加权限，防止篡改用户数据造成混乱
		if (FinalUtil.DEVELOPER_VERIFICATION.equals(projectVerification.getType())) {
			AdditionalPermission additionalPermission = utilService.getByAdditionalPermissionName(FinalUtil.AP_PROJECT_DEVELOPER + projectVerification.getProjectId());
			if (null == additionalPermission) {
				AdditionalPermission ap = new AdditionalPermission();
				ap.setName(FinalUtil.AP_PROJECT_DEVELOPER + projectVerification.getProjectId());
				ap.setCreateTime(new Date());
				additionalPermissionMapper.insert(ap);

				UserAdditionalPermission userAdditionalPermission = new UserAdditionalPermission();
				userAdditionalPermission.setUserId(projectVerification.getReceiveId());
				userAdditionalPermission.setAdditionalPermissionId(ap.getId());
				userAdditionalPermission.setCreateTime(new Date());
				userAdditionalPermissionMapper.insert(userAdditionalPermission);
			} else {
				UserAdditionalPermission userAdditionalPermission = new UserAdditionalPermission();
				userAdditionalPermission.setUserId(projectVerification.getReceiveId());
				userAdditionalPermission.setAdditionalPermissionId(additionalPermission.getId());
				userAdditionalPermissionMapper.insert(userAdditionalPermission);
			}
		} else if (FinalUtil.MANAGER_VERIFICATION.equals(projectVerification.getType())) {
			AdditionalPermission additionalPermission = utilService.getByAdditionalPermissionName(FinalUtil.AP_PROJECT_MANAGER + projectVerification.getProjectId());
			UserAdditionalPermission userAdditionalPermission = new UserAdditionalPermission();
			userAdditionalPermission.setUserId(projectVerification.getReceiveId());
			userAdditionalPermission.setAdditionalPermissionId(additionalPermission.getId());
			userAdditionalPermissionMapper.insert(userAdditionalPermission);
		}

		return projectVerificationMapper.insert(projectVerification);
	}

	@Override
	public Integer deleteByProjectVerificationId(Long id) {
		return projectVerificationMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer deleteByProjectVerificationReceiveId(Long id) {
		ProjectVerificationExample projectVerificationExample = new ProjectVerificationExample();
		ProjectVerificationExample.Criteria criteria = projectVerificationExample.createCriteria();
		criteria.andReceiveIdEqualTo(id);
		return projectVerificationMapper.deleteByExample(projectVerificationExample);
	}

	@Override
	public Integer deleteByProjectVerificationProjectId(Long id) {
		ProjectVerificationExample projectVerificationExample = new ProjectVerificationExample();
		ProjectVerificationExample.Criteria criteria = projectVerificationExample.createCriteria();
		criteria.andProjectIdEqualTo(id);
		return projectVerificationMapper.deleteByExample(projectVerificationExample);
	}

	@Override
	public Integer updateProjectVerification(ProjectVerification projectVerification) {
		// 1 : 验证通过，若验证通过则添加到项目中
		if (1 == projectVerification.getStatus()) {
			if (FinalUtil.DEVELOPER_VERIFICATION.equals(projectVerification.getType())) {
				// 添加物理关系
				ProjectDeveloper projectDeveloper = new ProjectDeveloper();
				projectDeveloper.setProjectId(projectVerification.getProjectId());
				projectDeveloper.setDeveloperId(projectVerification.getReceiveId());
				projectDeveloper.setCreateTime(new Date());
				projectDeveloperService.insertProjectDeveloper(projectDeveloper);

				// 通过权限名称获取权限id
				AdditionalPermission additionalPermission = utilService.getByAdditionalPermissionName(
						FinalUtil.AP_PROJECT_DEVELOPER + projectVerification.getProjectId());

				// 添加权限关系
				UserAdditionalPermission userAdditionalPermission = new UserAdditionalPermission();
				userAdditionalPermission.setUserId(projectVerification.getReceiveId());
				userAdditionalPermission.setAdditionalPermissionId(additionalPermission.getId());
				userAdditionalPermissionMapper.insert(userAdditionalPermission);

			} else if (FinalUtil.MANAGER_VERIFICATION.equals(projectVerification.getType())) {
				// 添加物理关系
				ProjectManager projectManager = new ProjectManager();
				projectManager.setProjectId(projectVerification.getProjectId());
				projectManager.setManagerId(projectVerification.getReceiveId());
				projectManager.setCreateTime(new Date());
				projectManagerService.insertProjectManager(projectManager);

				// 通过权限名称获取权限id
				AdditionalPermission additionalPermission = utilService.getByAdditionalPermissionName(
						FinalUtil.AP_PROJECT_MANAGER + projectVerification.getProjectId());

				// 添加权限关系
				UserAdditionalPermission userAdditionalPermission = new UserAdditionalPermission();
				userAdditionalPermission.setUserId(projectVerification.getReceiveId());
				userAdditionalPermission.setAdditionalPermissionId(additionalPermission.getId());
				userAdditionalPermissionMapper.insert(userAdditionalPermission);
			}
		} else if (-1 == projectVerification.getStatus()) {
			if (FinalUtil.DEVELOPER_VERIFICATION.equals(projectVerification.getType())) {
				AdditionalPermission additionalPermission = utilService.getByAdditionalPermissionName(FinalUtil.AP_PROJECT_DEVELOPER + projectVerification.getProjectId());
				utilService.deleteUserAdditionalPermission(projectVerification.getReceiveId(), additionalPermission.getId());
			} else if (FinalUtil.MANAGER_VERIFICATION.equals(projectVerification.getType())) {
				AdditionalPermission additionalPermission = utilService.getByAdditionalPermissionName(FinalUtil.AP_PROJECT_MANAGER + projectVerification.getProjectId());
				utilService.deleteUserAdditionalPermission(projectVerification.getReceiveId(), additionalPermission.getId());
			}
		}
		return projectVerificationMapper.updateByPrimaryKey(projectVerification);
	}

	@Override
	public ProjectVerification getProjectVerification(Long id) {
		return projectVerificationMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ProjectVerification> listProjectVerificationsByReceiveId(Long id) {
		ProjectVerificationExample projectVerificationExample = new ProjectVerificationExample();
		ProjectVerificationExample.Criteria criteria = projectVerificationExample.createCriteria();
		criteria.andStatusEqualTo(Short.parseShort("0"));
		criteria.andReceiveIdEqualTo(id);
		return projectVerificationMapper.selectByExample(projectVerificationExample);
	}

	@Override
	public List<ProjectVerification> listProjectVerificationsByProjectId(Long id) {
		ProjectVerificationExample projectVerificationExample = new ProjectVerificationExample();
		ProjectVerificationExample.Criteria criteria = projectVerificationExample.createCriteria();
		criteria.andStatusEqualTo(Short.parseShort("0"));
		criteria.andProjectIdEqualTo(id);
		return projectVerificationMapper.selectByExample(projectVerificationExample);
	}
}
