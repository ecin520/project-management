package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.WebLog;
import com.pytap.project.entity.UserAddPermission;
import com.pytap.project.service.UserAddPermissionService;
import com.pytap.project.utils.JsonUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/3/31 15:05
 */
@RestController
@RequestMapping("/admin/UserAddPermission")
@PreAuthorize("hasRole('R_ADMIN')")
public class UserAddPermissionController {

	@Resource
	private UserAddPermissionService userAddPermissionService;

	@WebLog(value = "插入用户附加权限关系")
	@RequestMapping(value = "insertUserAddPermission", method = RequestMethod.POST)
	public JSONObject insertUserAddPermission(UserAddPermission userAddPermission) {
		int result = userAddPermissionService.insertUserAddPermission(userAddPermission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@WebLog(value = "删除用户附加权限关系")
	@RequestMapping(value = "deleteByUserAddPermission", method = RequestMethod.POST)
	public JSONObject deleteByUserAddPermission(@RequestBody UserAddPermission userAddPermission) {
		int result = userAddPermissionService.deleteByUserAddPermission(userAddPermission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@WebLog(value = "更新用户附加权限关系")
	@RequestMapping(value = "updateByUserAddPermissionId", method = RequestMethod.POST)
	public JSONObject updateByUserAddPermissionId(UserAddPermission userAddPermission) {
		int result = userAddPermissionService.updateByUserAddPermissionId(userAddPermission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@WebLog(value = "获取用户附加权限关系")
	@RequestMapping(value = "getByUserAddPermissionId", method = RequestMethod.POST)
	public JSONObject getByUserAddPermissionId(Long id) {
		return JsonUtil.backObject(200, userAddPermissionService.getByUserAddPermissionId(id));
	}

	@WebLog(value = "插入所有用户附加权限关系")
	@RequestMapping(value = "listAllUserAddPermissions", method = RequestMethod.GET)
	public JSONObject listAllUserAddPermissions() {
		return JsonUtil.backObject(200, userAddPermissionService.listAllUserAddPermissions());
	}

}
