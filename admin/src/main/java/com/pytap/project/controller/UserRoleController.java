package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.entity.UserRole;
import com.pytap.project.service.UserRoleService;
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
@RequestMapping("/admin/UserRole")
@PreAuthorize("hasRole('R_ADMIN')")
public class UserRoleController {

	@Resource
	private UserRoleService userRoleService;

	@Log(value = "插入用户角色关系")
	@RequestMapping(value = "insertUserRole", method = RequestMethod.POST)
	public JSONObject insertUserRole(@RequestBody UserRole userRole) {
		int result = userRoleService.insertUserRole(userRole);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "主键删除用户角色关系")
	@RequestMapping(value = "deleteByUserRoleId", method = RequestMethod.GET)
	public JSONObject deleteByUserRole(Long id) {
		int result = userRoleService.deleteByUserRoleId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "用户和角色id删除用户角色关系")
	@RequestMapping(value = "deleteByUserAndRoleId", method = RequestMethod.GET)
	public JSONObject deleteByUserRole(Long userId, Long roleId) {
		int result = userRoleService.deleteByUserAndRoleId(userId, roleId);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "更新用户角色关系")
	@RequestMapping(value = "updateByUserRole", method = RequestMethod.POST)
	public JSONObject updateByUserRoleId(@RequestBody UserRole userRole) {
		int result = userRoleService.updateByUserRole(userRole);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "获取用户角色关系")
	@RequestMapping(value = "getByUserRoleId", method = RequestMethod.GET)
	public JSONObject getByUserRoleId(Long id) {
		return JsonUtil.backObject(200, userRoleService.getByUserRoleId(id));
	}

	@Log(value = "获取所有用户角色关系")
	@RequestMapping(value = "listAllUserRoles", method = RequestMethod.GET)
	public JSONObject listAllUserRoles() {
		return JsonUtil.backObject(200, userRoleService.listAllUserRoles());
	}

}
