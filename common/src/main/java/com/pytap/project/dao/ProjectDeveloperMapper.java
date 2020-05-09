package com.pytap.project.dao;

import com.pytap.project.entity.ProjectDeveloper;
import com.pytap.project.entity.ProjectDeveloperExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProjectDeveloperMapper {
    int countByExample(ProjectDeveloperExample example);

    int deleteByExample(ProjectDeveloperExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProjectDeveloper record);

    int insertSelective(ProjectDeveloper record);

    List<ProjectDeveloper> selectByExample(ProjectDeveloperExample example);

    ProjectDeveloper selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProjectDeveloper record, @Param("example") ProjectDeveloperExample example);

    int updateByExample(@Param("record") ProjectDeveloper record, @Param("example") ProjectDeveloperExample example);

    int updateByPrimaryKeySelective(ProjectDeveloper record);

    int updateByPrimaryKey(ProjectDeveloper record);
}