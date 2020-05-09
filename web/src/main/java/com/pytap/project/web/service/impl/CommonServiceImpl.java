package com.pytap.project.web.service.impl;

import com.pytap.project.dao.AdditionalPermissionMapper;
import com.pytap.project.dao.UserAdditionalPermissionMapper;
import com.pytap.project.dao.UserMapper;
import com.pytap.project.dao.UserRoleMapper;
import com.pytap.project.entity.*;
import com.pytap.project.security.utils.JwtTokenUtil;
import com.pytap.project.utils.FinalUtil;
import com.pytap.project.web.service.CommonService;
import com.pytap.project.utils.ImageUtil;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

/**
 * @author Ecin520
 * @date 2020/4/27 21:06
 */
@Service
@CacheConfig(cacheNames = "user")
public class CommonServiceImpl implements CommonService {

	@Resource
	private UserDetailsService userDetailsService;

	@Resource
	private PasswordEncoder passwordEncoder;

	@Resource
	private JwtTokenUtil jwtTokenUtil;

	@Resource
	private UserMapper userMapper;

	@Resource
	private UserAdditionalPermissionMapper userAdditionalPermissionMapper;

	@Resource
	private AdditionalPermissionMapper additionalPermissionMapper;

	@Resource
	private UserRoleMapper userRoleMapper;

	@Override
	@CacheEvict(allEntries = true)
	@Transactional(rollbackFor = {RuntimeException.class, Error.class})
	public Integer register(String username, String password) {
		User user = new User();
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUsernameEqualTo(username);

		if (0 != userMapper.selectByExample(userExample).size()) {
			return null;
		}

		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		user.setCreateTime(new Date());
		user.setStatus(1);
		user.setAvatar(ImageUtil.IMAGE_COLLECTION[new Random().nextInt(ImageUtil.IMAGE_COLLECTION.length)]);

		int result = userMapper.insert(user);

		// 添加用户角色
		UserRole userRole = new UserRole();
		userRole.setUserId(user.getId());
		userRole.setRoleId(1001L);

		userRoleMapper.insert(userRole);

		// 创建附加权限
		AdditionalPermission additionalPermission = new AdditionalPermission();
		additionalPermission.setName(FinalUtil.AP_USER + user.getId());
		additionalPermission.setDescription("Additional Permission By User " + user.getId());
		additionalPermission.setCreateTime(new Date());

		additionalPermissionMapper.insert(additionalPermission);

		// 添加附加权限
		UserAdditionalPermission userAdditionalPermission = new UserAdditionalPermission();
		userAdditionalPermission.setUserId(user.getId());
		userAdditionalPermission.setAdditionalPermissionId(additionalPermission.getId());

		userAdditionalPermissionMapper.insert(userAdditionalPermission);

		return result;
	}

	@Override
	public String login(String username, String password) {
		String token;
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		if (!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("密码错误");
		}
		if (!userDetails.isEnabled()) {
			throw new DisabledException("账户已被禁用");
		}
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, null, userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		token = jwtTokenUtil.generateToken(userDetails);
		return token;
	}

	@Override
	public String refreshToken(String username) {
		String token;
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, null, userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		token = jwtTokenUtil.generateToken(userDetails);
		return token;
	}

	@Override
	public void refreshUser(String username) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, null, userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	}

}
