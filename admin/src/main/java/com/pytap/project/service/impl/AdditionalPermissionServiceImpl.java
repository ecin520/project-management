package com.pytap.project.service.impl;

import com.pytap.project.dao.AdditionalPermissionMapper;
import com.pytap.project.entity.AdditionalPermission;
import com.pytap.project.entity.AdditionalPermissionExample;
import com.pytap.project.service.AdditionalPermissionService;
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
public class AdditionalPermissionServiceImpl implements AdditionalPermissionService {

	@Resource
	private AdditionalPermissionMapper additionalPermissionMapper;

	@Override
	@CacheEvict(allEntries = true)
	public Integer insertAdditionalPermission(AdditionalPermission additionalPermission) {
		additionalPermission.setCreateTime(new Date());
		return additionalPermissionMapper.insert(additionalPermission);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer deleteByAdditionalPermissionId(Long id) {
		return additionalPermissionMapper.deleteByPrimaryKey(id);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer updateByAdditionalPermissionId(AdditionalPermission additionalPermission) {
		return additionalPermissionMapper.updateByPrimaryKey(additionalPermission);
	}

	@Override
	@Cacheable(key = "'get-additional-permission' + queryParam.toString()")
	public AdditionalPermission getAdditionalPermission(AdditionalPermission queryParam) {
		AdditionalPermissionExample additionalPermissionExample = new AdditionalPermissionExample();
		AdditionalPermissionExample.Criteria criteria = additionalPermissionExample.createCriteria();
		if (null != queryParam.getId()) {
			return additionalPermissionMapper.selectByPrimaryKey(queryParam.getId());
		} else if (null != queryParam.getName()){
			criteria.andNameEqualTo(queryParam.getName());
			return additionalPermissionMapper.selectByExample(additionalPermissionExample).get(0);
		}
		return null;
	}

	@Override
	@Cacheable(key = "'list-all-add-permission'")
	public List<AdditionalPermission> listAllAdditionalPermissions() {
		return additionalPermissionMapper.selectByExample(null);
	}
}
