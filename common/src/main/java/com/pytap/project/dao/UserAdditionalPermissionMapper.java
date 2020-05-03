package com.pytap.project.dao;

import com.pytap.project.entity.UserAdditionalPermission;
import com.pytap.project.entity.UserAdditionalPermissionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserAdditionalPermissionMapper {
    int countByExample(UserAdditionalPermissionExample example);

    int deleteByExample(UserAdditionalPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserAdditionalPermission record);

    int insertSelective(UserAdditionalPermission record);

    List<UserAdditionalPermission> selectByExample(UserAdditionalPermissionExample example);

    UserAdditionalPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserAdditionalPermission record, @Param("example") UserAdditionalPermissionExample example);

    int updateByExample(@Param("record") UserAdditionalPermission record, @Param("example") UserAdditionalPermissionExample example);

    int updateByPrimaryKeySelective(UserAdditionalPermission record);

    int updateByPrimaryKey(UserAdditionalPermission record);
}