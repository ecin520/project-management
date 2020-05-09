package com.pytap.project.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.entity.Project;
import com.pytap.project.utils.JsonUtil;
import com.pytap.project.web.service.ProjectService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/4/29 12:39
 */
@RestController
@PreAuthorize("hasRole('R_USER')")
@RequestMapping("/web/project")
public class ProjectController {

	@Resource
	private ProjectService projectService;

	@Log(value = "客户端获取用户创建的所有项目，只有该用户才能访问这个接口")
	@PreAuthorize("hasAuthority('AP_USER_' + #id)")
	@RequestMapping(value = "/listUserProjects", method = RequestMethod.GET)
	public JSONObject listUserProjects(Long id) {
		return JsonUtil.backObject(200, projectService.listUserProjects(id));
	}

	@Log(value = "客户端新建项目，没有该用户的AP不能调用此接口，意味着你不能帮别人添加项目")
	@PreAuthorize("hasAuthority('AP_USER_' + #project.creater)")
	@RequestMapping(value = "/insertProject", method = RequestMethod.POST)
	public JSONObject insertProject(@RequestBody Project project) {
		return 1 == projectService.insertProject(project) ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "项目主键删除项目，项目最高管理员才能删除项目")
	@PreAuthorize("hasAuthority('AP_PROJECT_SUPER_' + #id)")
	@RequestMapping(value = "/deleteProjectById", method = RequestMethod.GET)
	public JSONObject deleteProjectById(Long id) {
		return 1 == projectService.deleteProjectById(id) ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "更新项目")
	@PreAuthorize("hasAuthority('AP_PROJECT_MANAGER_' + #project.id)")
	@RequestMapping(value = "/updateProject", method = RequestMethod.POST)
	public JSONObject updateProject(@RequestBody Project project) {
		return 1 == projectService.updateProject(project) ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "获取项目")
	@PreAuthorize("hasAuthority('AP_PROJECT_MANAGER_' + #id)")
	@RequestMapping(value = "/getUserProject", method = RequestMethod.GET)
	public JSONObject getUserProject(Long id) {
		return JsonUtil.backObject(200, projectService.getUserProject(id));
	}


}
