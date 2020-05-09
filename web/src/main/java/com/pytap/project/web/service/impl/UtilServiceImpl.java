package com.pytap.project.web.service.impl;

import com.pytap.project.dao.AdditionalPermissionMapper;
import com.pytap.project.dao.UserAdditionalPermissionMapper;
import com.pytap.project.entity.AdditionalPermission;
import com.pytap.project.entity.AdditionalPermissionExample;
import com.pytap.project.entity.UserAdditionalPermissionExample;
import com.pytap.project.web.service.UtilService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/6 23:16
 */
@Service
public class UtilServiceImpl implements UtilService {

	@Resource
	private AdditionalPermissionMapper additionalPermissionMapper;

	@Resource
	private UserAdditionalPermissionMapper userAdditionalPermissionMapper;

	@Override
	public AdditionalPermission getByAdditionalPermissionName(String name) {
		AdditionalPermissionExample additionalPermissionExample = new AdditionalPermissionExample();
		additionalPermissionExample.createCriteria().andNameEqualTo(name);

		List<AdditionalPermission> list = additionalPermissionMapper.selectByExample(additionalPermissionExample);

		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Integer deleteUserAdditionalPermission(Long userId, Long additionalPermissionId) {
		UserAdditionalPermissionExample userAdditionalPermissionExample = new UserAdditionalPermissionExample();
		UserAdditionalPermissionExample.Criteria criteria = userAdditionalPermissionExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andAdditionalPermissionIdEqualTo(additionalPermissionId);
		return userAdditionalPermissionMapper.deleteByExample(userAdditionalPermissionExample);
	}
}
