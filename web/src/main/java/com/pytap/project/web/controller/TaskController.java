package com.pytap.project.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.entity.Task;
import com.pytap.project.utils.JsonUtil;
import com.pytap.project.web.service.TaskService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/5/3 15:25
 */
@RestController
@PreAuthorize("hasRole('R_USER')")
@RequestMapping("/web/task")
public class TaskController {

	@Resource
	private TaskService taskService;

	@Log(value = "添加任务")
	@PreAuthorize("hasAuthority('AP_PROJECT_MANAGER_' + #task.projectId)")
	@RequestMapping(value = "/insertTask", method = RequestMethod.POST)
	public JSONObject insertTask(@RequestBody Task task) {
		return taskService.insertTask(task) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "管理员更新任务")
	@PreAuthorize("hasAuthority('AP_PROJECT_MANAGER_' + #task.projectId)")
	@RequestMapping(value = "/updateTaskByManager", method = RequestMethod.POST)
	public JSONObject updateTaskByManager(@RequestBody Task task) {
		return taskService.updateTaskByManager(task) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "开发者更新任务")
	@PreAuthorize("hasAuthority('AP_PROJECT_DEVELOPER_' + #task.projectId)")
	@RequestMapping(value = "/updateTaskByDeveloper", method = RequestMethod.POST)
	public JSONObject updateTaskByDeveloper(@RequestBody Task task) {
		return taskService.updateTaskByDeveloper(task) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "删除任务")
	@PreAuthorize("hasAuthority('AP_PROJECT_MANAGER_' + #projectId)")
	@RequestMapping(value = "/deleteTask", method = RequestMethod.GET)
	public JSONObject deleteTask(Long taskId, Long projectId) {
		return taskService.deleteTask(taskId) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "主键获取单个任务")
	@PreAuthorize("hasAnyAuthority({'AP_PROJECT_MANAGER_' + #projectId, 'AP_PROJECT_DEVELOPER_' + #projectId})")
	@RequestMapping(value = "/getByTaskId", method = RequestMethod.GET)
	public JSONObject getByTaskId(Long taskId, Long projectId) {
		return JsonUtil.backObject(200, taskService.getByTaskId(taskId));
	}

	@Log(value = "通过项目id获取所有任务")
	@PreAuthorize("hasAuthority('AP_PROJECT_MANAGER_' + #id)")
	@RequestMapping(value = "/listAllTasksByProjectId", method = RequestMethod.GET)
	public JSONObject listAllTasksByProjectId(Long id) {
		return JsonUtil.backObject(200, taskService.listAllTasksByProjectId(id));
	}

	@Log(value = "通过项目id和任务执行者列出所有任务")
	@PreAuthorize("hasAuthority('AP_PROJECT_DEVELOPER_' + #projectId)")
	@RequestMapping(value = "/listAllTasksByProjectIdAndExecutor", method = RequestMethod.GET)
	public JSONObject listAllTasksByProjectIdAndExecutor(Long projectId, Long executor) {
		return JsonUtil.backObject(200, taskService.listAllTasksByProjectIdAndExecutor(projectId, executor));
	}

	@Log(value = "通过项目id和任务执行者列出所有任务")
	@PreAuthorize("hasAuthority('AP_USER_' + #id)")
	@RequestMapping(value = "/listAllTasksByUserId", method = RequestMethod.GET)
	public JSONObject listAllTasksByUserId(Long id) {
		return JsonUtil.backObject(200, taskService.listAllTasksByUserId(id));
	}

}
