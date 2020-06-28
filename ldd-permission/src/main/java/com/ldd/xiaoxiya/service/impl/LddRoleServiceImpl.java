package com.ldd.xiaoxiya.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.ldd.dao.LddPermissionUserRelationDao;
import com.ldd.mapper.LddPermissionRoleMapper;
import com.ldd.mapper.LddRoleMapper;
import com.ldd.mapper.LddRoleMenuMapper;
import com.ldd.mapper.LddRoleUserMapper;
import com.ldd.model.*;
import com.ldd.xiaoxiya.service.LddRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author xiaoxiya
 * @date 2020/6/27 23:00
 * @describe
 */
@Service
public class LddRoleServiceImpl implements LddRoleService {

    @Autowired
    private LddRoleMapper lddRoleMapper;

    @Autowired
    private LddPermissionUserRelationDao relationDao;

    @Autowired
    private LddRoleMenuMapper roleMenuMapper;

    @Autowired
    private LddPermissionRoleMapper permissionRoleMapper;

    @Override
    public int create(LddRole role) {
        role.setCreateTime(new Date());
        return lddRoleMapper.insertSelective(role);
    }

    @Override
    public int update(Long id, LddRole role) {
        role.setRoleId(id);
        return lddRoleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int delete(Long id) {
        return lddRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<LddRole> list() {
        return  lddRoleMapper.selectByExample(new LddRoleExample());
    }

    @Override
    public List<LddRole> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        LddRoleExample example = new LddRoleExample();
        if (!StrUtil.isEmpty(keyword)) {
            example.createCriteria().andRoleNameLike("%" + keyword + "%");
        }
        return lddRoleMapper.selectByExample(example);
    }

    @Override
    public List<LddMenu> getMenuList(Long adminId) {
        return relationDao.getMenuList(adminId);
    }

    @Override
    public List<LddMenu> listMenu(Long roleId) {
        return relationDao.getMenuListByRoleId(roleId);
    }

    @Override
    public List<LddPermissionResource> listResource(Long roleId) {
        return relationDao.getResourceListByRoleId(roleId);
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //先删除原有关系
        LddRoleMenuExample example=new LddRoleMenuExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleMenuMapper.deleteByExample(example);
        //批量插入新关系
        for (Long menuId : menuIds) {
            LddRoleMenu relation = new LddRoleMenu();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            roleMenuMapper.insert(relation);
        }
        return menuIds.size();
    }

    @Override
    public int allocResource(Long roleId, List<Long> permissionIds) {
        //先删除原有关系
        LddPermissionRoleExample example=new LddPermissionRoleExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        permissionRoleMapper.deleteByExample(example);
        //批量插入新关系
        for (Long permissionId : permissionIds) {
            LddPermissionRole relation = new LddPermissionRole();
            relation.setRoleId(roleId);
            relation.setPermissionId(permissionId);
            permissionRoleMapper.insert(relation);
        }
        return permissionIds.size();
    }
}
