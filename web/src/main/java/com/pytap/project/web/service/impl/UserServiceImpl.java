package com.pytap.project.web.service.impl;

import com.pytap.project.dao.UserMapper;
import com.pytap.project.entity.User;
import com.pytap.project.entity.UserExample;
import com.pytap.project.web.model.dto.UserDTO;
import com.pytap.project.web.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/4/27 21:13
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	@CacheEvict(allEntries = true)
	public Integer deleteByUserId(Long id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	@CacheEvict(allEntries = true)
	public Integer updateByUserId(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public User getByUserId(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User getByUsername(String username) {

		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> list = userMapper.selectByExample(userExample);

		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public UserDTO getDtoByUserId(Long id) {
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(userMapper.selectByPrimaryKey(id), userDTO);
		return userDTO;
	}

	@Override
	public UserDTO getDtoByUsername(String username) {

		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> list = userMapper.selectByExample(userExample);

		User user = list.size() > 0 ? list.get(0) : null;

		UserDTO userDTO = new UserDTO();
		if (null != user) {
			BeanUtils.copyProperties(user, userDTO);
		}

		return userDTO;
	}


}
