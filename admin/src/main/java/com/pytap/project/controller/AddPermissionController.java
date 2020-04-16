package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.entity.AddPermission;
import com.pytap.project.service.AddPermissionService;
import com.pytap.project.utils.JsonUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/3/31 15:04
 */
@RestController
@RequestMapping("/admin/AddPermission")
@PreAuthorize("hasRole('R_ADMIN')")
public class AddPermissionController {

	@Resource
	private AddPermissionService addPermissionService;

	@Log(value = "插入权限")
	@RequestMapping(value = "insertAddPermission", method = RequestMethod.POST)
	public JSONObject insertAddPermission(AddPermission addPermission) {
		System.out.println(addPermission.toString());
		int result = addPermissionService.insertAddPermission(addPermission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "除附加权限")
	@RequestMapping(value = "deleteByAddPermissionId", method = RequestMethod.POST)
	public JSONObject deleteByAddPermissionId(Long id) {
		int result = addPermissionService.deleteByAddPermissionId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "更新附加权限")
	@RequestMapping(value = "updateByAddPermissionId", method = RequestMethod.POST)
	public JSONObject updateByAddPermissionId(AddPermission addPermission) {
		int result = addPermissionService.updateByAddPermissionId(addPermission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "获取附加权限")
	@RequestMapping(value = "getAddPermission", method = RequestMethod.POST)
	public JSONObject getAddPermission(AddPermission addPermission) {
		return JsonUtil.backObject(200, addPermissionService.getAddPermission(addPermission));
	}

	@Log(value = "列出所有附加权限")
	@RequestMapping(value = "listAllAddPermissions", method = RequestMethod.GET)
	public JSONObject listAllAddPermissions() {
		return JsonUtil.backObject(200, addPermissionService.listAllAddPermissions());
	}
}
