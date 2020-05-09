package com.pytap.project.web.service;


import com.pytap.project.entity.TaskType;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/6 16:21
 */
public interface TaskTypeService {
	/**
	 * 插入项目类型
	 * @param taskType 任务类型
	 * @return Integer 返回结果
	 * */
	Integer insertTaskType(TaskType taskType);

	/**
	 * 主键删除
	 * @param id 主键
	 * @return Integer 返回结果
	 * */
	Integer deleteByTaskTypeId(Long id);

	/**
	 * 名称删除
	 * @param name 名称
	 * @return Integer 返回结果
	 * */
	Integer deleteByTaskTypeName(String name);

	/**
	 * 更新类型
	 * @param taskType 任务类型
	 * @return Integer 返回结果
	 * */
	Integer updateTaskType(TaskType taskType);

	/**
	 * 获取所有类型
	 * @return List<TaskType> 结果集
	 * */
	List<TaskType> listTaskTypes();
}
