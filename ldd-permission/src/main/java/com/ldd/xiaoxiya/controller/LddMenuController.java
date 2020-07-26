package com.ldd.xiaoxiya.controller;

import com.ldd.common.CommonPage;
import com.ldd.common.ResponseResult;
import com.ldd.model.LddMenu;
import com.ldd.xiaoxiya.dto.LddMenuNode;
import com.ldd.xiaoxiya.service.LddMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiaoxiya
 * @date 2020/7/25 19:42
 * @describe 菜单管理controller
 */
@RestController
@Api(tags = "LddMenuController", description = "后台菜单管理")
@RequestMapping("/menu")
public class LddMenuController {

    @Autowired
    private LddMenuService lddMenuService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(value = "添加菜单")
    public ResponseResult create(@RequestBody LddMenu lddMenu) {
        int count = lddMenuService.create(lddMenu);
        if (count > 0) {
            return ResponseResult.success(count, "添加菜单成功");
        }
        return ResponseResult.failed(count, "菜单添加失败");
    }

    @RequestMapping(value = "/udpate/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "菜单更新")
    public ResponseResult udpate(@PathVariable Long id, @RequestBody LddMenu lddMenu) {
        int count = lddMenuService.udpate(id, lddMenu);
        if (count > 0) {
            return ResponseResult.success(count, "删除菜单成功");
        }
        return ResponseResult.failed(count, "菜单删除失败");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除菜单")
    public ResponseResult delete(@RequestParam("id") Long id) {
        int count = lddMenuService.delete(id);
        if (count > 0) {
            return ResponseResult.success(count, "删除菜单成功");
        }
        return ResponseResult.failed(count, "菜单删除失败");
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(value = "获取列表")
    public ResponseResult<CommonPage> list(@RequestParam("id") Long id,
                               @RequestParam(value = "pageSize", defaultValue = "5")Integer pageSize,
                               @RequestParam(value = "pageSize", defaultValue = "1")Integer pageNum) {
        List<LddMenu> lddMenusList  = lddMenuService.list(id, pageSize, pageNum);
        return ResponseResult.success(CommonPage.restPage(lddMenusList));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "获取树形列表")
    public ResponseResult treeList(@RequestParam("id") Long id) {
         List<LddMenuNode> treeList = lddMenuService.treeList();
        return ResponseResult.success(treeList);
    }


}
