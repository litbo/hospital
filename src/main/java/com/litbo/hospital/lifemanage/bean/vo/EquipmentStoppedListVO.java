package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

/**
 * 设备报停列表VO
 *
 * @author Administrator on 2018-12-17
 */
@Data
public class EquipmentStoppedListVO {
    /**
     * 设备id
     */
    private String eqId;
    /**
     * 部门id
     */
    private String eqBmId;
    /**
     * 部门名称
     */
    private String bmName;
    /**
     * 设备编号
     */
    private String eqSbbh;
    /**
     * 设备名称
     */
    private String eqName;
    /**
     * 设备规格
     */
    private String eqGg;
    /**
     * 设备型号
     */
    private String eqXh;
}
