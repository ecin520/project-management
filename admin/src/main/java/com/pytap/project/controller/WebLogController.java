package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.model.WebLogDO;
import com.pytap.project.service.WebLogService;
import com.pytap.project.utils.JsonUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/4/14 0:06
 */
@RestController
@RequestMapping("/admin/WebLog")
@PreAuthorize("hasRole('R_ADMIN')")
public class WebLogController {

	@Resource
	private WebLogService webLogService;

	@RequestMapping(value = "listAllWebLogs", method = RequestMethod.GET)
	public JSONObject listAllWebLogs(@RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
	                                 @RequestParam(value = "pageSize", defaultValue = "0") Integer pageSize) {
		return JsonUtil.backObject(200, webLogService.listWebLogs(pageNum, pageSize));
	}

	@RequestMapping(value = "getWebLog", method = RequestMethod.GET)
	public JSONObject getWebLog(@RequestBody WebLogDO webLogDO) {
		return JsonUtil.backObject(200, webLogService.getWebLog(webLogDO));
	}

	@RequestMapping(value = "deleteAllWebLogs", method = RequestMethod.GET)
	public JSONObject deleteAllWebLogs() {
		int result = webLogService.deleteAllWebLogs();
		if (result == 1) {
			return JsonUtil.success();
		}
		return JsonUtil.fail();
	}
}
