package com.litbo.hospital.operational_data_monitoring.offline_inventory.vo;

import lombok.Data;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.offline_inventory.vo
 * @Author: looli
 * @CreateTime: 2019-08-04 14:28
 * @Description: 搜索条件对象
 */
@Data
public class SearchVO {
    /**盘点单号*/
    private String cPddh;
    /**审核人*/
    private String cShr;
    /**盘点类型*/
    private String cYwlx;
}
