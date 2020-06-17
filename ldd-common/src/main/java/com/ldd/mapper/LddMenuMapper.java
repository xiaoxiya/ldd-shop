package com.ldd.mapper;

import com.ldd.model.LddMenu;
import com.ldd.model.LddMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LddMenuMapper {
    long countByExample(LddMenuExample example);

    int deleteByExample(LddMenuExample example);

    int deleteByPrimaryKey(Long menuId);

    int insert(LddMenu record);

    int insertSelective(LddMenu record);

    List<LddMenu> selectByExample(LddMenuExample example);

    LddMenu selectByPrimaryKey(Long menuId);

    int updateByExampleSelective(@Param("record") LddMenu record, @Param("example") LddMenuExample example);

    int updateByExample(@Param("record") LddMenu record, @Param("example") LddMenuExample example);

    int updateByPrimaryKeySelective(LddMenu record);

    int updateByPrimaryKey(LddMenu record);
}