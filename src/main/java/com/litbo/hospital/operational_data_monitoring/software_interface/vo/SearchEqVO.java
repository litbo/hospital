package com.litbo.hospital.operational_data_monitoring.software_interface.vo;

import lombok.Data;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.looli.VO
 * @Author: looli
 * @CreateTime: 2019-07-21 11:20
 * @Description: todo
 */
@Data
public class SearchEqVO {
    /**资产编号*/
    private String eqZcbh;

    /**部门id*/
    private String bmId;

    /**设备拼音码*/
    private String eqPym;

    /**设备编号*/
    private String eqSbbh;

    /**联网仪编号*/
    private String macid;
}
