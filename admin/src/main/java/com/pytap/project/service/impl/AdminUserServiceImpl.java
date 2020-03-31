package com.pytap.project.service.impl;

import com.pytap.project.dao.AdminUserDao;
import com.pytap.project.entity.AddPermission;
import com.pytap.project.entity.Permission;
import com.pytap.project.entity.Role;
import com.pytap.project.model.dto.AuthDTO;
import com.pytap.project.security.utils.JwtTokenUtil;
import com.pytap.project.service.AdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/30 13:36
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    private static final Logger logger = LoggerFactory.getLogger(AdminUserServiceImpl.class);

    @Resource
    private AdminUserDao adminUserDao;

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    public PasswordEncoder passwordEncoder;

    @Resource
    public JwtTokenUtil jwtTokenUtil;

    @Override
    public String login(String username, String password) {
        String token = "";
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码错误");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch(AuthenticationException e) {
            logger.error("登陆异常 {}", e.getMessage());
        }
        return token;
    }

    @Override
    public List<Permission> listUserPermissions(Long id) {
        return adminUserDao.listUserPermissions(id);
    }

    @Override
    public List<AddPermission> listUserAddPermissions(Long id) {
        return adminUserDao.listUserAddPermissions(id);
    }

    @Override
    public List<AuthDTO> listUserAllPermissions(Long id) {
        List<Permission> permissions = adminUserDao.listUserPermissions(id);
        List<AddPermission> addPermissions = adminUserDao.listUserAddPermissions(id);

        List<AuthDTO> dtoList = new ArrayList<>(16);

        for (Permission permission : permissions) {
            AuthDTO dto = new AuthDTO();
            BeanUtils.copyProperties(permission, dto);
            dtoList.add(dto);
        }

        for (AddPermission addPermission : addPermissions) {
            AuthDTO dto = new AuthDTO();
            BeanUtils.copyProperties(addPermission, dto);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<Role> listUserRoles(Long id) {
        return adminUserDao.listUserRoles(id);
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

}
