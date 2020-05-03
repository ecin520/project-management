package com.pytap.project.dao;

import com.pytap.project.entity.WebLog;
import com.pytap.project.entity.WebLogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WebLogMapper {
    int countByExample(WebLogExample example);

    int deleteByExample(WebLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WebLog record);

    int insertSelective(WebLog record);

    List<WebLog> selectByExample(WebLogExample example);

    WebLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WebLog record, @Param("example") WebLogExample example);

    int updateByExample(@Param("record") WebLog record, @Param("example") WebLogExample example);

    int updateByPrimaryKeySelective(WebLog record);

    int updateByPrimaryKey(WebLog record);
}