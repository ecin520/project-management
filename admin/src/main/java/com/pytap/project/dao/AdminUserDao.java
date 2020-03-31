package com.pytap.project.dao;

import com.pytap.project.entity.AddPermission;
import com.pytap.project.entity.Permission;
import com.pytap.project.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/28 1:17
 */
@Mapper
public interface AdminUserDao {

    /**
     * 根据用户id获取权限
     * @param id 用户id
     * @return List<PermissionDO>
     * */
    List<Permission> listUserPermissions(Long id);

    /**
     * 根据用户id获取额外权限
     * @param id 用户id
     * @return List<PermissionDO>
     * */
    List<AddPermission> listUserAddPermissions(Long id);

    /**
     * 根据用户id获取角色
     * @param id 用户id
     * @return List<RoleDO>
     * */
    List<Role> listUserRoles(Long id);
}
