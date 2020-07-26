package com.ldd.xiaoxiya.controller;

import com.ldd.common.CommonPage;
import com.ldd.common.ResponseResult;
import com.ldd.model.LddMenu;
import com.ldd.model.LddPermissionResource;
import com.ldd.model.LddRole;
import com.ldd.xiaoxiya.service.LddRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiaoxiya
 * @date 2020/7/25 19:42
 * @describe 角色控制类
 */
@RestController
@Api(tags = "LddRoleController", description = "后台角色管理")
@RequestMapping("/role")
public class LddRoleController {
    @Autowired
    private LddRoleService lddRoleService;

    /**
     * 添加角色
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(value = "添加角色")
    public ResponseResult create(@RequestBody LddRole role) {
        int count = lddRoleService.create(role);
        if (count > 0) {
            return ResponseResult.success(count, "添加角色成功");
        }
        return ResponseResult.failed(count, "添加角色失败");
    }

    /**
     * 更新角色
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新角色")
    public ResponseResult update(@RequestParam("id") Long id, @RequestBody LddRole role){
        int count = lddRoleService.update(id, role);
        if (count > 0) {
            return ResponseResult.success(count, "更新角色成功");
        }
        return ResponseResult.failed(count, "更新角色失败");
    }

    /**
     * 删除角色
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "删除角色")
    public ResponseResult delete(@PathVariable Long id){
        int count = lddRoleService.delete(id);
        if (count > 0) {
            return ResponseResult.success(count, "添加角色成功");
        }
        return ResponseResult.failed(count, "添加角色失败");
    }

    /**
     * 获取所有角色列表
     */

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有角色列表")
    public ResponseResult list(){
        List<LddRole> lddRolesList = lddRoleService.list();
        return ResponseResult.success(CommonPage.restPage(lddRolesList));
    }

    /**
     * 分页获取角色列表
     */
    @RequestMapping(value = "/listByPage", method = RequestMethod.POST)
    @ApiOperation(value = "分页获取角色列表")
    public ResponseResult listByPage(@RequestParam("keyword") String keyword,
                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<LddRole> lddRolesList = lddRoleService.list(keyword, pageSize, pageNum);
        return ResponseResult.success(CommonPage.restPage(lddRolesList));
    }

    /**
     * 根据管理员ID获取对应菜单
     */
    @RequestMapping(value = "/getMenuList/{adminId}", method = RequestMethod.POST)
    @ApiOperation(value = "根据管理员ID获取对应菜单")
    public ResponseResult getMenuList(@PathVariable Long adminId){
        List<LddMenu> lddMenuList = lddRoleService.getMenuList(adminId);
        return ResponseResult.success(CommonPage.restPage(lddMenuList));
    }

    /**
     * 获取角色相关菜单
     */
    @RequestMapping(value = "/listMenu/{roleId}", method = RequestMethod.POST)
    @ApiOperation(value = "获取角色相关菜单")
    public ResponseResult listMenu(@PathVariable Long roleId){
        List<LddMenu> lddMenuList = lddRoleService.listMenu(roleId);
        return ResponseResult.success(CommonPage.restPage(lddMenuList));
    }

    /**
     * 获取角色相关资源
     */
    @RequestMapping(value = "/listResource/{roleId}", method = RequestMethod.POST)
    @ApiOperation(value = "获取角色相关资源")
    public ResponseResult  listResource(@PathVariable Long roleId){
        List<LddPermissionResource> lddPermissionResourceList = lddRoleService.listResource(roleId);
        return ResponseResult.success(CommonPage.restPage(lddPermissionResourceList));
    }

    /**
     * 给角色分配菜单
     */
    @RequestMapping(value = "/allocMenu", method = RequestMethod.POST)
    @ApiOperation(value = "给角色分配菜单")
    public ResponseResult allocMenu(@RequestParam("roleId") Long roleId, @RequestParam("menuIds") List<Long> menuIds){
        int count = lddRoleService.allocMenu(roleId, menuIds);
        return ResponseResult.success(count);
    }

    /**
     * 给角色分配资源
     */
    @RequestMapping(value = "/allocResource", method = RequestMethod.POST)
    @ApiOperation(value = "给角色分配资源")
    public ResponseResult allocResource(@RequestParam("roleId") Long roleId, @RequestParam("permissionIds") List<Long> permissionIds){
        int count  = lddRoleService.allocResource(roleId, permissionIds);
        return ResponseResult.success(count);
    }
}
