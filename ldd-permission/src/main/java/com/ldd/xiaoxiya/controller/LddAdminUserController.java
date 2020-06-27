package com.ldd.xiaoxiya.controller;

import com.ldd.common.ResponseResult;
import com.ldd.model.LddAdminUser;
import com.ldd.model.LddPermissionResource;
import com.ldd.xiaoxiya.dto.LddAdminUserLoginParam;
import com.ldd.xiaoxiya.dto.LddAdminUserParam;
import com.ldd.xiaoxiya.service.LddAdminUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public ResponseResult<LddAdminUser> register(@RequestBody LddAdminUserParam adminUserParam, BindingResult result) {
         LddAdminUser lddAdminUser = adminUserService.register(adminUserParam);
         if (lddAdminUser == null) {
             return ResponseResult.failed(lddAdminUser, "注册失败");
         }
        return ResponseResult.success(lddAdminUser, "注册成功");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录")
    public ResponseResult login(@RequestBody LddAdminUserLoginParam adminUserParam, BindingResult result) {
        String token= adminUserService.login(adminUserParam.getUsername(), adminUserParam.getPassword());
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

    @RequestMapping(value = "/deleteUser/{adminId}", method = RequestMethod.POST)
    @ApiOperation(value = "删除指定用户")
    public ResponseResult deleteUserByUserId(@PathVariable Long adminId) {
       int count = adminUserService.deleteUserByUserId(adminId);
       if (count > 0) {
           return ResponseResult.success(count, "删除用户成功");
       }
       return ResponseResult.failed(count, "删除用户失败");
    }

    @RequestMapping(value = "/updateUser/{adminId}", method = RequestMethod.POST)
    @ApiOperation(value = "更新用户")
    public ResponseResult updateUser(@PathVariable Long adminId, @RequestBody LddAdminUser adminUser) {
       int count = adminUserService.updateUser(adminId, adminUser);
        if (count > 0) {
            return ResponseResult.success(count, "更新用户成功");
        }
        return ResponseResult.failed(count, "更新用户失败");
    }

    //@RequestMapping(value = "/searchByUsername", method = RequestMethod.POST)
    //@ApiOperation(value = "查找用户")
    //public ResponseResult searchByUsername(String username) {
    //
    //}

}
