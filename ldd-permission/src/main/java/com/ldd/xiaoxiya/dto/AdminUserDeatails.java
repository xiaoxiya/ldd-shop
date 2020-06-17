package com.ldd.xiaoxiya.dto;

import com.ldd.model.LddAdminUser;
import com.ldd.model.LddPermissionResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaoxiya
 * @date 2020/6/13 23:46
 * @describe Spring Security自定义用户详情
 *
 */
public class AdminUserDeatails implements UserDetails {

    private LddAdminUser adminUser;

    private List<LddPermissionResource> permissionResourceList;

    public AdminUserDeatails(LddAdminUser adminUser, List<LddPermissionResource> permissionResourceList) {
        this.adminUser = adminUser;
        this.permissionResourceList = permissionResourceList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的角色权限
        return permissionResourceList.stream()
                .map(role -> new SimpleGrantedAuthority(role.getPermissionId() + ":" + role.getPermissionName()))
                .collect(Collectors.toList());

    }

    @Override
    public String getPassword() {
        return adminUser.getPassword();
    }

    @Override
    public String getUsername() {
        return adminUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return adminUser.getStatus().equals(1);
    }
}
