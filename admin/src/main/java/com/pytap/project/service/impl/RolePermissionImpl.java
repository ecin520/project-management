package com.pytap.project.service.impl;

import com.pytap.project.dao.RolePermissionDao;
import com.pytap.project.entity.RolePermission;
import com.pytap.project.service.RolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 14:40
 */
@Service
public class RolePermissionImpl implements RolePermissionService {

	@Resource
	private RolePermissionDao rolePermissionDao;

	@Override
	public Integer insertRolePermission(RolePermission rolePermission) {
		rolePermission.setCreateTime(new Date());
		return rolePermissionDao.insertRolePermission(rolePermission);
	}

	@Override
	public Integer deleteByRolePermissionId(Long id) {
		return rolePermissionDao.deleteByRolePermissionId(id);
	}

	@Override
	public Integer updateByRolePermissionId(RolePermission rolePermission) {
		return rolePermissionDao.updateByRolePermissionId(rolePermission);
	}

	@Override
	public RolePermission getByRolePermissionId(Long id) {
		return rolePermissionDao.getByRolePermissionId(id);
	}

	@Override
	public List<RolePermission> listAllRolePermissions() {
		return rolePermissionDao.listAllRolePermissions();
	}
}
