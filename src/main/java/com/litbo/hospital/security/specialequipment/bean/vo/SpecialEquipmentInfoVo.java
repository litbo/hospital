package com.litbo.hospital.security.specialequipment.bean.vo;

import lombok.Data;

@Data
public class SpecialEquipmentInfoVo {

    private String speqId;
    //编号
    private String speqBh;
    //名称
    private String speqName;
    //规格型号
    private String speqGgxh;
    //设备单价
    private String speqSpare1;
    //设备类型
    private int speqType;
    //生产厂商
    private String speqScs;
    //科室名称
    private String bmId;
    //院区
    private String speqBz;
    //特种设备状态
    private int speqRun;



}
