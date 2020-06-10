package com.ldd.model;

import java.io.Serializable;
import java.util.Date;

public class LddPermissionResource implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long permissionId;

    /**
     * 资源分类id
     *
     * @mbg.generated
     */
    private Long categoryId;

    /**
     * 权限名称
     *
     * @mbg.generated
     */
    private String permissionName;

    /**
     * 权限url
     *
     * @mbg.generated
     */
    private String permissionUrl;

    /**
     * 描述
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", permissionId=").append(permissionId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", permissionName=").append(permissionName);
        sb.append(", permissionUrl=").append(permissionUrl);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}