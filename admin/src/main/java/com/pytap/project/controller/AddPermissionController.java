package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.entity.AddPermission;
import com.pytap.project.service.AddPermissionService;
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
@RequestMapping("/admin/AddPermission")
//@PreAuthorize("hasRole('R_ADMIN')")
public class AddPermissionController {

	@Resource
	private AddPermissionService addPermissionService;

	@RequestMapping(value = "insertAddPermission", method = RequestMethod.POST)
	public JSONObject insertAddPermission(AddPermission addPermission) {
		int result = addPermissionService.insertAddPermission(addPermission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "deleteByAddPermissionId", method = RequestMethod.POST)
	public JSONObject deleteByAddPermissionId(Long id) {
		int result = addPermissionService.deleteByAddPermissionId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "updateByAddPermissionId", method = RequestMethod.POST)
	public JSONObject updateByAddPermissionId(AddPermission addPermission) {
		int result = addPermissionService.updateByAddPermissionId(addPermission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "getByAddPermissionId", method = RequestMethod.POST)
	public AddPermission getByAddPermissionId(Long id) {
		return addPermissionService.getByAddPermissionId(id);
	}

	@RequestMapping(value = "listAllAddPermissions", method = RequestMethod.GET)
	public List<AddPermission> listAllAddPermissions() {
		return addPermissionService.listAllAddPermissions();
	}
}
