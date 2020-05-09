package com.pytap.project.dao;

import com.pytap.project.entity.ProjectVerification;
import com.pytap.project.entity.ProjectVerificationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProjectVerificationMapper {
    int countByExample(ProjectVerificationExample example);

    int deleteByExample(ProjectVerificationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProjectVerification record);

    int insertSelective(ProjectVerification record);

    List<ProjectVerification> selectByExample(ProjectVerificationExample example);

    ProjectVerification selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProjectVerification record, @Param("example") ProjectVerificationExample example);

    int updateByExample(@Param("record") ProjectVerification record, @Param("example") ProjectVerificationExample example);

    int updateByPrimaryKeySelective(ProjectVerification record);

    int updateByPrimaryKey(ProjectVerification record);
}