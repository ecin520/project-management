package com.pytap.project.service.impl;

import com.pytap.project.dao.UserRoleDao;
import com.pytap.project.entity.UserRole;
import com.pytap.project.service.UserRoleService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 14:39
 */
@Service
@CacheConfig(cacheNames = {"admin"})
public class UserRoleServiceImpl implements UserRoleService {

	@Resource
	private UserRoleDao userRoleDao;

	@Override
	@CacheEvict(allEntries = true)
	public Integer insertUserRole(UserRole userRole) {
		userRole.setCreateTime(new Date());
		return userRoleDao.insertUserRole(userRole);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer deleteByUserRole(UserRole userRole) {
		return userRoleDao.deleteByUserRole(userRole);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer updateByUserRole(UserRole userRole) {
		return userRoleDao.updateByUserRole(userRole);
	}

	@Override
	public UserRole getByUserRoleId(Long id) {
		return userRoleDao.getByUserRoleId(id);
	}

	@Override
	public List<UserRole> listAllUserRoles() {
		return userRoleDao.listAllUserRoles();
	}
}
