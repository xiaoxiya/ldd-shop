package com.ldd.dao;

import com.ldd.model.LddPermissionResource;
import com.ldd.model.LddPermissionResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LddPermissionResourceMapper {
    long countByExample(LddPermissionResourceExample example);

    int deleteByExample(LddPermissionResourceExample example);

    int deleteByPrimaryKey(Long permissionId);

    int insert(LddPermissionResource record);

    int insertSelective(LddPermissionResource record);

    List<LddPermissionResource> selectByExample(LddPermissionResourceExample example);

    LddPermissionResource selectByPrimaryKey(Long permissionId);

    int updateByExampleSelective(@Param("record") LddPermissionResource record, @Param("example") LddPermissionResourceExample example);

    int updateByExample(@Param("record") LddPermissionResource record, @Param("example") LddPermissionResourceExample example);

    int updateByPrimaryKeySelective(LddPermissionResource record);

    int updateByPrimaryKey(LddPermissionResource record);
}