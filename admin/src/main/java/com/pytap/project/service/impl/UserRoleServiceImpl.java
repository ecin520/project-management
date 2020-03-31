package com.pytap.project.service.impl;

import com.pytap.project.dao.UserRoleDao;
import com.pytap.project.entity.UserRole;
import com.pytap.project.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 14:39
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Resource
	private UserRoleDao userRoleDao;

	@Override
	public Integer insertUserRole(UserRole userRole) {
		userRole.setCreateTime(new Date());
		return userRoleDao.insertUserRole(userRole);
	}

	@Override
	public Integer deleteByUserRoleId(Long id) {
		return userRoleDao.deleteByUserRoleId(id);
	}

	@Override
	public Integer updateByUserRoleId(UserRole userRole) {
		return userRoleDao.updateByUserRoleId(userRole);
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
