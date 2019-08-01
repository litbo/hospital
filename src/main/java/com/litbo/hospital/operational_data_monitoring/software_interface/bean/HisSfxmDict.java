package com.litbo.hospital.operational_data_monitoring.software_interface.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.bean
 * @Author: looli
 * @CreateTime: 2019-07-26 17:57
 * @Description: todo
 */
@Data
public class HisSfxmDict {
    private String SfXmbm;

    private String SfXmmc;

    private String SfUnit;

    private BigDecimal SfPrice;

    private BigDecimal SfInprice;

    private String SfWjbm;

    private String SfType;

    private String SfXmBz;
}
