package com.pytap.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.pytap.project.dao.AddPermissionDao;
import com.pytap.project.entity.AddPermission;
import com.pytap.project.service.AddPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 14:39
 */
@Service
public class AddPermissionServiceImpl implements AddPermissionService {

	@Resource
	private AddPermissionDao addPermissionDao;

	@Override
	public Integer insertAddPermission(AddPermission addPermission) {
		addPermission.setCreateTime(new Date());
		return addPermissionDao.insertAddPermission(addPermission);
	}

	@Override
	public Integer deleteByAddPermissionId(Long id) {
		return addPermissionDao.deleteByAddPermissionId(id);
	}

	@Override
	public Integer updateByAddPermissionId(AddPermission addPermission) {
		return addPermissionDao.updateByAddPermissionId(addPermission);
	}

	@Override
	public AddPermission getAddPermission(AddPermission queryParam) {
		return addPermissionDao.getAddPermission(queryParam);
	}

	@Override
	public List<AddPermission> listAllAddPermissions(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return addPermissionDao.listAllAddPermissions();
	}
}
