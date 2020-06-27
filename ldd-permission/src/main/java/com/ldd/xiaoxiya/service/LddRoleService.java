package com.ldd.xiaoxiya.service;

import com.ldd.model.LddMenu;
import com.ldd.model.LddPermissionResource;
import com.ldd.model.LddRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xiaoxiya
 * @date 2020/6/27 22:34
 * @describe
 */
public interface LddRoleService {
    /**
     * 添加角色
     */
    int create(LddRole role);

    /**
     * 更新角色
     */
    int update(Long id, LddRole role);

    /**
     * 删除角色
     */
    int delete(Long id);

    /**
     * 获取所有角色列表
     */
    List<LddRole> list();

    /**
     * 分页获取角色列表
     */
    List<LddRole> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 根据管理员ID获取对应菜单
     */
    List<LddMenu> getMenuList(Long adminId);

    /**
     * 获取角色相关菜单
     */
    List<LddMenu> listMenu(Long roleId);

    /**
     * 获取角色相关资源
     */
    List<LddPermissionResource> listResource(Long roleId);

    /**
     * 给角色分配菜单
     */
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * 给角色分配资源
     */
    @Transactional
    int allocResource(Long roleId, List<Long> resourceIds);
}
