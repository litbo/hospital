package com.litbo.hospital.operational_data_monitoring.software_interface.bean;

import lombok.Data;

/**
 * 设备与医嘱关联表
 */
@Data
public class EqYzTab {
    private Integer id;
    /**设备id*/
    private String eqId;
    /**医嘱编码*/
    private String yzXmBm;
}