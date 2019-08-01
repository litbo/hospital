package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO;

import lombok.Data;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.looli.VO
 * @Author: looli
 * @CreateTime: 2019-07-20 17:15
 * @Description: 设备值班显示对象
 */
@Data
public class EqDutyVO {
    //设备值班id
    private String id;

    //设备表
    //设备名称
    private String eqName;
    //设备编号
    private String eqSbbh;
    //设备简称表
    //设备简称
    private String cAName;
    //来自设备值班类型表
    //设备值班类型名
    private String cDTypeName;
    private String w1;

    private String w2;

    private String w3;

    private String w4;

    private String w5;

    private String w6;

    private String w7;

    private String amW1 ;

    private String amW2 ;

    private String amW3 ;

    private String amW4 ;

    private String amW5 ;

    private String amW6 ;

    private String amW7 ;

    private String pmW1 ;

    private String pmW2 ;

    private String pmW3 ;

    private String pmW4 ;

    private String pmW5 ;

    private String pmW6 ;

    private String pmW7 ;

    private String fmW1 ;

    private String fmW2 ;

    private String fmW3 ;

    private String fmW4 ;

    private String fmW5 ;

    private String fmW6 ;

    private String fmW7 ;
}
