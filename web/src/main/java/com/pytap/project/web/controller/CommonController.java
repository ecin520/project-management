package com.pytap.project.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.pojo.CaptchaImage;
import com.pytap.project.utils.CaptchaUtil;
import com.pytap.project.utils.JsonUtil;
import com.pytap.project.web.model.dto.UserDTO;
import com.pytap.project.web.service.CommonService;
import com.pytap.project.web.service.UserService;
import com.pytap.project.web.utils.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ecin520
 * @date 2020/4/27 21:34
 */
@RestController
@RequestMapping("/web/common")
public class CommonController {

	private static final String SESSION_IMAGE_KEY = "ImageCode";

	@Resource
	private CommonService commonService;

	@Resource
	private UserService userService;

	@Resource
	private RedisUtil redisUtil;

	@Log(value = "客户端用户登录")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public JSONObject login(HttpServletRequest request, String username, String password, String code) {

		String redisCode = (String) redisUtil.get(SESSION_IMAGE_KEY + request.getSession().getId());

		if (null == redisCode) {
			return JsonUtil.backInfo(400, "验证码失效，请刷新验证码");
		}

		if (!code.toLowerCase().equals(redisCode.toLowerCase())) {
			return JsonUtil.backInfo(400, "验证码输入有误，请重新输入");
		}

		// 从redis删除验证码
		redisUtil.remove(SESSION_IMAGE_KEY + request.getSession().getId());

		String token = commonService.login(username, password);

		UserDTO userDTO = userService.getDtoByUsername(username);

		return JsonUtil.loginSuccess(200, token, userDTO);
	}

	@Log(value = "客户端注册")
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public JSONObject register(String username, String password) {
		Integer result = commonService.register(username, password);
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@Log(value = "生成验证码")
	@RequestMapping(value = "/createImageCode", method = RequestMethod.GET)
	public void createImageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CaptchaUtil captchaUtil = new CaptchaUtil();
		CaptchaImage captchaImage = captchaUtil.createRandCode();

		redisUtil.set(SESSION_IMAGE_KEY + request.getSession().getId(), captchaImage.getResult(), 120);
		ImageIO.write(captchaImage.getBufferedImage(), "JPEG", response.getOutputStream());
	}

}
