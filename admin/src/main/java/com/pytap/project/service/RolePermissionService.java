package com.pytap.project.service;

import com.pytap.project.entity.RolePermission;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 14:34
 */
public interface RolePermissionService {

	/**
	 * 插入角色权限关系
	 * @param rolePermission 角色权限关系实体
	 * @return Integer
	 * */
	Integer insertRolePermission(RolePermission rolePermission);

	/**
	 * 删除角色权限关系
	 * @param rolePermission 角色权限关系
	 * @return Integer
	 * */
	Integer deleteByRolePermission(RolePermission rolePermission);

	/**
	 * 更新角色权限关系
	 * @param rolePermission 角色权限关系实体
	 * @return Integer
	 * */
	Integer updateByRolePermissionId(RolePermission rolePermission);

	/**
	 * 主键获得角色权限关系
	 * @param id 主键
	 * @return rolePermission
	 * */
	RolePermission getByRolePermissionId(Long id);

	/**
	 * 获取所有角色权限关系
	 * @return List<RolePermission>
	 * */
	List<RolePermission> listAllRolePermissions();

}
