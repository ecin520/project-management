package com.pytap.project.service.impl;

import com.pytap.project.dao.RolePermissionDao;
import com.pytap.project.entity.RolePermission;
import com.pytap.project.service.RolePermissionService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 14:40
 */
@Service
@CacheConfig(cacheNames = {"admin"})
public class RolePermissionImpl implements RolePermissionService {

	@Resource
	private RolePermissionDao rolePermissionDao;

	@Override
	@CacheEvict(allEntries = true)
	public Integer insertRolePermission(RolePermission rolePermission) {
		rolePermission.setCreateTime(new Date());
		return rolePermissionDao.insertRolePermission(rolePermission);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer deleteByRolePermission(RolePermission rolePermission) {
		return rolePermissionDao.deleteByRolePermission(rolePermission);
	}

	@Override
	@CacheEvict(allEntries = true)
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
