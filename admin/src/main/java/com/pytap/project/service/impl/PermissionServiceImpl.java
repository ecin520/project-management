package com.pytap.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.pytap.project.dao.PermissionMapper;
import com.pytap.project.entity.Permission;
import com.pytap.project.entity.PermissionExample;
import com.pytap.project.service.PermissionService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 14:38
 */
@Service
@CacheConfig(cacheNames = "permission")
public class PermissionServiceImpl implements PermissionService {

	@Resource
	private PermissionMapper permissionMapper;

	@Override
	@Cacheable(key = "'count-permission'")
	public Integer countPermission() {
		return permissionMapper.countByExample(null);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer insertPermission(Permission permission) {
		permission.setCreateTime(new Date());
		return permissionMapper.insert(permission);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer deleteByPermissionId(Long id) {
		return permissionMapper.deleteByPrimaryKey(id);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer updateByPermissionId(Permission permission) {
		return permissionMapper.updateByPrimaryKey(permission);
	}

	@Override
	@Cacheable(key = "'get-permission' + queryParam.toString()")
	public Permission getPermission(Permission queryParam) {
		PermissionExample permissionExample = new PermissionExample();
		PermissionExample.Criteria criteria = permissionExample.createCriteria();
		if (null != queryParam.getId()) {
			return permissionMapper.selectByPrimaryKey(queryParam.getId());
		} else if (null != queryParam.getName()){
			criteria.andNameEqualTo(queryParam.getName());
			return permissionMapper.selectByExample(permissionExample).get(0);
		}
		return null;
	}

	@Override
	@Cacheable(key = "'list-all-permission' + #pageNum + '-' + #pageSize")
	public List<Permission> listAllPermissions(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return permissionMapper.selectByExample(null);
	}

}
