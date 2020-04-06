package com.pytap.project.controller;

import com.pytap.project.annotation.WebLog;
import com.pytap.project.entity.AddPermission;
import com.pytap.project.entity.Permission;
import com.pytap.project.entity.Role;
import com.pytap.project.model.dto.AuthDTO;
import com.pytap.project.service.AdminUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/26 22:07
 */
@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('R_ADMIN')")
public class AdminUserController {

    @Resource
    private AdminUserService adminUserService;

    @ApiOperation(value = "根据id获取用户所有权限，不包括附加权限")
    @WebLog(value = "根据id获取用户所有权限，不包括附加权限")
    @RequestMapping(value = "listUserPermissions", method = RequestMethod.POST)
    public List<Permission> listUserPermissions(Long id) {
        return adminUserService.listUserPermissions(id);
    }

    @ApiOperation(value = "根据id获取用户所有附加权限")
    @RequestMapping(value = "listUserAddPermissions", method = RequestMethod.POST)
    public List<AddPermission> listUserAddPermissions(Long id) {
        return adminUserService.listUserAddPermissions(id);
    }

    @ApiOperation(value = "根据id获取用户所有权限，包括附加权限")
    @RequestMapping(value = "listAllPermissions", method = RequestMethod.POST)
    public List<AuthDTO> userList(Long id) {
        return adminUserService.listUserAllPermissions(id);
    }

    @RequestMapping(value = "listAllRoles", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户所有角色")
    public List<Role> listAllRoles(Long id) {
        return adminUserService.listUserRoles(id);
    }

    @ApiOperation(value = "根据id获取用户所有角色权限，包括附加权限")
    @RequestMapping(value = "listUserAllRolesPermissions", method = RequestMethod.POST)
    public List<AuthDTO> listAllRolesPermissions(Long id) {
        return adminUserService.listUserAllRolePermissions(id);
    }



}
