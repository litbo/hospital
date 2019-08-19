package com.litbo.hospital.operational_data_monitoring.software_interface.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.vo
 * @Author: looli
 * @CreateTime: 2019-07-27 11:04
 * @Description: todo
 */
@Data
public class HisSflbVO {
    /**病人id*/
    private String hisPatID;
    /**病人姓名*/
    private String hisBrXm;
    /**病人类型*/
    private String hisBrBz;
    /**收费金额*/
    private String hisXmJe;
    /**状态*/
    private String hisstatus;
    /**项目名称*/
    private String SfXmmc;
}
