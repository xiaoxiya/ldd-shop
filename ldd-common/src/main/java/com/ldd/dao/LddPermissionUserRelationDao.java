package com.ldd.dao;

import com.ldd.model.LddPermissionResource;

import java.util.List;

/**
 * @author xiaoxiya
 * @date 2020/6/15 20:41
 * @describe 自定义dao，用户和权限对应关系
 */
public interface LddPermissionUserRelationDao {

    /**
     * 根据用户id获取用户的权限
     * @param adminId 用户id
     * @return 用户权限集合
     */
    List<LddPermissionResource> getUserPermission(Long adminId);
}
