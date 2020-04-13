package com.pytap.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.WebLog;
import com.pytap.project.service.AdminUserService;
import com.pytap.project.utils.JsonUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @WebLog(value = "根据id获取用户所有权限，不包括附加权限")
    @RequestMapping(value = "listUserPermissions", method = RequestMethod.POST)
    public JSONObject listUserPermissions(Long id) {
        return JsonUtil.backObject(200, adminUserService.listUserPermissions(id));
    }

    @WebLog(value = "根据id获取用户所有附加权限")
    @RequestMapping(value = "listUserAddPermissions", method = RequestMethod.POST)
    public JSONObject listUserAddPermissions(Long id) {
        return JsonUtil.backObject(200, adminUserService.listUserAddPermissions(id));
    }

    @WebLog(value = "根据id获取用户所有权限，包括附加权限")
    @RequestMapping(value = "listAllPermissions", method = RequestMethod.POST)
    public JSONObject userList(Long id) {
        return JsonUtil.backObject(200, adminUserService.listUserAllPermissions(id));
    }

    @WebLog(value = "获取用户所有角色")
    @RequestMapping(value = "listAllRoles", method = RequestMethod.POST)
    public JSONObject listAllRoles(Long id) {
        return JsonUtil.backObject(200, adminUserService.listUserRoles(id));
    }

    @WebLog(value = "根据id获取用户所有角色权限，包括附加权限")
    @RequestMapping(value = "listUserAllRolesPermissions", method = RequestMethod.POST)
    public JSONObject listAllRolesPermissions(Long id) {
        return JsonUtil.backObject(200, adminUserService.listUserAllRolePermissions(id));
    }



}
