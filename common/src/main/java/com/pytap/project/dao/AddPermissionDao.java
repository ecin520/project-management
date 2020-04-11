package com.pytap.project.dao;

import com.pytap.project.entity.AddPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/28 1:10
 */
@Mapper
public interface AddPermissionDao {

    /**
     * 统计总数
     * @return Integer
     * */
    Integer countAddPermission();

    /**
     * 插入额外权限
     * @param addPermission 额外权限实体
     * @return Integer
     * */
    Integer insertAddPermission(AddPermission addPermission);

    /**
     * 删除额外权限
     * @param id 额外权限id
     * @return Integer
     * */
    Integer deleteByAddPermissionId(Long id);

    /**
     * 更新额外权限
     * @param addPermission 额外权限实体
     * @return Integer
     * */
    Integer updateByAddPermissionId(AddPermission addPermission);

    /**
     * 主键获得额外权限
     * @param queryParam 查询参数
     * @return AddPermission 额外权限实体
     * */
    AddPermission getAddPermission(AddPermission queryParam);

    /**
     * 获取所有额外权限
     * @return List<AddPermission>
     * */
    List<AddPermission> listAllAddPermissions();
}
