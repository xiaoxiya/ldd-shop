package com.ldd.xiaoxiya.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @author xiaoxiya
 * @date 2020/6/21 14:24
 * @describe 后台用户登录注册参数
 */
@Getter
@Setter
public class LddAdminUserLoginParam {
    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;
}
