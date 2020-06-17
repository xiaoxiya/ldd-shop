package com.ldd.mapper;

import com.ldd.model.LddPermissionRole;
import com.ldd.model.LddPermissionRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LddPermissionRoleMapper {
    long countByExample(LddPermissionRoleExample example);

    int deleteByExample(LddPermissionRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LddPermissionRole record);

    int insertSelective(LddPermissionRole record);

    List<LddPermissionRole> selectByExample(LddPermissionRoleExample example);

    LddPermissionRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LddPermissionRole record, @Param("example") LddPermissionRoleExample example);

    int updateByExample(@Param("record") LddPermissionRole record, @Param("example") LddPermissionRoleExample example);

    int updateByPrimaryKeySelective(LddPermissionRole record);

    int updateByPrimaryKey(LddPermissionRole record);
}