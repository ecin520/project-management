package com.pytap.project.web.service;

import com.pytap.project.entity.Project;
import com.pytap.project.web.model.dto.UserDTO;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/1 1:22
 */
public interface ProjectOperationService {

	/**
	 * 通过项目id获取该项目的管理者
	 * @param id 项目id
	 * @return List<UserDTO>
	 * */
	List<UserDTO> listManagersByProjectId(Long id);

	/**
	 * 通过项目id获取该项目的开发者
	 * @param id 项目id
	 * @return List<UserDTO>
	 * */
	List<UserDTO> listDevelopersByProjectId(Long id);

	/**
	 * 通过用户id获取该用户管理的所有项目
	 * @param id 管理者id
	 * @return List<Project>
	 * */
	List<Project> listProjectsByManagerId(Long id);

	/**
	 * 通过用户id获取该用户开发的所有项目
	 * @param id 开发者id
	 * @return List<Project>
	 * */
	List<Project> listProjectsByDeveloperId(Long id);

}
