package com.ldd.xiaoxiya.controller;

import com.ldd.common.CommonPage;
import com.ldd.common.ResponseResult;
import com.ldd.model.LddPermissionResource;
import com.ldd.xiaoxiya.service.LddPermissionResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiaoxiya
 * @date 2020/7/25 19:43
 * @describe 后台资源控制类
 */
@RestController
@Api(tags = "LddPermissionResourceController", description = "后台资源管理")
@RequestMapping("/permission")
public class LddPermissionResourceController {
    @Autowired
    private LddPermissionResourceService permissionResourceService;

    /**
     * 添加资源
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(value = "创建资源")
    public ResponseResult create(@RequestBody LddPermissionResource lddResource){
        int count =  permissionResourceService.create(lddResource);
        if (count > 0) {
            return ResponseResult.success(count, "创建资源成功");
        }
        return ResponseResult.failed(count, "创建资源失败");
    }

    /**
     * 修改资源
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "修改资源")
    public ResponseResult update(@RequestParam("id") Long id, @RequestBody LddPermissionResource lddResource) {
        int count =  permissionResourceService.update(id, lddResource);
        if (count > 0) {
            return ResponseResult.success(count, "修改资源成功");
        }
        return ResponseResult.failed(count, "修改资源失败");
    }

    /**
     * 获取资源详情
     */
    @RequestMapping(value = "/getItem/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "删除菜单")
    public ResponseResult getItem(@PathVariable Long id) {
        LddPermissionResource lddPermissionResource = permissionResourceService.getItem(id);
        return ResponseResult.success(lddPermissionResource);
    }

    /**
     * 删除资源
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "删除菜单")
    public ResponseResult delete(@PathVariable Long id) {
        int count =  permissionResourceService.delete(id);
        if (count > 0) {
            return ResponseResult.success(count, "删除资源成功");
        }
        return ResponseResult.failed(count, "删除资源失败");
    }

    /**
     * 分页查询资源
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(value = "获取资源列表")
    public ResponseResult<CommonPage> list(@RequestParam(required = false) Long categoryId,
                                           @RequestParam(required = false) String nameKeyword,
                                           @RequestParam(required = false) String urlKeyword,
                                           @RequestParam(value = "pageSize", defaultValue = "5")Integer pageSize,
                                           @RequestParam(value = "pageSize", defaultValue = "1")Integer pageNum) {
        List<LddPermissionResource> resourceList = permissionResourceService.list(categoryId,nameKeyword, urlKeyword, pageSize, pageNum);
        return ResponseResult.success(CommonPage.restPage(resourceList));
    }
}
