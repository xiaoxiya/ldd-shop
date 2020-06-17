package com.ldd.xiaoxiya.service.impl;

import com.ldd.dao.LddPermissionUserRelationDao;
import com.ldd.mapper.LddAdminUserMapper;
import com.ldd.model.LddAdminUser;
import com.ldd.model.LddAdminUserExample;
import com.ldd.model.LddPermissionResource;
import com.ldd.xiaoxiya.dto.AdminUserDeatails;
import com.ldd.xiaoxiya.security.util.JWTUtil;
import com.ldd.xiaoxiya.service.LddAdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author xiaoxiya
 * @date 2020/6/14 12:55
 * @describe 后台管理员实现类
 */
@Service
public class LddAdminUserServiceImpl implements LddAdminUserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LddAdminUserMapper adminUserDao;

    @Autowired
    private LddPermissionUserRelationDao permissionUserRelationDao;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @Override
    public LddAdminUser register(LddAdminUser user) {
        user.setCreateTime(new Date());
        user.setStatus(1);
        //判断是否重名
        if(getAdminByUsername(user.getUsername()) != null) {
            return null;
        }
        //密码加密
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        adminUserDao.insert(user);
        return user;
    }

    /**
     * 成功登录返回token
     * @param username 用户名
     * @param password 密码
     * @return 生成的toekn
     */
    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                //密码不匹配
                throw new BadCredentialsException("密码不匹配");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            logger.warn("登录异常：{}" , e.getMessage());
        }
        return token;
    }

    @Override
    public LddAdminUser getAdminByUsername(String username) {
        LddAdminUserExample example = new LddAdminUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<LddAdminUser> adminUserList = adminUserDao.selectByExample(example);
        if (adminUserList != null && adminUserList.size() >0) {
            return adminUserList.get(0);
        }
        return null;
    }

    /**
     * 根据用户id获取权限
     * @param adminUserId 后台管理员用户id
     * @return 管理员对应的权限id
     */
    @Override
    public List<LddPermissionResource> getPermissionList(Long adminUserId) {
        //用户对应角色->角色对应的权限
        return permissionUserRelationDao.getUserPermission(adminUserId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        //获取用户信息
        LddAdminUser adminUser = getAdminByUsername(username);
        if (adminUser != null) {
            //获取用户对应的权限
            List<LddPermissionResource> roleUsers = getPermissionList(adminUser.getUserId());
            return new AdminUserDeatails(adminUser, roleUsers);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }
}
