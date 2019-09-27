package com.litbo.hospital.user.bean;

import lombok.Data;

/**
 * 樊小铭
 * 2019年9月27日
 * 去掉了@Data 标签，将方法实现
 */
public class SRole {

    private String roleId;
    private String roleName;

    @Override
    public String toString() {
        return "SRole{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public SRole() {
    }

    public SRole(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }
}
