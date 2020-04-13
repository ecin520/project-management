package com.pytap.project.service.impl;

import com.pytap.project.dao.AddPermissionDao;
import com.pytap.project.entity.AddPermission;
import com.pytap.project.service.AddPermissionService;
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
@CacheConfig(cacheNames = "add-permission")
public class AddPermissionServiceImpl implements AddPermissionService {

	@Resource
	private AddPermissionDao addPermissionDao;

	@Override
	@CacheEvict(allEntries = true)
	public Integer insertAddPermission(AddPermission addPermission) {
		addPermission.setCreateTime(new Date());
		return addPermissionDao.insertAddPermission(addPermission);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer deleteByAddPermissionId(Long id) {
		return addPermissionDao.deleteByAddPermissionId(id);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer updateByAddPermissionId(AddPermission addPermission) {
		return addPermissionDao.updateByAddPermissionId(addPermission);
	}

	@Override
	@Cacheable(key = "'get-add-permission' + queryParam.toString()")
	public AddPermission getAddPermission(AddPermission queryParam) {
		return addPermissionDao.getAddPermission(queryParam);
	}

	@Override
	@Cacheable(key = "'list-all-add-permission'")
	public List<AddPermission> listAllAddPermissions() {
		return addPermissionDao.listAllAddPermissions();
	}
}
