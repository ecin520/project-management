package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.entity.Role;
import com.pytap.project.service.RoleService;
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
@RequestMapping("/admin/Role")
@PreAuthorize("hasRole('R_ADMIN')")
public class RoleController {

	@Resource
	private RoleService roleService;

	@RequestMapping(value = "insertRole", method = RequestMethod.POST)
	public JSONObject insertRole(Role role) {
		int result = roleService.insertRole(role);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "deleteByRoleId", method = RequestMethod.POST)
	public JSONObject deleteByRoleId(Long id){
		int result = roleService.deleteByRoleId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "updateByRoleId", method = RequestMethod.POST)
	public JSONObject updateByRoleId(Role role){
		int result = roleService.updateByRoleId(role);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "getByRoleId", method = RequestMethod.POST)
	public Role getByRoleId(Long id){
		return roleService.getByRoleId(id);
	}

	@RequestMapping(value = "listAllRoles", method = RequestMethod.GET)
	public List<Role> listAllRoles(){
		return roleService.listAllRoles();
	}


}
