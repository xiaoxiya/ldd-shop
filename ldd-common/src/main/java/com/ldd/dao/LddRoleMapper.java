package com.ldd.dao;

import com.ldd.model.LddRole;
import com.ldd.model.LddRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LddRoleMapper {
    long countByExample(LddRoleExample example);

    int deleteByExample(LddRoleExample example);

    int deleteByPrimaryKey(Long roleId);

    int insert(LddRole record);

    int insertSelective(LddRole record);

    List<LddRole> selectByExample(LddRoleExample example);

    LddRole selectByPrimaryKey(Long roleId);

    int updateByExampleSelective(@Param("record") LddRole record, @Param("example") LddRoleExample example);

    int updateByExample(@Param("record") LddRole record, @Param("example") LddRoleExample example);

    int updateByPrimaryKeySelective(LddRole record);

    int updateByPrimaryKey(LddRole record);
}