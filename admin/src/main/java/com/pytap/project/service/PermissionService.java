package com.pytap.project.service;

import com.pytap.project.entity.Permission;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 14:33
 */
public interface PermissionService {

	/**
	 * 插入权限
	 * @param permission 权限实体
	 * @return Integer
	 * */
	Integer insertPermission(Permission permission);

	/**
	 * 删除权限
	 * @param id 权限id
	 * @return Integer
	 * */
	Integer deleteByPermissionId(Long id);

	/**
	 * 更新权限
	 * @param permission 权限实体
	 * @return Integer
	 * */
	Integer updateByPermissionId(Permission permission);

	/**
	 * 主键获得权限
	 * @param id 权限id
	 * @return Permission 权限实体
	 * */
	Permission getByPermissionId(Long id);

	/**
	 * 获取所有权限
	 * @return List<Permission>
	 * */
	List<Permission> listAllPermissions();

}
