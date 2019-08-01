package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO;

import lombok.Data;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.looli.VO
 * @Author: looli
 * @CreateTime: 2019-07-20 16:11
 * @Description: 设备联网设置显示信息
 */
@Data
public class EqMacVO {
    //来自设备表
    //设备名称
    private String eqName;
    //设备编号
    private String eqSbbh;
    //设备规格
    private String eqGg;
    //设备型号
    private String eqXh;
    //来自设备联网表
    //联网仪编号
    private String macid;
    //联网仪IP
    private String macip;
}
