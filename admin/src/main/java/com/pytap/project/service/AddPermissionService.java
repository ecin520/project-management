package com.pytap.project.service;

import com.pytap.project.entity.AddPermission;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 14:33
 */
public interface AddPermissionService {

	/**
	 * 插入额外权限
	 * @param addPermission 额外权限实体
	 * @return Integer
	 * */
	Integer insertAddPermission(AddPermission addPermission);

	/**
	 * 删除额外权限
	 * @param id 额外权限id
	 * @return Integer
	 * */
	Integer deleteByAddPermissionId(Long id);

	/**
	 * 更新额外权限
	 * @param addPermission 额外权限实体
	 * @return Integer
	 * */
	Integer updateByAddPermissionId(AddPermission addPermission);

	/**
	 * 主键获得额外权限
	 * @param id 额外权限id
	 * @return AddPermission 额外权限实体
	 * */
	AddPermission getByAddPermissionId(Long id);

	/**
	 * 获取所有额外权限
	 * @return List<AddPermission>
	 * */
	List<AddPermission> listAllAddPermissions();

}
