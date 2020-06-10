package com.ldd.model;

import java.io.Serializable;
import java.util.Date;

public class LddAdminUser implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     * 角色id
     *
     * @mbg.generated
     */
    private Long roleId;

    /**
     * 用户名
     *
     * @mbg.generated
     */
    private String username;

    /**
     * md5加密密码串
     *
     * @mbg.generated
     */
    private String password;

    /**
     * 用户头像路径
     *
     * @mbg.generated
     */
    private String logo;

    /**
     * 手机号
     *
     * @mbg.generated
     */
    private String phone;

    /**
     * 邮箱
     *
     * @mbg.generated
     */
    private String email;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 最后登录时间
     *
     * @mbg.generated
     */
    private Date loginTime;

    /**
     * 状态，0-禁用，1-正常
     *
     * @mbg.generated
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", roleId=").append(roleId);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", logo=").append(logo);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", createTime=").append(createTime);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}