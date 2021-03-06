package com.litbo.hospital.lifemanage.checkBeforeUse.vo;


import lombok.Data;

@Data
public class EqInfoVO2 {
    /**设备编号*/
    private String eqSbbh;
    /**设备名称*/
    private String eqName;
    /**拼音码*/
    private String eqPym;
    /**科室名称*/
    private String bmName;
    /**品牌*/
    private String eqPp;
    /**设备规格*/
    private String eqGg;
    /**设备型号*/
    private String eqXh;
    /**台账类别*/
    private String eqTzlb;
    /**科室ID*/
    private String bmId;

    /**设备厂商id*/
    private String sbcsIdScs;

}
