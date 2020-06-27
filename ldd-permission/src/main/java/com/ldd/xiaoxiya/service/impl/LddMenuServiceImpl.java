package com.ldd.xiaoxiya.service.impl;

import com.ldd.xiaoxiya.dto.LddMenuNode;
import com.ldd.xiaoxiya.service.LddMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaoxiya
 * @date 2020/6/27 22:59
 * @describe
 */
@Service
public class LddMenuServiceImpl implements LddMenuService {
    @Override
    public int create(LddMenuService lddMenu) {
        return 0;
    }

    @Override
    public int udpate(Long id, LddMenuService lddMenu) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public List<LddMenuService> list(Long parentId, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public List<LddMenuNode> treeList() {
        return null;
    }
}
