package com.ldd.xiaoxiya.service.impl;

import com.ldd.mapper.LddPermissionResourceMapper;
import com.ldd.model.LddPermissionResource;
import com.ldd.model.LddPermissionResourceExample;
import com.ldd.xiaoxiya.service.LddPermissionResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return 0;
    }

    @Override
    public int update(Long id, LddPermissionResource lddResource) {
        return 0;
    }

    @Override
    public LddPermissionResource getItem(Long id) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public List<LddPermissionResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        return null;
    }
}
