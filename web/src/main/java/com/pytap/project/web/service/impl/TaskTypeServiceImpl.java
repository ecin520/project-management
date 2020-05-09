package com.pytap.project.web.service.impl;

import com.pytap.project.dao.TaskTypeMapper;
import com.pytap.project.entity.TaskType;
import com.pytap.project.entity.TaskTypeExample;
import com.pytap.project.web.service.TaskTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/6 16:26
 */
@Service
public class TaskTypeServiceImpl implements TaskTypeService {

	@Resource
	private TaskTypeMapper taskTypeMapper;

	@Override
	public Integer insertTaskType(TaskType taskType) {
		taskType.setCreateTime(new Date());
		return taskTypeMapper.insert(taskType);
	}

	@Override
	public Integer deleteByTaskTypeId(Long id) {
		return taskTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer deleteByTaskTypeName(String name) {
		TaskTypeExample taskTypeExample = new TaskTypeExample();
		TaskTypeExample.Criteria criteria = taskTypeExample.createCriteria();
		criteria.andNameEqualTo(name);
		return taskTypeMapper.deleteByExample(taskTypeExample);
	}

	@Override
	public Integer updateTaskType(TaskType taskType) {
		return taskTypeMapper.updateByPrimaryKey(taskType);
	}

	@Override
	public List<TaskType> listTaskTypes() {
		return taskTypeMapper.selectByExample(null);
	}
}
