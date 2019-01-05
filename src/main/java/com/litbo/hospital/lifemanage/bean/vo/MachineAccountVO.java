package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

import java.util.Date;

/**
 * 设备台账列表
 *
 * @author Administrator on 2018-12-16
 */
@Data
public class MachineAccountVO {
    /**
     * 设备id
     */
    private String eqId;
    /**
     * 设备编号
     */
    private String eqSbbh;
    /**
     * 设备名称
     */
    private String eqName;
    /**
     * 院内编号  资产编号
     */
    private String eqYq;
    /**
     * 设备规格
     */
    private String eqGg;
    /**
     * 设备型号
     */
    private String eqXh;
    /**
     * 部门id
     */
    private String eqBmid;
    /**
     * 所在科室
     */
    private String eqBmName;
    /**
     * 台账类别
     */
    private String eqTzlb;
    /**
     * 设备启用时间
     */
    private Date eqQysj;
    /**
     * 设备使用年限
     */
    private Integer eqSynx;
    /**
     * 状态
     */
    private String state;
}
