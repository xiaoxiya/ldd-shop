package com.ldd.dao;

import com.ldd.model.LddAdminUser;
import com.ldd.model.LddAdminUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LddAdminUserMapper {
    long countByExample(LddAdminUserExample example);

    int deleteByExample(LddAdminUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(LddAdminUser record);

    int insertSelective(LddAdminUser record);

    List<LddAdminUser> selectByExample(LddAdminUserExample example);

    LddAdminUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") LddAdminUser record, @Param("example") LddAdminUserExample example);

    int updateByExample(@Param("record") LddAdminUser record, @Param("example") LddAdminUserExample example);

    int updateByPrimaryKeySelective(LddAdminUser record);

    int updateByPrimaryKey(LddAdminUser record);
}