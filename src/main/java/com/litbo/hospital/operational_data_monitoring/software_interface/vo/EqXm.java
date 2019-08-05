package com.litbo.hospital.operational_data_monitoring.software_interface.vo;

import lombok.Data;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.vo
 * @Author: looli
 * @CreateTime: 2019-08-04 10:34
 * @Description: todo
 */
@Data
public class EqXm {
    private String eqName;
    /**收费项目名称*/
    private String SfXmMc;

    private String bmName;

    private String SfPrice;

    private String SfUnit;

    private String eqId;
    private String id;
}
