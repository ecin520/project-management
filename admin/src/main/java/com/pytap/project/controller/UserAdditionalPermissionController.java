package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.entity.UserAdditionalPermission;
import com.pytap.project.service.UserAdditionalPermissionService;
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
@RequestMapping("/admin/UserAdditionalPermission")
@PreAuthorize("hasRole('R_ADMIN')")
public class UserAdditionalPermissionController {

	@Resource
	private UserAdditionalPermissionService userAdditionalPermissionService;

	@Log(value = "插入用户附加权限关系")
	@RequestMapping(value = "insertUserAdditionalPermission", method = RequestMethod.POST)
	public JSONObject insertUserAdditionalPermission(@RequestBody UserAdditionalPermission userAdditionalPermission) {
		int result = userAdditionalPermissionService.insertUserAdditionalPermission(userAdditionalPermission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "主键删除用户附加权限关系")
	@RequestMapping(value = "deleteByUserAdditionalPermissionId", method = RequestMethod.GET)
	public JSONObject deleteByUserAdditionalPermissionId(Long id) {
		int result = userAdditionalPermissionService.deleteByUserAdditionalPermissionId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "用户id和附加权限id删除用户附加权限关系")
	@RequestMapping(value = "deleteByUserAndAdditionalPermissionId", method = RequestMethod.GET)
	public JSONObject deleteByUserAndAdditionalPermissionId(Long userId, Long additionalPermissionId) {
		int result = userAdditionalPermissionService.deleteByUserAndAdditionalPermissionId(userId, additionalPermissionId);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "更新用户附加权限关系")
	@RequestMapping(value = "updateByUserAdditionalPermissionId", method = RequestMethod.POST)
	public JSONObject updateByUserAdditionalPermissionId(@RequestBody UserAdditionalPermission userAdditionalPermission) {
		int result = userAdditionalPermissionService.updateByUserAdditionalPermissionId(userAdditionalPermission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "获取用户附加权限关系")
	@RequestMapping(value = "getByUserAdditionalPermissionId", method = RequestMethod.GET)
	public JSONObject getByUserAdditionalPermissionId(Long id) {
		return JsonUtil.backObject(200, userAdditionalPermissionService.getByUserAdditionalPermissionId(id));
	}

	@Log(value = "列出所有用户附加权限关系")
	@RequestMapping(value = "listAllUserAdditionalPermissions", method = RequestMethod.GET)
	public JSONObject listAllUserAdditionalPermissions() {
		return JsonUtil.backObject(200, userAdditionalPermissionService.listAllUserAdditionalPermissions());
	}

}
