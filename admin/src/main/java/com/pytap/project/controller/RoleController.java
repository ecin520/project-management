package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.entity.Role;
import com.pytap.project.service.RoleService;
import com.pytap.project.utils.JsonUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

	@Log(value = "获取角色总数量")
	@RequestMapping(value = "countRole", method = RequestMethod.GET)
	public JSONObject countUser() {
		return JsonUtil.backObject(200, roleService.countRole());
	}

	@Log(value = "插入角色")
	@RequestMapping(value = "insertRole", method = RequestMethod.POST)
	public JSONObject insertRole(@RequestBody Role role) {
		int result = roleService.insertRole(role);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "删除角色")
	@RequestMapping(value = "deleteByRoleId", method = RequestMethod.POST)
	public JSONObject deleteByRoleId(Long id){
		int result = roleService.deleteByRoleId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "更新角色")
	@RequestMapping(value = "updateByRoleId", method = RequestMethod.POST)
	public JSONObject updateByRoleId(@RequestBody Role role){
		int result = roleService.updateByRoleId(role);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "获取角色")
	@RequestMapping(value = "getRole", method = RequestMethod.POST)
	public JSONObject getRole(Role role){
		return JsonUtil.backObject(200, roleService.getRole(role));
	}

	@Log(value = "获取所有角色")
	@RequestMapping(value = "listAllRoles", method = RequestMethod.GET)
	public JSONObject listAllRoles(@RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
	                               @RequestParam(value = "pageSize", defaultValue = "0") Integer pageSize){
		return JsonUtil.backObject(200, roleService.listAllRoles(pageNum, pageSize));
	}


}
