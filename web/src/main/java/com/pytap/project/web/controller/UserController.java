package com.pytap.project.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.entity.User;
import com.pytap.project.utils.JsonUtil;
import com.pytap.project.web.model.dto.UserDTO;
import com.pytap.project.web.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/4/29 13:50
 */
@RestController
@PreAuthorize("hasRole('R_USER')")
@RequestMapping("/web/user")
public class UserController {

	@Resource
	private UserService userService;

	@Log(value = "用户信息修改")
	@PreAuthorize("hasAuthority('AP_USER_' + #user.getId())")
	@RequestMapping(value = "/updateByUserId", method = RequestMethod.POST)
	public JSONObject updateByUserId(@RequestBody User user) {
		if (1 == userService.updateByUserId(user)) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}


	@Log(value = "主键获取用户信息")
	@RequestMapping(value = "/getByUserId", method = RequestMethod.GET)
	public JSONObject getByUserId(Long id) {
		UserDTO userDTO = userService.getDtoByUserId(id);
		return null == userDTO ? JsonUtil.fail() : JsonUtil.backObject(200, userDTO);
	}

	@Log(value = "用户名获取用户信息")
	@RequestMapping(value = "/getByUsername", method = RequestMethod.GET)
	public JSONObject getByUsername(String username) {
		UserDTO userDTO = userService.getDtoByUsername(username);
		return null == userDTO ? JsonUtil.fail() : JsonUtil.backObject(200, userDTO);
	}

}
