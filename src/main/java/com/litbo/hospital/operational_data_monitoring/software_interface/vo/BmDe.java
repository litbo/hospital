package com.litbo.hospital.operational_data_monitoring.software_interface.vo;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.vo
 * @Author: looli
 * @CreateTime: 2019-07-31 12:33
 * @Description: todo
 */

import lombok.Data;

/**
 * 科室id 和 手术科室id
 */
@Data
public class BmDe {
    private String deptId;
    private String hisDeptId;
}
