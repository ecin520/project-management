package com.pytap.project.web.service;

import com.pytap.project.entity.AdditionalPermission;
import com.pytap.project.entity.Permission;
import com.pytap.project.entity.Role;
import com.pytap.project.web.model.dto.AuthDTO;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/4/27 21:19
 */
public interface WebUserService {

	/**
	 * 根据用户id获取权限
	 * @param id 用户id
	 * @return List<PermissionDO>
	 * */
	List<Permission> listUserPermissions(Long id);

	/**
	 * 根据用户id获取额外权限
	 * @param id 用户id
	 * @return List<AdditionalPermission>
	 * */
	List<AdditionalPermission> listUserAdditionalPermissions(Long id);

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
