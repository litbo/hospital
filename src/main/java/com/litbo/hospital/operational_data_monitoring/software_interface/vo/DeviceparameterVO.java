package com.litbo.hospital.operational_data_monitoring.software_interface.vo;

import lombok.Data;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.vo
 * @Author: looli
 * @CreateTime: 2019-07-30 17:37
 * @Description: todo
 */
@Data
public class DeviceparameterVO {
    /**设备编号*/
    private String deviceCode;
    /**终端ip*/
    private String endPointIP;
    /**设备名称*/
    private String eqName;
    /**设备编号*/
    private String eqSbbh;
    /**设备规格*/
    private String eqGg;
    /**设备型号*/
    private String eqXh;
    /**有无pacs终端*/
    private String haspacs;
    /**有无工作量记录*/
    private String hasworkbox;
    /**记录规则*/
    private String macrule;
    /**pacs终端编号*/
    private String pmacid;
}