package com.ldd.dao;

import com.ldd.model.LddRoleUser;
import com.ldd.model.LddRoleUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LddRoleUserMapper {
    long countByExample(LddRoleUserExample example);

    int deleteByExample(LddRoleUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LddRoleUser record);

    int insertSelective(LddRoleUser record);

    List<LddRoleUser> selectByExample(LddRoleUserExample example);

    LddRoleUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LddRoleUser record, @Param("example") LddRoleUserExample example);

    int updateByExample(@Param("record") LddRoleUser record, @Param("example") LddRoleUserExample example);

    int updateByPrimaryKeySelective(LddRoleUser record);

    int updateByPrimaryKey(LddRoleUser record);
}