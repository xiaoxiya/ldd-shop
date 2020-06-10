package com.ldd.dao;

import com.ldd.model.LddRoleMenu;
import com.ldd.model.LddRoleMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LddRoleMenuMapper {
    long countByExample(LddRoleMenuExample example);

    int deleteByExample(LddRoleMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LddRoleMenu record);

    int insertSelective(LddRoleMenu record);

    List<LddRoleMenu> selectByExample(LddRoleMenuExample example);

    LddRoleMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LddRoleMenu record, @Param("example") LddRoleMenuExample example);

    int updateByExample(@Param("record") LddRoleMenu record, @Param("example") LddRoleMenuExample example);

    int updateByPrimaryKeySelective(LddRoleMenu record);

    int updateByPrimaryKey(LddRoleMenu record);
}