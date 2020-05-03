package com.pytap.project.service;

import com.pytap.project.entity.UserAdditionalPermission;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 14:34
 */
public interface UserAdditionalPermissionService {

	/**
	 * 插入用户额外权限关系
	 * @param userAdditionalPermission 用户额外权限关系实体
	 * @return Integer
	 * */
	Integer insertUserAdditionalPermission(UserAdditionalPermission userAdditionalPermission);

	/**
	 * 删除用户额外权限关系
	 * @param userId 用户id
	 * @param additionalPermissionId 附加权限id
	 * @return Integer
	 * */
	Integer deleteByUserAndAdditionalPermissionId(Long userId, Long additionalPermissionId);

	/**
	 * 删除用户额外权限关系
	 * @param id 主键
	 * @return Integer
	 * */
	Integer deleteByUserAdditionalPermissionId(Long id);

	/**
	 * 更新用户附加权限关系
	 * @param userAdditionalPermission 用户附加权限实体
	 * @return Integer
	 * */
	Integer updateByUserAdditionalPermissionId(UserAdditionalPermission userAdditionalPermission);

	/**
	 * 主键获得用户额外权限关系
	 * @param id 主键
	 * @return UserAdditionalPermission
	 * */
	UserAdditionalPermission getByUserAdditionalPermissionId(Long id);

	/**
	 * 获取所有用户额外权限关系
	 * @return List<UserAdditionalPermission>
	 * */
	List<UserAdditionalPermission> listAllUserAdditionalPermissions();

}
