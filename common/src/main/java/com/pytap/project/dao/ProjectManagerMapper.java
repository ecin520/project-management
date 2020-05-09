package com.pytap.project.dao;

import com.pytap.project.entity.ProjectManager;
import com.pytap.project.entity.ProjectManagerExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProjectManagerMapper {
    int countByExample(ProjectManagerExample example);

    int deleteByExample(ProjectManagerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProjectManager record);

    int insertSelective(ProjectManager record);

    List<ProjectManager> selectByExample(ProjectManagerExample example);

    ProjectManager selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProjectManager record, @Param("example") ProjectManagerExample example);

    int updateByExample(@Param("record") ProjectManager record, @Param("example") ProjectManagerExample example);

    int updateByPrimaryKeySelective(ProjectManager record);

    int updateByPrimaryKey(ProjectManager record);
}