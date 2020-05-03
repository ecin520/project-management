package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.entity.Permission;
import com.pytap.project.service.PermissionService;
import com.pytap.project.utils.JsonUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

	@Log(value = "获取权限总数量")
	@RequestMapping(value = "countPermission", method = RequestMethod.GET)
	public JSONObject countUser() {
		return JsonUtil.backObject(200, permissionService.countPermission());
	}

	@Log(value = "插入权限")
	@RequestMapping(value = "insertPermission", method = RequestMethod.POST)
	public JSONObject insertPermission(@RequestBody Permission permission) {
		int result = permissionService.insertPermission(permission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "删除权限")
	@RequestMapping(value = "deleteByPermissionId", method = RequestMethod.GET)
	public JSONObject deleteByPermissionId(Long id) {
		int result = permissionService.deleteByPermissionId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "更新权限")
	@RequestMapping(value = "updateByPermissionId", method = RequestMethod.POST)
	public JSONObject updateByPermissionId(@RequestBody Permission permission) {
		int result = permissionService.updateByPermissionId(permission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "获取权限")
	@RequestMapping(value = "getPermission", method = RequestMethod.POST)
	public JSONObject getPermission(@RequestBody Permission permission) {
		return JsonUtil.backObject(200, permissionService.getPermission(permission));
	}

	@Log(value = "获取所有权限")
	@RequestMapping(value = "listAllPermissions", method = RequestMethod.GET)
	public  JSONObject listAllPermissions(@RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
	                                      @RequestParam(value = "pageSize", defaultValue = "0") Integer pageSize) {
		return JsonUtil.backObject(200, permissionService.listAllPermissions(pageNum, pageSize));
	}

}
