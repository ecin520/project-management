package com.pytap.project.service.impl;

import com.pytap.project.dao.RolePermissionMapper;
import com.pytap.project.entity.RolePermission;
import com.pytap.project.entity.RolePermissionExample;
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
	private RolePermissionMapper rolePermissionMapper;

	@Override
	@CacheEvict(allEntries = true)
	public Integer insertRolePermission(RolePermission rolePermission) {
		rolePermission.setCreateTime(new Date());
		return rolePermissionMapper.insert(rolePermission);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer deleteByRoleAndPermissionId(Long roleId, Long permissionId) {
		RolePermissionExample rolePermissionExample = new RolePermissionExample();
		RolePermissionExample.Criteria criteria = rolePermissionExample.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		criteria.andPermissionIdEqualTo(permissionId);
		return rolePermissionMapper.deleteByExample(rolePermissionExample);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer deleteByRolePermissionId(Long id) {
		return rolePermissionMapper.deleteByPrimaryKey(id);
	}


	@Override
	@CacheEvict(allEntries = true)
	public Integer updateByRolePermissionId(RolePermission rolePermission) {
		return rolePermissionMapper.updateByPrimaryKey(rolePermission);
	}

	@Override
	public RolePermission getByRolePermissionId(Long id) {
		return rolePermissionMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<RolePermission> listAllRolePermissions() {
		return rolePermissionMapper.selectByExample(null);
	}
}
