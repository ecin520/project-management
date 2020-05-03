package com.pytap.project.service.impl;

import com.pytap.project.dao.UserAdditionalPermissionMapper;
import com.pytap.project.entity.UserAdditionalPermission;
import com.pytap.project.entity.UserAdditionalPermissionExample;
import com.pytap.project.service.UserAdditionalPermissionService;
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
public class UserAdditionalPermissionImpl implements UserAdditionalPermissionService {

	@Resource
	private UserAdditionalPermissionMapper userAdditionalPermissionMapper;

	@Override
	@CacheEvict(allEntries = true)
	public Integer insertUserAdditionalPermission(UserAdditionalPermission userAdditionalPermission) {
		userAdditionalPermission.setCreateTime(new Date());
		return userAdditionalPermissionMapper.insert(userAdditionalPermission);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer deleteByUserAndAdditionalPermissionId(Long userId, Long additionalPermissionId) {
		UserAdditionalPermissionExample userAdditionalPermissionExample = new UserAdditionalPermissionExample();
		UserAdditionalPermissionExample.Criteria criteria = userAdditionalPermissionExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andAdditionalPermissionIdEqualTo(additionalPermissionId);
		return userAdditionalPermissionMapper.deleteByExample(userAdditionalPermissionExample);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer deleteByUserAdditionalPermissionId(Long id) {
		return userAdditionalPermissionMapper.deleteByPrimaryKey(id);
	}


	@Override
	@CacheEvict(allEntries = true)
	public Integer updateByUserAdditionalPermissionId(UserAdditionalPermission userAdditionalPermission) {
		return userAdditionalPermissionMapper.updateByPrimaryKey(userAdditionalPermission);
	}

	@Override
	public UserAdditionalPermission getByUserAdditionalPermissionId(Long id) {
		return userAdditionalPermissionMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserAdditionalPermission> listAllUserAdditionalPermissions() {
		return userAdditionalPermissionMapper.selectByExample(null);
	}

}
