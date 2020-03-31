package com.pytap.project.dao;

import com.pytap.project.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/28 1:09
 */
@Mapper
public interface RoleDao {

    /**
     * 插入角色
     * @param role 角色实体
     * @return Integer
     * */
    Integer insertRole(Role role);

    /**
     * 删除角色
     * @param id 角色id
     * @return Integer
     * */
    Integer deleteByRoleId(Long id);

    /**
     * 更新角色
     * @param role 角色实体
     * @return Integer
     * */
    Integer updateByRoleId(Role role);

    /**
     * 主键获得角色
     * @param id 角色id
     * @return Role 角色实体
     * */
    Role getByRoleId(Long id);

    /**
     * 获取所有角色
     * @return List<Role>
     * */
    List<Role> listAllRoles();
}
