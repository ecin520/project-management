package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.WebLog;
import com.pytap.project.entity.User;
import com.pytap.project.service.UserService;
import com.pytap.project.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

	@WebLog
	@RequestMapping(value = "countUser", method = RequestMethod.GET)
	public JSONObject countUser() {
		return JsonUtil.backObject(200, userService.countUser());
	}

	@WebLog
	@RequestMapping(value = "insertUser", method = RequestMethod.POST)
	public JSONObject insertUser(@RequestBody User user) {
		int result = userService.insertUser(user);
		if (result == 1) {
			return JsonUtil.success();
		}
		logger.info("插入用户失败 {}", JsonUtil.fail().toJSONString());
		return JsonUtil.fail();
	}

	@WebLog
	@RequestMapping(value = "deleteByUserId", method = RequestMethod.POST)
	public JSONObject deleteByUserId(Long id) {
		int result = userService.deleteByUserId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@WebLog
	@RequestMapping(value = "updateByUserId", method = RequestMethod.POST)
	public JSONObject updateByUserId(@RequestBody User user) {
		System.out.println(user.toString());
		int result = userService.updateByUserId(user);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@WebLog
	@RequestMapping(value = "getByUserId", method = RequestMethod.POST)
	public JSONObject getByUserId(Long id) {
		return JsonUtil.backObject(200, userService.getByUserId(id));
	}

	@WebLog
	@RequestMapping(value = "getByUsername", method = RequestMethod.POST)
	public JSONObject getByUsername(String username) {
		return JsonUtil.backObject(200, userService.getByUsername(username));
	}

	@WebLog
	@RequestMapping(value = "listAllUsers", method = RequestMethod.GET)
	public JSONObject listAllUsers(@RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
	                               @RequestParam(value = "pageSize", defaultValue = "0") Integer pageSize) {
		return JsonUtil.backObject(200, userService.listAllUsers(pageNum, pageSize));
	}

}
