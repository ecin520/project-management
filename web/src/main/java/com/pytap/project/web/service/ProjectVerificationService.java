package com.pytap.project.web.service;

import com.pytap.project.entity.ProjectVerification;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/6 16:38
 */
public interface ProjectVerificationService {

	/**
	 * 插入项目验证
	 * @param projectVerification 验证实体
	 * @return Integer 返回结果
	 * */
	Integer insertProjectVerification(ProjectVerification projectVerification);

	/**
	 * 主键删除
	 * @param id 主键
	 * @return Integer 返回结果
	 * */
	Integer deleteByProjectVerificationId(Long id);

	/**
	 * 接收者id删除所有记录
	 * @param id receiver
	 * @return Integer 返回结果
	 * */
	Integer deleteByProjectVerificationReceiveId(Long id);

	/**
	 * 项目id删除所有记录
	 * @param id 项目id
	 * @return Integer 返回结果
	 * */
	Integer deleteByProjectVerificationProjectId(Long id);

	/**
	 * 更新验证
	 * @param projectVerification 验证实体
	 * @return Integer 返回结果
	 * */
	Integer updateProjectVerification(ProjectVerification projectVerification);

	/**
	 * 主键获取验证
	 * @param id 主键
	 * @return ProjectVerification
	 * */
	ProjectVerification getProjectVerification(Long id);

	/**
	 * 通过接收者id获取所有验证
	 * @param id 接收者id
	 * @return List<ProjectVerification>
	 * */
	List<ProjectVerification> listProjectVerificationsByReceiveId(Long id);

	/**
	 * 通过项目id获取所有验证
	 * @param id 项目id
	 * @return List<ProjectVerification>
	 * */
	List<ProjectVerification> listProjectVerificationsByProjectId(Long id);
}
