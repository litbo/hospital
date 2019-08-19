package com.litbo.hospital.operational_data_monitoring.software_interface.bean;

import lombok.Data;

/**
 * 两个系统部门关联表
 */
@Data
public class DeparHisSss {
    /**id*/
    private String id;
    /**本系统*/
    private String deptid;
    /**his系统*/
    private String hisDeptid;

    private String sssDeptid;
}