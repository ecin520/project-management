package com.pytap.project.web.service;

import com.pytap.project.entity.ProjectType;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/5 20:23
 */
public interface ProjectTypeService {

	/**
	 * 插入项目类型
	 * @param projectType 项目类型
	 * @return Integer 返回结果
	 * */
	Integer insertProjectType(ProjectType projectType);

	/**
	 * 主键删除
	 * @param id 主键
	 * @return Integer 返回结果
	 * */
	Integer deleteByProjectTypeId(Long id);

	/**
	 * 名称删除
	 * @param name 名称
	 * @return Integer 返回结果
	 * */
	Integer deleteByProjectTypeName(String name);

	/**
	 * 更新类型
	 * @param projectType 项目类型
	 * @return Integer 返回结果
	 * */
	Integer updateProjectType(ProjectType projectType);

	/**
	 * 获取所有类型
	 * @return List<ProjectType> 结果集
	 * */
	List<ProjectType> listProjectTypes();

}
