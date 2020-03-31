package com.pytap.project.service.impl;

import com.pytap.project.dao.RoleDao;
import com.pytap.project.entity.Role;
import com.pytap.project.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 14:37
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;

	@Override
	public Integer insertRole(Role role) {
		role.setCreateTime(new Date());
		return roleDao.insertRole(role);
	}

	@Override
	public Integer deleteByRoleId(Long id) {
		return roleDao.deleteByRoleId(id);
	}

	@Override
	public Integer updateByRoleId(Role role) {
		return roleDao.updateByRoleId(role);
	}

	@Override
	public Role getByRoleId(Long id) {
		return roleDao.getByRoleId(id);
	}

	@Override
	public List<Role> listAllRoles() {
		return roleDao.listAllRoles();
	}
}
