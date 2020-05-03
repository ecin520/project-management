package com.pytap.project.web.service;

import com.pytap.project.entity.ProjectDeveloper;

/**
 * @author Ecin520
 * @date 2020/4/30 13:52
 */
public interface ProjectDeveloperService {

	/**
	 * 添加项目开发者
	 * @param projectDeveloper 项目与开发者
	 * @return Integer 返回结果
	 * */
	Integer insertProjectDeveloper(ProjectDeveloper projectDeveloper);

	/**
	 * 移除项目开发者
	 * @param id 主键
	 * @return Integer 返回结果
	 * */
	Integer deleteByProjectDeveloperId(Long id);

	/**
	 * 移除项目开发者
	 * @param projectId 项目id
	 * @param developerId 开发者人员id
	 * @return Integer 返回结果
	 * */
	Integer deleteByProjectAndDeveloperId(Long projectId, Long developerId);
}
