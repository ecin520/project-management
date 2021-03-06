package com.pytap.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.pytap.project.dao.RoleMapper;
import com.pytap.project.entity.Role;
import com.pytap.project.entity.RoleExample;
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
	private RoleMapper roleMapper;

	@Override
	@Cacheable(key = "'count-role'")
	public Integer countRole() {
		return roleMapper.countByExample(null);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer insertRole(Role role) {
		role.setCreateTime(new Date());
		return roleMapper.insert(role);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer deleteByRoleId(Long id) {
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer updateByRoleId(Role role) {
		return roleMapper.updateByPrimaryKey(role);
	}

	@Override
	@Cacheable(key = "'get-role' + queryParam.toString()")
	public Role getRole(Role queryParam) {
		RoleExample roleExample = new RoleExample();
		RoleExample.Criteria criteria = roleExample.createCriteria();
		if (null != queryParam.getId()) {
			return roleMapper.selectByPrimaryKey(queryParam.getId());
		} else if (null != queryParam.getName()){
			criteria.andNameEqualTo(queryParam.getName());
			return roleMapper.selectByExample(roleExample).get(0);
		}
		return null;
	}

	@Override
	@Cacheable(key = "'list-all-role' + #pageNum + '-' + #pageSize")
	public List<Role> listAllRoles(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return roleMapper.selectByExample(null);
	}


}
