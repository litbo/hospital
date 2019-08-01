package com.litbo.hospital.operational_data_monitoring.software_interface.bean;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author looli
 * 从pacs收费表中查询pacs设备信息
 */
@Data
public class PacsTab {

    private String cMacId;
    private String cMacName;
    private Integer cType;

}