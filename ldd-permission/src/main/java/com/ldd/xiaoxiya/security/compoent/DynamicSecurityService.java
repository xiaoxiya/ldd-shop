package com.ldd.xiaoxiya.security.compoent;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * @author xiaoxiya
 * @date 2020/6/12 22:12
 * @describe 动态权限相关业务类
 */
public interface DynamicSecurityService {
    /**
     * 加载资源权限ANT通配符和资源对应的MAP
     * @return
     */
    Map<String, ConfigAttribute> loadDataSource();
}
