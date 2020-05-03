package com.pytap.project.dao;

import com.pytap.project.entity.AdditionalPermission;
import com.pytap.project.entity.AdditionalPermissionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdditionalPermissionMapper {
    int countByExample(AdditionalPermissionExample example);

    int deleteByExample(AdditionalPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdditionalPermission record);

    int insertSelective(AdditionalPermission record);

    List<AdditionalPermission> selectByExample(AdditionalPermissionExample example);

    AdditionalPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdditionalPermission record, @Param("example") AdditionalPermissionExample example);

    int updateByExample(@Param("record") AdditionalPermission record, @Param("example") AdditionalPermissionExample example);

    int updateByPrimaryKeySelective(AdditionalPermission record);

    int updateByPrimaryKey(AdditionalPermission record);
}