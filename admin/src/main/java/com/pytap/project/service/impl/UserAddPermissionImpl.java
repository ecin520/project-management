package com.pytap.project.service.impl;

import com.pytap.project.dao.UserAddPermissionDao;
import com.pytap.project.entity.UserAddPermission;
import com.pytap.project.service.UserAddPermissionService;
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
public class UserAddPermissionImpl implements UserAddPermissionService {

	@Resource
	private UserAddPermissionDao userAddPermissionDao;

	@Override
	@CacheEvict(allEntries = true)
	public Integer insertUserAddPermission(UserAddPermission userAddPermission) {
		userAddPermission.setCreateTime(new Date());
		return userAddPermissionDao.insertUserAddPermission(userAddPermission);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer deleteByUserAddPermission(UserAddPermission userAddPermission) {
		return userAddPermissionDao.deleteByUserAddPermission(userAddPermission);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer updateByUserAddPermissionId(UserAddPermission userAddPermission) {
		return userAddPermissionDao.updateByUserAddPermissionId(userAddPermission);
	}

	@Override
	public UserAddPermission getByUserAddPermissionId(Long id) {
		return userAddPermissionDao.getByUserAddPermissionId(id);
	}

	@Override
	public List<UserAddPermission> listAllUserAddPermissions() {
		return userAddPermissionDao.listAllUserAddPermissions();
	}

}
