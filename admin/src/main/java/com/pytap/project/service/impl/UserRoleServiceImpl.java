package com.pytap.project.service.impl;

import com.pytap.project.dao.UserRoleMapper;
import com.pytap.project.entity.UserRole;
import com.pytap.project.entity.UserRoleExample;
import com.pytap.project.service.UserRoleService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
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
	private UserRoleMapper userRoleMapper;

	@Override
	@CacheEvict(allEntries = true)
	public Integer insertUserRole(UserRole userRole) {
		userRole.setCreateTime(new Date());
		return userRoleMapper.insert(userRole);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer deleteByUserAndRoleId(Long userId, Long roleId) {
		UserRoleExample userRoleExample = new UserRoleExample();
		UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andRoleIdEqualTo(roleId);
		return userRoleMapper.deleteByExample(userRoleExample);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer deleteByUserRoleId(Long id) {
		return userRoleMapper.deleteByPrimaryKey(id);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer updateByUserRole(UserRole userRole) {
		return userRoleMapper.updateByPrimaryKey(userRole);
	}

	@Override
	public UserRole getByUserRoleId(Long id) {
		return userRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserRole> listAllUserRoles() {
		return userRoleMapper.selectByExample(null);
	}
}
