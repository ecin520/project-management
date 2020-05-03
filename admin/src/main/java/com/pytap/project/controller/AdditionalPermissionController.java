package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.entity.AdditionalPermission;
import com.pytap.project.service.AdditionalPermissionService;
import com.pytap.project.utils.JsonUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/3/31 15:04
 */
@RestController
@RequestMapping("/admin/AdditionalPermission")
@PreAuthorize("hasRole('R_ADMIN')")
public class AdditionalPermissionController {

	@Resource
	private AdditionalPermissionService additionalPermissionService;

	@Log(value = "插入权限")
	@RequestMapping(value = "insertAdditionalPermission", method = RequestMethod.POST)
	public JSONObject insertAdditionalPermission(@RequestBody AdditionalPermission additionalPermission) {
		System.out.println(additionalPermission.toString());
		int result = additionalPermissionService.insertAdditionalPermission(additionalPermission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "除附加权限")
	@RequestMapping(value = "deleteByAdditionalPermissionId", method = RequestMethod.GET)
	public JSONObject deleteByAdditionalPermissionId(Long id) {
		int result = additionalPermissionService.deleteByAdditionalPermissionId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "更新附加权限")
	@RequestMapping(value = "updateByAdditionalPermissionId", method = RequestMethod.POST)
	public JSONObject updateByAdditionalPermissionId(@RequestBody AdditionalPermission additionalPermission) {
		int result = additionalPermissionService.updateByAdditionalPermissionId(additionalPermission);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "获取附加权限")
	@RequestMapping(value = "getAdditionalPermission", method = RequestMethod.POST)
	public JSONObject getAdditionalPermission(@RequestBody AdditionalPermission additionalPermission) {
		return JsonUtil.backObject(200, additionalPermissionService.getAdditionalPermission(additionalPermission));
	}

	@Log(value = "列出所有附加权限")
	@RequestMapping(value = "listAllAdditionalPermissions", method = RequestMethod.GET)
	public JSONObject listAllAdditionalPermissions() {
		return JsonUtil.backObject(200, additionalPermissionService.listAllAdditionalPermissions());
	}
}
