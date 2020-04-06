package com.pytap.project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pytap.project.entity.UserAddPermission;
import com.pytap.project.service.UserAddPermissionService;
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
@RequestMapping("/admin/UserAddPermission")
@PreAuthorize("hasRole('R_ADMIN')")
public class UserAddPermissionController {

	@Resource
	private UserAddPermissionService userAddPermissionService;


	@RequestMapping(value = "insertUserAddPermission", method = RequestMethod.POST)
	public JSONObject insertUserAddPermission(UserAddPermission userAddPermission) {
		int result = userAddPermissionService.insertUserAddPermission(userAddPermission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "deleteByUserAddPermissionId", method = RequestMethod.POST)
	public JSONObject deleteByUserAddPermissionId(Long id) {
		int result = userAddPermissionService.deleteByUserAddPermissionId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "updateByUserAddPermissionId", method = RequestMethod.POST)
	public JSONObject updateByUserAddPermissionId(UserAddPermission userAddPermission) {
		int result = userAddPermissionService.updateByUserAddPermissionId(userAddPermission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "getByUserAddPermissionId", method = RequestMethod.POST)
	public UserAddPermission getByUserAddPermissionId(Long id) {
		return userAddPermissionService.getByUserAddPermissionId(id);
	}

	@RequestMapping(value = "listAllUserAddPermissions", method = RequestMethod.GET)
	public List<UserAddPermission> listAllUserAddPermissions() {
		return userAddPermissionService.listAllUserAddPermissions();
	}

}