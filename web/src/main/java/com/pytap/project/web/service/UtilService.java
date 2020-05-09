package com.pytap.project.web.service;

import com.pytap.project.entity.AdditionalPermission;

/**
 * @author Ecin520
 * @date 2020/5/6 23:16
 */
public interface UtilService {
	/**
	 * 通过名称获取附加权限
	 * @param name 附加权限名称
	 * @return AdditionalPermission 附加权限
	 * */
	AdditionalPermission getByAdditionalPermissionName(String name);

	Integer deleteUserAdditionalPermission(Long userId, Long additionalPermissionId);
}
