package com.litbo.hospital.operational_data_monitoring.software_interface.vo;

import lombok.Data;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.vo
 * @Author: looli
 * @CreateTime: 2019-07-27 15:17
 * @Description: todo
 */
@Data
public class XmVO {
    /**项目编号*/
    private String SfXmBm;
    /**收费项目名称*/
    private String SfXmMc;
    /**项目单价*/
    private String SfPrice;
    /**计价单位*/
    private String SfUnit;
}
