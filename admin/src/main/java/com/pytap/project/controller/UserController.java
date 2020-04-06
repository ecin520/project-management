package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.entity.User;
import com.pytap.project.service.UserService;
import com.pytap.project.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/30 23:33
 */
@RestController
@RequestMapping("/admin/User")
@PreAuthorize("hasRole('R_ADMIN')")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource
	private UserService userService;

	@RequestMapping(value = "insertUser", method = RequestMethod.POST)
	public JSONObject insertUser(User user) {
		int result = userService.insertUser(user);
		if (result == 1) {
			return JsonUtil.success();
		}
		logger.info("插入用户失败 {}", JsonUtil.fail().toJSONString());
		return JsonUtil.fail();
	}

	@RequestMapping(value = "deleteByUserId", method = RequestMethod.POST)
	public JSONObject deleteByUserId(Long id) {
		int result = userService.deleteByUserId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "updateByUserId", method = RequestMethod.POST)
	public JSONObject updateByUserId(User user) {
		int result = userService.updateByUserId(user);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "getByUserId", method = RequestMethod.POST)
	public User getByUserId(Long id) {
		return userService.getByUserId(id);
	}

	@RequestMapping(value = "getByUsername", method = RequestMethod.POST)
	public User getByUsername(String username) {
		return userService.getByUsername(username);
	}

	@RequestMapping(value = "listAllUsers", method = RequestMethod.GET)
	public List<User> listAllUsers() {
		return userService.listAllUsers();
	}

}
