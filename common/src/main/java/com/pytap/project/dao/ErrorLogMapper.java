package com.pytap.project.dao;

import com.pytap.project.entity.ErrorLog;
import com.pytap.project.entity.ErrorLogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ErrorLogMapper {
    int countByExample(ErrorLogExample example);

    int deleteByExample(ErrorLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ErrorLog record);

    int insertSelective(ErrorLog record);

    List<ErrorLog> selectByExample(ErrorLogExample example);

    ErrorLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ErrorLog record, @Param("example") ErrorLogExample example);

    int updateByExample(@Param("record") ErrorLog record, @Param("example") ErrorLogExample example);

    int updateByPrimaryKeySelective(ErrorLog record);

    int updateByPrimaryKey(ErrorLog record);
}