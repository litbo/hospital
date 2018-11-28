package com.litbo.hospital.common.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginVo {
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    @NotEmpty(message = "密码不能为空")
    private String userPwd;



}
