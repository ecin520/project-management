package com.pytap.project.dao;

import com.pytap.project.entity.Annex;
import com.pytap.project.entity.AnnexExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnnexMapper {
    int countByExample(AnnexExample example);

    int deleteByExample(AnnexExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Annex record);

    int insertSelective(Annex record);

    List<Annex> selectByExample(AnnexExample example);

    Annex selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Annex record, @Param("example") AnnexExample example);

    int updateByExample(@Param("record") Annex record, @Param("example") AnnexExample example);

    int updateByPrimaryKeySelective(Annex record);

    int updateByPrimaryKey(Annex record);
}