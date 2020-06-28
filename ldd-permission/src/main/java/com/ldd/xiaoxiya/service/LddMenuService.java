package com.ldd.xiaoxiya.service;

import com.ldd.model.LddMenu;
import com.ldd.xiaoxiya.dto.LddMenuNode;

import java.util.List;

/**
 * @author xiaoxiya
 * @date 2020/6/27 18:33
 * @describe 菜单管理服务
 */
public interface LddMenuService {

    /**
     * 增加菜单
     */
    int create(LddMenu lddMenu);

    /**
     * 修改菜单
     */
    int udpate(Long id, LddMenu lddMenu);

    /**
     * 删除菜单
     */
    int delete(Long id);

    /**
     * 分页查询后台菜单列表
     */
    List<LddMenu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 树形结构返回所有菜单列表
     */
    List<LddMenuNode> treeList();


}
