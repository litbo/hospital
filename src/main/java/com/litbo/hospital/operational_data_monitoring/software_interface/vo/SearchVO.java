package com.litbo.hospital.operational_data_monitoring.software_interface.vo;

import lombok.Data;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.vo
 * @Author: looli
 * @CreateTime: 2019-07-27 11:20
 * @Description: 条件
 */
@Data
public class SearchVO {
    /**起始时间*/
    private String beginTime;
    /**病人id*/
    private String patientId;
    /**病人类型*/
    private String patientType;
    /**pacs 设备编号*/
    private String pacsId;

}
