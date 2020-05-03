package com.pytap.project.service;

import com.pytap.project.entity.AdditionalPermission;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 14:33
 */
public interface AdditionalPermissionService {

	/**
	 * 插入额外权限
	 * @param additionalPermission 额外权限实体
	 * @return Integer
	 * */
	Integer insertAdditionalPermission(AdditionalPermission additionalPermission);

	/**
	 * 删除额外权限
	 * @param id 额外权限id
	 * @return Integer
	 * */
	Integer deleteByAdditionalPermissionId(Long id);

	/**
	 * 更新额外权限
	 * @param additionalPermission 额外权限实体
	 * @return Integer
	 * */
	Integer updateByAdditionalPermissionId(AdditionalPermission additionalPermission);

	/**
	 * 主键获得额外权限
	 * @param queryParam 查询参数
	 * @return AdditionalPermission 额外权限实体
	 * */
	AdditionalPermission getAdditionalPermission(AdditionalPermission queryParam);

	/**
	 * 获取所有额外权限
	 *
	 * @return List<AdditionalPermission>
	 * */
	List<AdditionalPermission> listAllAdditionalPermissions();

}
