package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.WebLog;
import com.pytap.project.entity.User;
import com.pytap.project.model.dto.AuthDTO;
import com.pytap.project.model.dto.UserAuthDTO;
import com.pytap.project.service.AdminUserService;
import com.pytap.project.service.UserService;
import com.pytap.project.utils.JsonUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/30 18:05
 */
@RestController
@RequestMapping("/common")
public class CommonController {

	@Resource
	private AdminUserService adminUserService;

	@Resource
	private UserService userService;

	@WebLog(value = "登录接口")
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public JSONObject login(String username, String password) {
		String token = adminUserService.login(username, password);
		User user = userService.getByUsername(username);
		List<AuthDTO> list = adminUserService.listUserAllRolePermissions(user.getId());
		for (AuthDTO authDTO : list) {
			if ("R_ADMIN".equals(authDTO.getName())) {
				UserAuthDTO userDTO = new UserAuthDTO();
				BeanUtils.copyProperties(user, userDTO);
				userDTO.setPermission(list);
				return JsonUtil.loginSuccess(200, token, userDTO);
			}
		}
		throw new AccessDeniedException("账户无访问权限，请联系管理员");
	}

	@WebLog
	@RequestMapping(value = "auth-project", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('AP_' + #id)")
	@ApiOperation(value = "测试权限")
	public JSONObject auth(Long id) {
		return JsonUtil.success();
	}

}
