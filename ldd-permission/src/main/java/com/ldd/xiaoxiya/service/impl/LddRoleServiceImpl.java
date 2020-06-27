package com.ldd.xiaoxiya.service.impl;

import com.ldd.model.LddMenu;
import com.ldd.model.LddPermissionResource;
import com.ldd.model.LddRole;
import com.ldd.xiaoxiya.service.LddRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaoxiya
 * @date 2020/6/27 23:00
 * @describe
 */
@Service
public class LddRoleServiceImpl implements LddRoleService {
    @Override
    public int create(LddRole role) {
        return 0;
    }

    @Override
    public int update(Long id, LddRole role) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public List<LddRole> list() {
        return null;
    }

    @Override
    public List<LddRole> list(String keyword, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public List<LddMenu> getMenuList(Long adminId) {
        return null;
    }

    @Override
    public List<LddMenu> listMenu(Long roleId) {
        return null;
    }

    @Override
    public List<LddPermissionResource> listResource(Long roleId) {
        return null;
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        return 0;
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        return 0;
    }
}
