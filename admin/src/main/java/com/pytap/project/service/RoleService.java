package com.pytap.project.service;

import com.pytap.project.entity.Role;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 14:33
 */
public interface RoleService {

	/**
	 * 统计总数
	 * @return Integer
	 * */
	Integer countRole();

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
	 * @param queryParam 查询参数
	 * @return Role 角色实体
	 * */
	Role getRole(Role queryParam);

	/**
	 * 获取所有角色
	 * @param pageNum 第几页
	 * @param pageSize 每页条目数量
	 * @return List<Role>
	 * */
	List<Role> listAllRoles(Integer pageNum, Integer pageSize);

}
