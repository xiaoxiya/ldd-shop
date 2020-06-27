package com.ldd.xiaoxiya.service;

import com.ldd.model.LddPermissionResource;

import java.util.List;

/**
 * @author xiaoxiya
 * @date 2020/6/21 16:30
 * @describe 后台资源路径service
 */
public interface LddPermissionResourceService {
    /**
     * 获取所有资源路径
     * @return
     */
    List<LddPermissionResource> getAllList();

    /**
     * 添加资源
     */
    int create(LddPermissionResource lddResource);

    /**
     * 修改资源
     */
    int update(Long id, LddPermissionResource lddResource);

    /**
     * 获取资源详情
     */
    LddPermissionResource getItem(Long id);

    /**
     * 删除资源
     */
    int delete(Long id);

    /**
     * 分页查询资源
     */
    List<LddPermissionResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);
}
