package com.pytap.project.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.entity.TaskType;
import com.pytap.project.utils.JsonUtil;
import com.pytap.project.web.service.TaskTypeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/5/6 16:32
 */
@RestController
@PreAuthorize("hasRole('R_USER')")
@RequestMapping("/web/task-type")
public class TaskTypeController {
	@Resource
	private TaskTypeService taskTypeService;

	@Log(value = "添加任务类型")
	@PreAuthorize("hasAuthority('R_ADMIN')")
	@RequestMapping(value = "/insertTaskType", method = RequestMethod.POST)
	public JSONObject insertTaskType(@RequestBody TaskType taskType) {
		return taskTypeService.insertTaskType(taskType) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "主键删除任务类型")
	@PreAuthorize("hasAuthority('R_ADMIN')")
	@RequestMapping(value = "/deleteByTaskTypeId", method = RequestMethod.GET)
	public JSONObject deleteByTaskTypeId(Long id) {
		return taskTypeService.deleteByTaskTypeId(id) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "通过名称删除项目类型")
	@PreAuthorize("hasAuthority('R_ADMIN')")
	@RequestMapping(value = "/deleteByTaskTypeName", method = RequestMethod.GET)
	public JSONObject deleteByTaskTypeName(String name) {
		return taskTypeService.deleteByTaskTypeName(name) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "更新项目类型")
	@PreAuthorize("hasAuthority('R_ADMIN')")
	@RequestMapping(value = "/updateTaskType", method = RequestMethod.POST)
	public JSONObject updateTaskType(@RequestBody TaskType taskType) {
		return taskTypeService.updateTaskType(taskType) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "获取所有项目类型")
	@RequestMapping(value = "/listTaskTypes", method = RequestMethod.GET)
	public JSONObject listTaskTypes() {
		return JsonUtil.backObject(200, taskTypeService.listTaskTypes());
	}
}
