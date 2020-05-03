package com.pytap.project.web.service.impl;

import com.pytap.project.entity.Project;
import com.pytap.project.web.dao.ProjectOperationDao;
import com.pytap.project.web.model.dto.UserDTO;
import com.pytap.project.web.service.ProjectOperationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/1 1:23
 */
@Service
public class ProjectOperationServiceImpl implements ProjectOperationService {

	@Resource
	private ProjectOperationDao projectOperationDao;

	@Override
	public List<UserDTO> listManagersByProjectId(Long id) {
		return projectOperationDao.listManagersByProjectId(id);
	}

	@Override
	public List<UserDTO> listDevelopersByProjectId(Long id) {
		return projectOperationDao.listDevelopersByProjectId(id);
	}

	@Override
	public List<Project> listProjectsByManagerId(Long id) {
		return projectOperationDao.listProjectsByManagerId(id);
	}

	@Override
	public List<Project> listProjectsByDeveloperId(Long id) {
		return projectOperationDao.listProjectsByDeveloperId(id);
	}
}
