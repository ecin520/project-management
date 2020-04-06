package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.entity.Permission;
import com.pytap.project.service.PermissionService;
import com.pytap.project.utils.JsonUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 15:04
 */
@RestController
@RequestMapping("/admin/Permission")
@PreAuthorize("hasRole('R_ADMIN')")
public class PermissionController {

	@Resource
	private PermissionService permissionService;


	@RequestMapping(value = "insertPermission", method = RequestMethod.POST)
	public JSONObject insertPermission(Permission permission) {
		int result = permissionService.insertPermission(permission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "deleteByPermissionId", method = RequestMethod.POST)
	public JSONObject deleteByPermissionId(Long id) {
		int result = permissionService.deleteByPermissionId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "updateByPermissionId", method = RequestMethod.POST)
	public JSONObject updateByPermissionId(Permission permission) {
		int result = permissionService.updateByPermissionId(permission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "getByPermissionId", method = RequestMethod.POST)
	public Permission getByPermissionId(Long id) {
		return permissionService.getByPermissionId(id);
	}
	@RequestMapping(value = "listAllPermissions", method = RequestMethod.GET)
	public  List<Permission> listAllPermissions() {
		return permissionService.listAllPermissions();
	}

}
