package com.ldd.mapper;

import com.ldd.model.LddResourceCaregory;
import com.ldd.model.LddResourceCaregoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LddResourceCaregoryMapper {
    long countByExample(LddResourceCaregoryExample example);

    int deleteByExample(LddResourceCaregoryExample example);

    int deleteByPrimaryKey(Long categoryId);

    int insert(LddResourceCaregory record);

    int insertSelective(LddResourceCaregory record);

    List<LddResourceCaregory> selectByExample(LddResourceCaregoryExample example);

    LddResourceCaregory selectByPrimaryKey(Long categoryId);

    int updateByExampleSelective(@Param("record") LddResourceCaregory record, @Param("example") LddResourceCaregoryExample example);

    int updateByExample(@Param("record") LddResourceCaregory record, @Param("example") LddResourceCaregoryExample example);

    int updateByPrimaryKeySelective(LddResourceCaregory record);

    int updateByPrimaryKey(LddResourceCaregory record);
}