package com.pytap.project.web.service;

import com.pytap.project.entity.ProjectManager;

/**
 * @author Ecin520
 * @date 2020/4/30 13:51
 */
public interface ProjectManagerService {

	/**
	 * 添加项目管理员
	 * @param projectManager 项目与管理员关系
	 * @return Integer 返回结果
	 * */
	Integer insertProjectManager(ProjectManager projectManager);

	/**
	 * 移除项目管理员
	 * @param id 主键
	 * @return Integer 返回结果
	 * */
	Integer deleteByProjectManagerId(Long id);

	/**
	 * 移除项目管理员
	 * @param projectId 项目id
	 * @param managerId 管理人员id
	 * @return Integer 返回结果
	 * */
	Integer deleteByProjectAndManagerId(Long projectId, Long managerId);

}
