package com.pytap.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.pytap.project.dao.RoleDao;
import com.pytap.project.entity.Role;
import com.pytap.project.service.RoleService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 14:37
 */
@Service
@CacheConfig(cacheNames = "role")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;

	@Override
	@Cacheable(key = "'count-role'")
	public Integer countRole() {
		return roleDao.countRole();
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer insertRole(Role role) {
		role.setCreateTime(new Date());
		return roleDao.insertRole(role);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer deleteByRoleId(Long id) {
		return roleDao.deleteByRoleId(id);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer updateByRoleId(Role role) {
		return roleDao.updateByRoleId(role);
	}

	@Override
	@Cacheable(key = "'get-role' + queryParam.toString()")
	public Role getRole(Role queryParam) {
		return roleDao.getRole(queryParam);
	}

	@Override
	@Cacheable(key = "'list-all-role'")
	public List<Role> listAllRoles(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return roleDao.listAllRoles();
	}


}
