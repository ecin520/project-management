package com.pytap.project.service;

import com.pytap.project.entity.AddPermission;
import com.pytap.project.entity.Permission;
import com.pytap.project.entity.Role;
import com.pytap.project.model.dto.AuthDTO;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/30 15:09
 */
public interface AdminUserService {

	/**
	 * 登录
	 * @param username 用户名
	 * @param password 密码
	 * @return String
	 * */
	String login(String username, String password);

	/**
	 * 根据用户id获取权限
	 * @param id 用户id
	 * @return List<PermissionDO>
	 * */
	List<Permission> listUserPermissions(Long id);

	/**
	 * 根据用户id获取额外权限
	 * @param id 用户id
	 * @return List<PermissionDO>
	 * */
	List<AddPermission> listUserAddPermissions(Long id);

	/**
	 * 根据用户id获取所有权限
	 * @param id 用户id
	 * @return List<PermissionDO>
	 * */
	List<AuthDTO> listUserAllPermissions(Long id);

	/**
	 * 根据用户id获取角色
	 * @param id 用户id
	 * @return List<RoleDO>
	 * */
	List<Role> listUserRoles(Long id);

	/**
	 * 根据用户id获取所有授权信息
	 * @param id 用户id
	 * @return List<AuthDTO>
	 * */
	List<AuthDTO> listUserAllRolePermissions(Long id);

	/**
	 * 根据角色id获取权限
	 * @param id 角色id
	 * @return List<Permission>
	 * */
	List<Permission> listRolePermissions(Long id);
}
