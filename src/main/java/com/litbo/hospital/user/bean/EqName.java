package com.litbo.hospital.user.bean;

import lombok.Data;


@Data
public class EqName {

    //id
    private String id;
    //基类id
    private String cBID;
    //设备名称
    private String cCName;
    //拼音码
    private String cPym;
    //折旧年限
    private int cDepreYears;
    //设备分类id
    private String c_EquType;
    //计量单位id
    private String c_Unit;



}
