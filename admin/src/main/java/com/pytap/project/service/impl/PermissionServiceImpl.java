package com.pytap.project.service.impl;

import com.pytap.project.dao.PermissionDao;
import com.pytap.project.entity.Permission;
import com.pytap.project.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 14:38
 */
@Service
public class PermissionServiceImpl implements PermissionService {

	@Resource
	private PermissionDao permissionDao;

	@Override
	public Integer insertPermission(Permission permission) {
		permission.setCreateTime(new Date());
		return permissionDao.insertPermission(permission);
	}

	@Override
	public Integer deleteByPermissionId(Long id) {
		return permissionDao.deleteByPermissionId(id);
	}

	@Override
	public Integer updateByPermissionId(Permission permission) {
		return permissionDao.updateByPermissionId(permission);
	}

	@Override
	public Permission getByPermissionId(Long id) {
		return permissionDao.getByPermissionId(id);
	}

	@Override
	public List<Permission> listAllPermissions() {
		return permissionDao.listAllPermissions();
	}
}
