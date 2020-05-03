package com.pytap.project.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.entity.Project;
import com.pytap.project.entity.ProjectManager;
import com.pytap.project.utils.JsonUtil;
import com.pytap.project.web.model.dto.UserDTO;
import com.pytap.project.web.service.ProjectManagerService;
import com.pytap.project.web.service.ProjectOperationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/4/30 22:49
 */
@RestController
@PreAuthorize("hasRole('R_USER')")
@RequestMapping("/web/project-manager")
public class ProjectManagerController {

	@Resource
	private ProjectManagerService projectManagerService;

	@Resource
	private ProjectOperationService projectOperationService;

	@Log(value = "添加项目管理员")
	@PreAuthorize("hasAuthority('AP_PROJECT_SUPER_' + #projectManager.projectId)")
	@RequestMapping(value = "/insertProjectManager", method = RequestMethod.POST)
	public JSONObject insertProjectManager(@RequestBody ProjectManager projectManager) {
		return 1 == projectManagerService.insertProjectManager(projectManager) ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "获取用户管理的所有项目")
	@PreAuthorize("hasAuthority('AP_PROJECT_USER_' + #id)")
	@RequestMapping(value = "/listProjectsByManagerId", method = RequestMethod.POST)
	public JSONObject listProjectsByManagerId(Long id) {
		List<Project> list = projectOperationService.listProjectsByManagerId(id);
		return null == list ? JsonUtil.fail() : JsonUtil.backObject(200, list);
	}

	@Log(value = "通过项目id和管理员id删除管理员")
	@PreAuthorize("hasAuthority('AP_PROJECT_SUPER_' + #projectId)")
	@RequestMapping(value = "/deleteByProjectAndManagerId", method = RequestMethod.GET)
	public JSONObject deleteByProjectAndManagerId(Long projectId, Long managerId) {
		return 1 == projectManagerService.deleteByProjectAndManagerId(projectId, managerId) ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "通过项目id获取所有管理员")
	@PreAuthorize("hasAuthority('AP_PROJECT_MANAGER_' + #id)")
	@RequestMapping(value = "/listManagersByProjectId", method = RequestMethod.GET)
	public JSONObject listManagersByProjectId(Long id) {
		List<UserDTO> list = projectOperationService.listManagersByProjectId(id);
		return null == list ? JsonUtil.fail() : JsonUtil.backObject(200, list);
	}

}
