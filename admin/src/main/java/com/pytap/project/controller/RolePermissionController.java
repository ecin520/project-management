package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.entity.RolePermission;
import com.pytap.project.service.RolePermissionService;
import com.pytap.project.utils.JsonUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 15:05
 */
@RestController
@RequestMapping("/admin/RolePermission")
//@PreAuthorize("hasRole('R_ADMIN')")
public class RolePermissionController {

	@Resource
	private RolePermissionService rolePermissionService;

	@RequestMapping(value = "insertRolePermission", method = RequestMethod.POST)
	public JSONObject insertRolePermission(RolePermission rolePermission) {
		int result = rolePermissionService.insertRolePermission(rolePermission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "deleteByRolePermissionId", method = RequestMethod.POST)
	public JSONObject deleteByRolePermissionId(Long id) {
		int result = rolePermissionService.deleteByRolePermissionId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "updateByRolePermissionId", method = RequestMethod.POST)
	public JSONObject updateByRolePermissionId(RolePermission rolePermission) {
		int result = rolePermissionService.updateByRolePermissionId(rolePermission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "getByRolePermissionId", method = RequestMethod.POST)
	public RolePermission getByRolePermissionId(Long id) {
		return rolePermissionService.getByRolePermissionId(id);
	}

	@RequestMapping(value = "listAllRolePermissions", method = RequestMethod.GET)
	public List<RolePermission> listAllRolePermissions() {
		return rolePermissionService.listAllRolePermissions();
	}

}
