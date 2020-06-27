package com.ldd.xiaoxiya.config;

import com.ldd.model.LddPermissionResource;
import com.ldd.xiaoxiya.security.compoent.DynamicSecurityService;
import com.ldd.xiaoxiya.security.config.SecurityConfig;
import com.ldd.xiaoxiya.service.LddAdminUserService;
import com.ldd.xiaoxiya.service.LddPermissionResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaoxiya
 * @date 2020/6/14 17:51
 * @describe security设置
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class LddSecurityConfig extends SecurityConfig {

    @Autowired
    @Qualifier("lddAdminUserServiceImpl")
    private LddAdminUserService adminUserService;

    @Autowired
    @Qualifier("lddPermissionResourceServiceImpl")
    private LddPermissionResourceService permissionResourceService;

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> adminUserService.loadUserByUsername(username);
    }

    /**
     * 初始化 所有资源 对应的角色
     * @return
     */
    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<LddPermissionResource> resourceList = permissionResourceService.getAllList();
                for (LddPermissionResource resource : resourceList) {
                    map.put(resource.getPermissionUrl(), new org.springframework.security.access.SecurityConfig(resource.getPermissionId() + ":" + resource.getPermissionName()));
                }
                return map;
            }
        };
    }
}
