package com.litbo.hospital.user.vo;

import lombok.Data;


public class SelectUserVo {

    private String userId;

    private String roleId;

    private String status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = "%"+userId+"%";
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = "%"+roleId+"%";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = "%"+status+"%";
    }
}
