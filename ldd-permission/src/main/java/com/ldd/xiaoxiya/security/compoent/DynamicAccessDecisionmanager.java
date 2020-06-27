package com.ldd.xiaoxiya.security.compoent;

import cn.hutool.core.collection.CollUtil;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author xiaoxiya
 * @date 2020/6/12 22:58
 * @describe 动态权限决策管理器，用于判断用户是否有访问权限
 * AccessDecisionManager是用于访问控制的，它决定用户是否可以访问某个资源，实现这个接口可以定制我们自己的授权逻辑
 */
public class DynamicAccessDecisionmanager implements AccessDecisionManager {
    /**
     * 权限校验方法
     * 通过传递的参数来决定用户是否有访问对应受保护对象的权限
     * @param authentication 包含了当前的用户信息，包括拥有的权限
     * 这里的权限来源就是前面登录时UserDetailsService中设置的authorities。
     * @param o 就是FilterInvocation对象，可以得到request等web资源
     * @param configAttributes 本次访问需要的权限
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        //接口未被配置资源时直接放行
        if (CollUtil.isEmpty(configAttributes)) {
            return;
        }
        Iterator<ConfigAttribute> iterator = configAttributes.iterator();
        while (iterator.hasNext()) {
            ConfigAttribute configAttribute = iterator.next();
            //将访问所需资源或用户拥有资源进行对比
            String needAuthority = configAttribute.getAttribute();
            for (GrantedAuthority grandtedAuthority : authentication.getAuthorities()) {
                if (needAuthority.trim().equals(grandtedAuthority.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("抱歉，您没有访问权限");
    }

    /**
     * 表示此AccessDecisionManager是否能够处理传递的ConfigAttribute呈现的授权请求
     * @param configAttribute
     * @return
     */
    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    /**
     * 表示当前AccessDecisionManager实现是否能够为指定的安全对象（方法调用或Web请求）提供访问控制决策
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
