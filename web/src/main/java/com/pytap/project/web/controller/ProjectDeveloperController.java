package com.pytap.project.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.entity.Project;
import com.pytap.project.entity.ProjectDeveloper;
import com.pytap.project.utils.JsonUtil;
import com.pytap.project.web.model.dto.UserDTO;
import com.pytap.project.web.service.ProjectDeveloperService;
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
 * @date 2020/5/1 0:03
 */
@RestController
@PreAuthorize("hasRole('R_USER')")
@RequestMapping("/web/project-developer")
public class ProjectDeveloperController {
	@Resource
	private ProjectDeveloperService projectDeveloperService;

	@Resource
	private ProjectOperationService projectOperationService;

	@Log(value = "添加项目管理员")
	@PreAuthorize("hasAuthority('AP_PROJECT_SUPER_' + #projectDeveloper.projectId)")
	@RequestMapping(value = "/insertProjectDeveloper", method = RequestMethod.POST)
	public JSONObject insertProjectDeveloper(@RequestBody ProjectDeveloper projectDeveloper) {
		return 1 == projectDeveloperService.insertProjectDeveloper(projectDeveloper) ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "获取用户开发的所有项目")
	@PreAuthorize("hasAuthority('AP_PROJECT_USER_' + #id)")
	@RequestMapping(value = "/listProjectsByDeveloperId", method = RequestMethod.GET)
	public JSONObject listProjectsByDeveloperId(Long id) {
		List<Project> list = projectOperationService.listProjectsByDeveloperId(id);
		return null == list ? JsonUtil.fail() : JsonUtil.backObject(200, list);
	}

	@Log(value = "通过项目id和管理员id删除管理员")
	@PreAuthorize("hasAuthority('AP_PROJECT_SUPER_' + #projectId)")
	@RequestMapping(value = "/deleteByProjectAndDeveloperId", method = RequestMethod.GET)
	public JSONObject deleteByProjectAndDeveloperId(Long projectId, Long developerId) {
		return 1 == projectDeveloperService.deleteByProjectAndDeveloperId(projectId, developerId) ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "通过项目id获取所有开发者")
	@PreAuthorize("hasAuthority('AP_PROJECT_MANAGER_' + #id)")
	@RequestMapping(value = "/listDevelopersByProjectId", method = RequestMethod.GET)
	public JSONObject listDevelopersByProjectId(Long id) {
		List<UserDTO> list = projectOperationService.listDevelopersByProjectId(id);
		return null == list ? JsonUtil.fail() : JsonUtil.backObject(200, list);
	}
}
