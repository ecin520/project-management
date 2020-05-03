package com.pytap.project.web.service;

import com.pytap.project.entity.Task;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/4/30 13:53
 */
public interface TaskService {

	/**
	 * 插入任务
	 * @param task 任务实体
	 * @return Integer 返回结果
	 * */
	Integer insertTask(Task task);

	/**
	 * 管理员更新任务
	 * @param task 任务实体
	 * @return Integer 返回结果
	 * */
	Integer updateTaskByManager(Task task);

	/**
	 * 开发者更新任务
	 * @param task 任务实体
	 * @return Integer 返回结果
	 * */
	Integer updateTaskByDeveloper(Task task);

	/**
	 * 删除任务
	 * @param id 主键
	 * @return Integer 返回结果
	 * */
	Integer deleteTask(Long id);

	/**
	 * 主键获取任务
	 * @param id 主键
	 * @return Task 任务实体
	 * */
	Task getByTaskId(Long id);

	/**
	 * 通过项目id获取所有任务
	 * @param id 项目id
	 * @return List<Task> 任务集合
	 * */
	List<Task> listAllTasksByProjectId(Long id);


	/**
	 * 通过任务接收者和项目id获取项目的所有任务
	 * @param projectId 项目id
	 * @param executor 任务执行人
	 * @return List<Task> 任务集合
	 * */
	List<Task> listAllTasksByProjectIdAndExecutor(Long projectId, Long executor);

	/**
	 * 通过用户id获取用户所有任务
	 * @param id 用户id
	 * @return List<Task> 任务集合
	 * */
	List<Task> listAllTasksByUserId(Long id);

}
