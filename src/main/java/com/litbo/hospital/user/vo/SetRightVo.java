package com.litbo.hospital.user.vo;

import lombok.Data;

import java.util.List;
@Data
public class SetRightVo {

    private String roleId;
    private List<String> rightIds;
}
