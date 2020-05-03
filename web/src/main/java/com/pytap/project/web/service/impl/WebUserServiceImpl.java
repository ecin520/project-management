package com.pytap.project.web.service.impl;

import com.pytap.project.web.service.WebUserService;
import com.pytap.project.web.dao.WebUserDao;
import com.pytap.project.entity.AdditionalPermission;
import com.pytap.project.entity.Permission;
import com.pytap.project.entity.Role;
import com.pytap.project.web.model.dto.AuthDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/4/27 21:20
 */
@Service
public class WebUserServiceImpl implements WebUserService {

	@Resource
	private WebUserDao webUserDao;

	@Override
	public List<Permission> listUserPermissions(Long id) {
		return webUserDao.listUserPermissions(id);
	}

	@Override
	public List<AdditionalPermission> listUserAdditionalPermissions(Long id) {
		return webUserDao.listUserAdditionalPermissions(id);
	}

	@Override
	public List<Role> listUserRoles(Long id) {
		return webUserDao.listUserRoles(id);
	}

	@Override
	public List<AuthDTO> listUserAllPermissions(Long id) {
		List<Permission> permissions = listUserPermissions(id);
		List<AdditionalPermission> addPermissions = listUserAdditionalPermissions(id);

		List<AuthDTO> dtoList = new ArrayList<>(16);

		for (Permission permission : permissions) {
			AuthDTO dto = new AuthDTO();
			BeanUtils.copyProperties(permission, dto);
			dtoList.add(dto);
		}

		for (AdditionalPermission addPermission : addPermissions) {
			AuthDTO dto = new AuthDTO();
			BeanUtils.copyProperties(addPermission, dto);
			dtoList.add(dto);
		}

		return dtoList;
	}



	@Override
	public List<AuthDTO> listUserAllRolePermissions(Long id) {

		List<AuthDTO> permissions = listUserAllPermissions(id);

		List<Role> roles = listUserRoles(id);

		List<AuthDTO> dtoList = new ArrayList<>(16);

		for (AuthDTO permission : permissions) {
			AuthDTO authDTO = new AuthDTO();
			BeanUtils.copyProperties(permission, authDTO);
			dtoList.add(authDTO);
		}

		for (Role role : roles) {
			AuthDTO authDTO = new AuthDTO();
			BeanUtils.copyProperties(role, authDTO);
			dtoList.add(authDTO);
		}

		return dtoList;
	}

	@Override
	public List<Permission> listRolePermissions(Long id) {
		return webUserDao.listRolePermissions(id);
	}
}
