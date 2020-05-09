package com.pytap.project.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.entity.ProjectVerification;
import com.pytap.project.utils.JsonUtil;
import com.pytap.project.web.service.ProjectVerificationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/5/6 22:26
 */
@RestController
@PreAuthorize("hasRole('R_USER')")
@RequestMapping("/web/project-verification")
public class ProjectVerificationController {

	@Resource
	private ProjectVerificationService projectVerificationService;

	@Log(value = "添加验证信息")
	@PreAuthorize("hasAuthority('AP_USER_' + #projectVerification.sendId) and hasAuthority('AP_PROJECT_MANAGER_' + #projectVerification.projectId)")
	@RequestMapping(value = "/insertProjectVerification", method = RequestMethod.POST)
	public JSONObject insertProjectVerification(@RequestBody ProjectVerification projectVerification) {
		return projectVerificationService.insertProjectVerification(projectVerification) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "主键删除验证信息")
	@PreAuthorize("hasAuthority('R_ADMIN')")
	@RequestMapping(value = "/deleteByProjectVerificationId", method = RequestMethod.GET)
	public JSONObject deleteByProjectVerificationId(Long id) {
		return projectVerificationService.deleteByProjectVerificationId(id) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "删除用户的所有验证消息")
	@PreAuthorize("hasAuthority('AP_USER_' + #id)")
	@RequestMapping(value = "/deleteByProjectVerificationReceiveId", method = RequestMethod.GET)
	public JSONObject deleteByProjectVerificationReceiveId(Long id) {
		return projectVerificationService.deleteByProjectVerificationReceiveId(id)  == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "删除项目的所有验证记录")
	@PreAuthorize("hasAuthority('AP_PROJECT_MANAGER_' + #id)")
	@RequestMapping(value = "/deleteByProjectVerificationProjectId", method = RequestMethod.GET)
	public JSONObject deleteByProjectVerificationProjectId(Long id) {
		return projectVerificationService.deleteByProjectVerificationProjectId(id)  == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "更新验证信息")
	@PreAuthorize("hasAuthority('AP_USER_' + #projectVerification.receiveId) and hasAuthority('AP_PROJECT_DEVELOPER_' + #projectVerification.getProjectId())")
	@RequestMapping(value = "/updateProjectVerificationByDeveloper", method = RequestMethod.POST)
	public JSONObject updateProjectVerificationByDeveloper(@RequestBody ProjectVerification projectVerification) {
		return projectVerificationService.updateProjectVerification(projectVerification) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "更新验证信息")
	@PreAuthorize("hasAuthority('AP_USER_' + #projectVerification.receiveId) and hasAuthority('AP_PROJECT_MANAGER_' + #projectVerification.getProjectId())")
	@RequestMapping(value = "/updateProjectVerificationByManager", method = RequestMethod.POST)
	public JSONObject updateProjectVerificationByManager(@RequestBody ProjectVerification projectVerification) {
		return projectVerificationService.updateProjectVerification(projectVerification) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "获取用户的所有验证信息")
	@PreAuthorize("hasAuthority('AP_USER_' + #id)")
	@RequestMapping(value = "/listProjectVerificationsByReceiveId", method = RequestMethod.GET)
	public JSONObject  listProjectVerificationsByReceiveId(Long id) {
		return JsonUtil.backObject(200, projectVerificationService.listProjectVerificationsByReceiveId(id));
	}

	@Log(value = "获取项目的所有验证信息")
	@PreAuthorize("hasAuthority('AP_PROJECT_MANAGER_' + #id)")
	@RequestMapping(value = "/listProjectVerificationsByProjectId", method = RequestMethod.GET)
	public JSONObject  listProjectVerificationsByProjectId(Long id) {
		return JsonUtil.backObject(200, projectVerificationService.listProjectVerificationsByProjectId(id));
	}

}
