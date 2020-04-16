package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
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

	@Log(value = "获取用户总数量")
	@RequestMapping(value = "countUser", method = RequestMethod.GET)
	public JSONObject countUser() {
		return JsonUtil.backObject(200, userService.countUser());
	}

	@Log(value = "插入用户")
	@RequestMapping(value = "insertUser", method = RequestMethod.POST)
	public JSONObject insertUser(@RequestBody User user) {
		int result = userService.insertUser(user);
		if (result == 1) {
			return JsonUtil.success();
		}
		logger.info("插入用户失败 {}", JsonUtil.fail().toJSONString());
		return JsonUtil.fail();
	}

	@Log(value = "删除用户")
	@RequestMapping(value = "deleteByUserId", method = RequestMethod.POST)
	public JSONObject deleteByUserId(Long id) {
		int result = userService.deleteByUserId(id);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "更新用户")
	@RequestMapping(value = "updateByUserId", method = RequestMethod.POST)
	public JSONObject updateByUserId(@RequestBody User user) {
		System.out.println(user.toString());
		int result = userService.updateByUserId(user);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "主键获取用户")
	@RequestMapping(value = "getByUserId", method = RequestMethod.POST)
	public JSONObject getByUserId(Long id) {
		return JsonUtil.backObject(200, userService.getByUserId(id));
	}

	@Log(value = "用户名获取用户")
	@RequestMapping(value = "getByUsername", method = RequestMethod.POST)
	public JSONObject getByUsername(String username) {
		return JsonUtil.backObject(200, userService.getByUsername(username));
	}

	@Log(value = "分页获取用户")
	@RequestMapping(value = "listAllUsers", method = RequestMethod.GET)
	public JSONObject listAllUsers(@RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
	                               @RequestParam(value = "pageSize", defaultValue = "0") Integer pageSize) {
		return JsonUtil.backObject(200, userService.listAllUsers(pageNum, pageSize));
	}

}
