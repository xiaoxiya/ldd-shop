package com.ldd.xiaoxiya.service;

import com.ldd.model.LddAdminUser;
import com.ldd.model.LddPermissionResource;
import com.ldd.xiaoxiya.dto.LddAdminUserParam;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author xiaoxiya
 * @date 2020/6/14 12:51
 * @describe 后台管理员service
 */
public interface LddAdminUserService {
    /**
     * 注册
     */
    LddAdminUser register(LddAdminUserParam user);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 生成的token
     */
    String login(String username, String password);

    /**
     * 根据用户名获取后台管理员
     */
    LddAdminUser getAdminByUsername(String username);

    /**
     * 获取用户所有权限
     */
    List<LddPermissionResource> getPermissionList(Long adminId);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 删除用户
     */
    int deleteUserByUserId(Long adminId);

    /**
     * 更新用户
     */
    int updateUser(Long adminid, LddAdminUser adminUser);

    /**
     * 根据用户名 模糊搜索
     *
     */
    List<LddAdminUser> getUserInfoList(String username, Integer pageSize, Integer pageNum);
}
