package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.entity.UserRole;
import com.pytap.project.service.UserRoleService;
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
@RequestMapping("/admin/UserRole")
//@PreAuthorize("hasRole('R_ADMIN')")
public class UserRoleController {

	@Resource
	private UserRoleService userRoleService;

	@RequestMapping(value = "insertUserRole", method = RequestMethod.POST)
	public JSONObject insertUserRole(UserRole userRole) {
		int result = userRoleService.insertUserRole(userRole);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "deleteByUserRoleI", method = RequestMethod.POST)
	public JSONObject deleteByUserRoleId(Long id) {
		int result = userRoleService.deleteByUserRoleId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "updateByUserRoleId", method = RequestMethod.POST)
	public JSONObject updateByUserRoleId(UserRole userRole) {
		int result = userRoleService.updateByUserRoleId(userRole);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "getByUserRoleId", method = RequestMethod.POST)
	public UserRole getByUserRoleId(Long id) {
		return userRoleService.getByUserRoleId(id);
	}

	@RequestMapping(value = "listAllUserRoles", method = RequestMethod.GET)
	public List<UserRole> listAllUserRoles() {
		return userRoleService.listAllUserRoles();
	}

}
