package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.WebLog;
import com.pytap.project.entity.Role;
import com.pytap.project.service.RoleService;
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
@RequestMapping("/admin/Role")
@PreAuthorize("hasRole('R_ADMIN')")
public class RoleController {

	@Resource
	private RoleService roleService;

	@WebLog
	@RequestMapping(value = "insertRole", method = RequestMethod.POST)
	public JSONObject insertRole(Role role) {
		int result = roleService.insertRole(role);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@WebLog
	@RequestMapping(value = "deleteByRoleId", method = RequestMethod.POST)
	public JSONObject deleteByRoleId(Long id){
		int result = roleService.deleteByRoleId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@WebLog
	@RequestMapping(value = "updateByRoleId", method = RequestMethod.POST)
	public JSONObject updateByRoleId(Role role){
		int result = roleService.updateByRoleId(role);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@WebLog
	@RequestMapping(value = "getRole", method = RequestMethod.POST)
	public JSONObject getRole(Role role){
		return JsonUtil.backObject(200, roleService.getRole(role));
	}

	@WebLog
	@RequestMapping(value = "listAllRoles", method = RequestMethod.GET)
	public JSONObject listAllRoles(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
	                               @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize){
		return JsonUtil.backObject(200, roleService.listAllRoles(pageNum, pageSize));
	}


}
