package com.litbo.hospital.user.vo;

import lombok.Data;

import java.util.ArrayList;

@Data
public class SetRolesVo {

    private ArrayList<String> userIds;
    private String roleId;
}