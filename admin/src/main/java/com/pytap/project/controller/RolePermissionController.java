package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.WebLog;
import com.pytap.project.entity.RolePermission;
import com.pytap.project.service.RolePermissionService;
import com.pytap.project.utils.JsonUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/3/31 15:05
 */
@RestController
@RequestMapping("/admin/RolePermission")
@PreAuthorize("hasRole('R_ADMIN')")
public class RolePermissionController {

	@Resource
	private RolePermissionService rolePermissionService;

	@WebLog
	@RequestMapping(value = "insertRolePermission", method = RequestMethod.POST)
	public JSONObject insertRolePermission(RolePermission rolePermission) {
		int result = rolePermissionService.insertRolePermission(rolePermission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@WebLog
	@RequestMapping(value = "deleteByRolePermissionId", method = RequestMethod.POST)
	public JSONObject deleteByRolePermissionId(Long id) {
		int result = rolePermissionService.deleteByRolePermissionId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@WebLog
	@RequestMapping(value = "updateByRolePermissionId", method = RequestMethod.POST)
	public JSONObject updateByRolePermissionId(RolePermission rolePermission) {
		int result = rolePermissionService.updateByRolePermissionId(rolePermission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@WebLog
	@RequestMapping(value = "getByRolePermissionId", method = RequestMethod.POST)
	public JSONObject getByRolePermissionId(Long id) {
		return JsonUtil.backObject(200, rolePermissionService.getByRolePermissionId(id));
	}

	@WebLog
	@RequestMapping(value = "listAllRolePermissions", method = RequestMethod.GET)
	public JSONObject listAllRolePermissions() {
		return JsonUtil.backObject(200, rolePermissionService.listAllRolePermissions());
	}

}
