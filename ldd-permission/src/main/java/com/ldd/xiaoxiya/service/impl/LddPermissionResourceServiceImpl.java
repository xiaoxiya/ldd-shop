package com.ldd.xiaoxiya.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.ldd.mapper.LddPermissionResourceMapper;
import com.ldd.model.LddPermissionResource;
import com.ldd.model.LddPermissionResourceExample;
import com.ldd.xiaoxiya.service.LddPermissionResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author xiaoxiya
 * @date 2020/6/21 16:34
 * @describe 后台资源路径实现类
 */
@Service
public class LddPermissionResourceServiceImpl implements LddPermissionResourceService {

    @Autowired
    private LddPermissionResourceMapper lddPermissionResourceMapper;

    @Override
    public List<LddPermissionResource> getAllList() {
        return lddPermissionResourceMapper.selectByExample(new LddPermissionResourceExample());
    }

    @Override
    public int create(LddPermissionResource lddResource) {
        lddResource.setCreateTime(new Date());
        return lddPermissionResourceMapper.insert(lddResource);
    }

    @Override
    public int update(Long id, LddPermissionResource lddResource) {
        lddResource.setPermissionId(id);
        return lddPermissionResourceMapper.updateByPrimaryKeySelective(lddResource);
    }

    @Override
    public LddPermissionResource getItem(Long id) {
        return lddPermissionResourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return lddPermissionResourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<LddPermissionResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        LddPermissionResourceExample example = new LddPermissionResourceExample();
        LddPermissionResourceExample.Criteria criteria = example.createCriteria();
        if (categoryId != null) {
            criteria.andCategoryIdEqualTo(categoryId);
        }
        if(StrUtil.isNotEmpty(nameKeyword)){
            criteria.andPermissionNameLike('%'+nameKeyword+'%');
        }
        if(StrUtil.isNotEmpty(urlKeyword)){
            criteria.andPermissionUrlLike('%'+urlKeyword+'%');
        }
        return lddPermissionResourceMapper.selectByExample(example);
    }
}
