package com.litbo.hospital.user.vo;

import lombok.Data;

@Data
public class UserVo {

    private String userId;

    private String name;

    private String roleName;

    private String bmId;

    private String bmName;

    private Integer status;
}
