package com.pytap.project.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.entity.ProjectType;
import com.pytap.project.utils.JsonUtil;
import com.pytap.project.web.service.ProjectTypeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/5/5 20:29
 */
@RestController
@PreAuthorize("hasRole('R_USER')")
@RequestMapping("/web/project-type")
public class ProjectTypeController {

	@Resource
	private ProjectTypeService projectTypeService;

	@Log(value = "添加项目类型")
	@PreAuthorize("hasAuthority('R_ADMIN')")
	@RequestMapping(value = "/insertProjectType", method = RequestMethod.POST)
	public JSONObject insertProjectType(@RequestBody ProjectType projectType) {
		return projectTypeService.insertProjectType(projectType) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "主键删除项目类型")
	@PreAuthorize("hasAuthority('R_ADMIN')")
	@RequestMapping(value = "/deleteByProjectTypeId", method = RequestMethod.GET)
	public JSONObject deleteByProjectTypeId(Long id) {
		return projectTypeService.deleteByProjectTypeId(id) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "通过名称删除项目类型")
	@PreAuthorize("hasAuthority('R_ADMIN')")
	@RequestMapping(value = "/deleteByProjectTypeName", method = RequestMethod.GET)
	public JSONObject deleteByProjectTypeName(String name) {
		return projectTypeService.deleteByProjectTypeName(name) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "更新项目类型")
	@PreAuthorize("hasAuthority('R_ADMIN')")
	@RequestMapping(value = "/updateProjectType", method = RequestMethod.POST)
	public JSONObject updateProjectType(@RequestBody ProjectType projectType) {
		return projectTypeService.updateProjectType(projectType) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "获取所有项目类型")
	@RequestMapping(value = "/listProjectTypes", method = RequestMethod.GET)
	public JSONObject listProjectTypes() {
		return JsonUtil.backObject(200, projectTypeService.listProjectTypes());
	}
}
