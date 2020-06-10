package com.ldd.dao;

import com.ldd.model.LddPermissionUser;
import com.ldd.model.LddPermissionUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LddPermissionUserMapper {
    long countByExample(LddPermissionUserExample example);

    int deleteByExample(LddPermissionUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LddPermissionUser record);

    int insertSelective(LddPermissionUser record);

    List<LddPermissionUser> selectByExample(LddPermissionUserExample example);

    LddPermissionUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LddPermissionUser record, @Param("example") LddPermissionUserExample example);

    int updateByExample(@Param("record") LddPermissionUser record, @Param("example") LddPermissionUserExample example);

    int updateByPrimaryKeySelective(LddPermissionUser record);

    int updateByPrimaryKey(LddPermissionUser record);
}