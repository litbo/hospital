package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

import java.util.List;

@Data
public class SgPdVO {
    private String pdCzr;

    private String pdJhid;

    private List<String> pid;

    private List<String> pdScsj;
}