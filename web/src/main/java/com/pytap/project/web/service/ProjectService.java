package com.pytap.project.web.service;

import com.pytap.project.entity.Project;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/4/29 12:17
 */
public interface ProjectService {

	/**
	 * 列出所有项目
	 * @param id 用户id
	 * @return List<Project>
	 * */
	List<Project> listUserProjects(Long id);

	/**
	 * 插入项目
	 * @param project 项目实体
	 * @return Integer 返回结果
	 * */
	Integer insertProject(Project project);

	/**
	 * 删除制定项目
	 * @param id 项目id
	 * @return List<Project>
	 * */
	Integer deleteProjectById(Long id);

	/**
	 * 主键更新项目
	 * @param project 项目实体
	 * @return Integer 返回结果
	 * */
	Integer updateProject(Project project);

	/**
	 * 主键获取指定项目
	 * @param id 项目主键
	 * @return Project 项目实体
	 * */
	Project getUserProject(Long id);

}
