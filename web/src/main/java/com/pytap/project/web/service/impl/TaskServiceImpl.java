package com.pytap.project.web.service.impl;

import com.pytap.project.dao.TaskMapper;
import com.pytap.project.entity.Task;
import com.pytap.project.entity.TaskExample;
import com.pytap.project.web.service.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/3 0:31
 */
@Service
public class TaskServiceImpl implements TaskService {
	
	@Resource
	private TaskMapper taskMapper;

	@Override
	public Integer insertTask(Task task) {
		task.setCreateTime(new Date());
		return taskMapper.insert(task);
	}

	@Override
	public Integer updateTaskByManager(Task task) {
		return taskMapper.updateByPrimaryKeyWithBLOBs(task);
	}

	@Override
	public Integer updateTaskByDeveloper(Task task) {
		return taskMapper.updateByPrimaryKeyWithBLOBs(task);
	}

	@Override
	public Integer deleteTask(Long id) {
		return taskMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Task getByTaskId(Long id) {
		return taskMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Task> listAllTasksByProjectId(Long id) {
		TaskExample taskExample = new TaskExample();
		TaskExample.Criteria criteria = taskExample.createCriteria();
		criteria.andProjectIdEqualTo(id);
		return taskMapper.selectByExampleWithBLOBs(taskExample);
	}

	@Override
	public List<Task> listAllTasksByProjectIdAndExecutor(Long projectId, Long executor) {
		TaskExample taskExample = new TaskExample();
		TaskExample.Criteria criteria = taskExample.createCriteria();
		criteria.andProjectIdEqualTo(projectId);
		criteria.andExecutorEqualTo(executor);
		return taskMapper.selectByExampleWithBLOBs(taskExample);
	}

	@Override
	public List<Task> listAllTasksByUserId(Long id) {
		TaskExample taskExample = new TaskExample();
		TaskExample.Criteria criteria = taskExample.createCriteria();
		criteria.andExecutorEqualTo(id);
		return taskMapper.selectByExampleWithBLOBs(taskExample);
	}


}
