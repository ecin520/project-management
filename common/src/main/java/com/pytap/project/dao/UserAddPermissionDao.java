package com.pytap.project.dao;

import com.pytap.project.entity.UserAddPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/31 1:19
 */
@Mapper
public interface UserAddPermissionDao {

	/**
	 * 统计总数
	 * @return Integer
	 * */
	Integer countAddPermission();

	/**
	 * 插入用户额外权限关系
	 * @param userAddPermission 用户额外权限关系实体
	 * @return Integer
	 * */
	Integer insertUserAddPermission(UserAddPermission userAddPermission);

	/**
	 * 删除用户额外权限关系
	 * @param userAddPermission 用户附加权限关系
	 * @return Integer
	 * */
	Integer deleteByUserAddPermission(UserAddPermission userAddPermission);

	/**
	 * 更新用户额外权限关系
	 * @param userAddPermission 用户额外权限关系实体
	 * @return Integer
	 * */
	Integer updateByUserAddPermissionId(UserAddPermission userAddPermission);

	/**
	 * 主键获得用户额外权限关系
	 * @param id 主键
	 * @return UserAddPermission
	 * */
	UserAddPermission getByUserAddPermissionId(Long id);

	/**
	 * 获取所有用户额外权限关系
	 * @return List<UserAddPermission>
	 * */
	List<UserAddPermission> listAllUserAddPermissions();

}
