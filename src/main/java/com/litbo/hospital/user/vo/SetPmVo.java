package com.litbo.hospital.user.vo;

import lombok.Data;

import java.util.List;

@Data
public class SetPmVo {

    private String eqPmId;

    private List<String>  eqIds;
}
