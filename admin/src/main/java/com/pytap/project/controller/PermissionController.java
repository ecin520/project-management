package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.WebLog;
import com.pytap.project.entity.Permission;
import com.pytap.project.service.PermissionService;
import com.pytap.project.utils.JsonUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	@WebLog
	@RequestMapping(value = "insertPermission", method = RequestMethod.POST)
	public JSONObject insertPermission(Permission permission) {
		int result = permissionService.insertPermission(permission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@WebLog
	@RequestMapping(value = "deleteByPermissionId", method = RequestMethod.POST)
	public JSONObject deleteByPermissionId(Long id) {
		int result = permissionService.deleteByPermissionId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@WebLog
	@RequestMapping(value = "updateByPermissionId", method = RequestMethod.POST)
	public JSONObject updateByPermissionId(Permission permission) {
		int result = permissionService.updateByPermissionId(permission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@WebLog
	@RequestMapping(value = "getPermission", method = RequestMethod.POST)
	public JSONObject getPermission(Permission permission) {
		return JsonUtil.backObject(200, permissionService.getPermission(permission));
	}

	@WebLog
	@RequestMapping(value = "listAllPermissions", method = RequestMethod.GET)
	public  JSONObject listAllPermissions(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
	                                      @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {
		return JsonUtil.backObject(200, permissionService.listAllPermissions(pageNum, pageSize));
	}

}
