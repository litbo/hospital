package com.litbo.hospital.operational_data_monitoring.software_interface.bean;

import lombok.Data;

/**
 * 设备与pacs设备关联表
 */
@Data
public class EqPacs {
    private Integer id;

    /**设备id*/
    private String eqId;
    /**pacs设备编号*/
    private String pacsId;
}