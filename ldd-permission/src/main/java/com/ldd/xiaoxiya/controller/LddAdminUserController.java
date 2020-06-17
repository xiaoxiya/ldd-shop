package com.ldd.xiaoxiya.controller;

import com.ldd.common.ResponseResult;
import com.ldd.model.LddAdminUser;
import com.ldd.model.LddPermissionResource;
import com.ldd.xiaoxiya.service.LddAdminUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoxiya
 * @date 2020/6/16 20:36
 * @describe 后台用户控制类
 */
@RestController
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class LddAdminUserController {
    @Autowired
    private LddAdminUserService adminUserService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "用户注册")
    public ResponseResult<LddAdminUser> register(LddAdminUser adminUser) {
         LddAdminUser lddAdminUser = adminUserService.register(adminUser);
         if (lddAdminUser == null) {
             return ResponseResult.failed(lddAdminUser, "注册失败");
         }
        return ResponseResult.success(lddAdminUser, "注册成功");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录")
    public ResponseResult login(String username, String password) {
        String token= adminUserService.login(username, password);
        if (token == null) {
            return ResponseResult.failed(token, "用户名或密码错误");
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("token", token);
        resultMap.put("tokenHead", tokenHead);
        return ResponseResult.success(resultMap, "用户登录成功");
    }

    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ApiOperation(value = "获取该用户所有权限")
    public ResponseResult<List<LddPermissionResource>> getPermissionList(@PathVariable Long adminId) {
        List<LddPermissionResource> permissionResourceList = adminUserService.getPermissionList(adminId);
        return ResponseResult.success(permissionResourceList);
    }

}
