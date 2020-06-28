package com.ldd.xiaoxiya.service.impl;

import com.github.pagehelper.PageHelper;
import com.ldd.mapper.LddMenuMapper;
import com.ldd.model.LddMenu;
import com.ldd.model.LddMenuExample;
import com.ldd.xiaoxiya.dto.LddMenuNode;
import com.ldd.xiaoxiya.service.LddMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaoxiya
 * @date 2020/6/27 22:59
 * @describe
 */
@Service
public class LddMenuServiceImpl implements LddMenuService {

    @Autowired
    private LddMenuMapper lddMenuMapper;

    @Override
    public int create(LddMenu lddMenu) {
        lddMenu.setCreateTime(new Date());
        updateLevel(lddMenu);
        return lddMenuMapper.insertSelective(lddMenu);

    }

    /**
     * 修改菜单层级
     * @param lddMenu
     */
    private void updateLevel(LddMenu lddMenu) {
        if (lddMenu.getParentId() == 0) {
            //没有父菜单为一级菜单
            lddMenu.setMenuLevel(0);
        } else {
            //有父菜单时选择根据父菜单level设置
            LddMenu parentMenu = lddMenuMapper.selectByPrimaryKey(lddMenu.getParentId());
            if (parentMenu != null) {
                lddMenu.setMenuLevel(parentMenu.getMenuLevel() + 1);
            } else {
                lddMenu.setMenuLevel(0);
            }
        }
    }

    @Override
    public int udpate(Long id, LddMenu lddMenu) {
        lddMenu.setMenuId(id);
        updateLevel(lddMenu);
        return lddMenuMapper.updateByPrimaryKeySelective(lddMenu);
    }

    @Override
    public int delete(Long id) {
        return lddMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<LddMenu> list(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        LddMenuExample example = new LddMenuExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andParentIdEqualTo(parentId);
        return lddMenuMapper.selectByExample(example);
    }

    @Override
    public List<LddMenuNode> treeList() {
        List<LddMenu> menuList = lddMenuMapper.selectByExample(new LddMenuExample());
        List<LddMenuNode> resultList = menuList.stream()
                //找出所有父菜单
                .filter(menu -> menu.getParentId().equals(0L))
                //找出对应父菜单下的子菜单
                .map(menu -> converMenuNode(menu, menuList)).collect(Collectors.toList());
        return resultList;
    }


    /**
     * 将LddMenu转化为LddMenuNode并设置children属性
     */
    private LddMenuNode converMenuNode(LddMenu menu, List<LddMenu> menuList) {
        LddMenuNode node = new LddMenuNode();
        //BeanUtils它提供了对java反射和自省API的包装，我们如果有两个具有很多相同属性的JavaBean
        //BeanUtils.copyProperties("转换后的类", "要转换的类");
        BeanUtils.copyProperties(menu, node);
        List<LddMenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getMenuId()))
                .map(subMenu -> converMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
