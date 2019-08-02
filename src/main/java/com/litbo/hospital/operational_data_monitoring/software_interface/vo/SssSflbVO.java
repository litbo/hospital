package com.litbo.hospital.operational_data_monitoring.software_interface.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.vo
 * @Author: looli
 * @CreateTime: 2019-07-27 13:50
 * @Description: todo
 */
@Data
public class SssSflbVO {
    /**病人id*/
    private String sPatID;
    /**病人姓名*/
    private String sBrXm;
    /**病人类型*/
    private String sBrBz;
    /**收费金额*/
    private BigDecimal sXmJe;
    /**状态*/
    private String status;
    /**项目名称*/
    private String SfXmmc;
}
