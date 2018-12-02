package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

/**
 * 讨论申购设备关联表实体类
 */
@Data
public class SgTlPm {
    /**
     * 科室主键id
     */
    private String kstlId;
    /**
     * 设备品名表id
     */
    private Integer eqPmId;

}