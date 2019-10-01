package com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo;

import lombok.Data;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo
 * @Author: looli
 * @CreateTime: 2019-07-23 10:50
 * @Description: 搜索条件
 */
@Data
public class SearchVO {
    /**科室编号*/
    private String bmId;
    /**品名拼音码*/
    private String pmpym;
    /**状态标识*/
    private String flag;
    /**仪联网编号*/
    private String macid;
    /**起始时间*/
    private String beginTime;
    /**今天*/
    private String Nowadays;
    /**结束时间*/
    private String endTime;
    /**
     * 查看范围
     * 1. 日
     * 2. 月
     * 3. 年
     * */
    private String type;
    /**品名拼音码*/
    private String pym;

    private String date1;

    /**设备编号*/
    private String eqSbbh;

}
