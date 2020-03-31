package com.pytap.project.dao;

import com.pytap.project.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 1:18
 */
@Mapper
public interface UserRoleDao {

	/**
	 * 插入用户角色关系
	 * @param userRole 用户角色关系实体
	 * @return Integer
	 * */
	Integer insertUserRole(UserRole userRole);

	/**
	 * 删除用户角色关系
	 * @param id 用户角色关系id
	 * @return Integer
	 * */
	Integer deleteByUserRoleId(Long id);

	/**
	 * 更新用户角色关系
	 * @param userRole 用户角色关系实体
	 * @return Integer
	 * */
	Integer updateByUserRoleId(UserRole userRole);

	/**
	 * 主键获得用户角色关系
	 * @param id 主键
	 * @return UserRole
	 * */
	UserRole getByUserRoleId(Long id);

	/**
	 * 获取所有用户角色关系
	 * @return List<UserRole>
	 * */
	List<UserRole> listAllUserRoles();

}
