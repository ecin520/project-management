package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.dto.ErrorLogDTO;
import com.pytap.project.dto.WebLogDTO;
import com.pytap.project.service.ErrorLogService;
import com.pytap.project.service.WebLogService;
import com.pytap.project.utils.JsonUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/4/14 0:06
 */
@RestController
@RequestMapping("/admin/WebLog")
@PreAuthorize("hasRole('R_ADMIN')")
public class LogController {

	@Resource
	private WebLogService webLogService;

	@Resource
	private ErrorLogService errorLogService;

	@RequestMapping(value = "listAllWebLogs", method = RequestMethod.GET)
	public JSONObject listAllWebLogs() {
		return JsonUtil.backObject(200, webLogService.listWebLogs());
	}

	@Log(value = "获取WEB日志日志")
	@RequestMapping(value = "getWebLog", method = RequestMethod.GET)
	public JSONObject getWebLogs(@RequestBody WebLogDTO webLogDTO) {
		return JsonUtil.backObject(200, webLogService.getWebLogs(webLogDTO));
	}

	@Log(value = "删除所有WEB日志")
	@RequestMapping(value = "deleteAllWebLogs", method = RequestMethod.GET)
	public JSONObject deleteAllWebLogs() {
		int result = webLogService.deleteAllWebLogs();
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}

	@RequestMapping(value = "listAllErrorLogs", method = RequestMethod.GET)
	public JSONObject listAllErrorLogs() {
		return JsonUtil.backObject(200, errorLogService.listErrorLogs());
	}

	@Log(value = "获取指定异常日志")
	@RequestMapping(value = "getErrorLog", method = RequestMethod.GET)
	public JSONObject getErrorLogs(@RequestBody ErrorLogDTO errorLogDTO) {
		return JsonUtil.backObject(200, errorLogService.getErrorLogs(errorLogDTO));
	}

	@Log(value = "删除所有异常日志")
	@RequestMapping(value = "deleteAllErrorLogs", method = RequestMethod.GET)
	public JSONObject deleteAllErrorLogs() {
		int result = errorLogService.deleteAllErrorLogs();
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}
}
