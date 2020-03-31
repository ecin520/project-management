package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.service.AdminUserService;
import com.pytap.project.utils.JsonUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/3/30 18:05
 */
@RestController
@RequestMapping("/common")
public class CommonController {

	@Resource
	private AdminUserService adminUserService;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ApiOperation(value = "登录")
	public JSONObject login(String username, String password) {
		String token = adminUserService.login(username, password);
		return JsonUtil.backInfo(200, "Bearer" + token);
	}

	@RequestMapping(value = "auth-project", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('AP_' + #id)")
	@ApiOperation(value = "测试权限")
	public JSONObject auth(Long id) {
		return JsonUtil.success();
	}

}
