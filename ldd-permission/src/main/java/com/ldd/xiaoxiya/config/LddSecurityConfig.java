package com.ldd.xiaoxiya.config;

import com.ldd.xiaoxiya.security.compoent.DynamicSecurityService;
import com.ldd.xiaoxiya.security.config.SecurityConfig;
import com.ldd.xiaoxiya.service.LddAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

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

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> adminUserService.loadUserByUsername(username);
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();

                return map;
            }
        };
    }
}
