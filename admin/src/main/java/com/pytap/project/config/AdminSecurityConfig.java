package com.pytap.project.config;

import com.pytap.project.entity.User;
import com.pytap.project.model.dto.AuthDTO;
import com.pytap.project.security.config.SecurityConfig;
import com.pytap.project.service.AdminUserService;
import com.pytap.project.service.UserService;
import com.pytap.project.model.bo.UserDetailsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/30 16:30
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminSecurityConfig extends SecurityConfig {

	@Resource
	private AdminUserService adminUserService;

	@Resource
	private UserService userService;


	@Override
	@Bean
	public UserDetailsService userDetailsService() {
		return username -> {
			User user = userService.getByUsername(username);
			if (user != null) {
				List<AuthDTO> list = adminUserService.listUserAllRolePermissions(user.getId());
				for (AuthDTO authDTO : list) {
					System.out.println(authDTO.toString());
				}
				return new UserDetailsImpl(user, list);
			} else {
				throw new UsernameNotFoundException("用户名密码不正确");
			}
		};
	}


}
