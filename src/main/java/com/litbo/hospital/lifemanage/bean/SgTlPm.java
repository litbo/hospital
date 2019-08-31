package com.litbo.hospital.lifemanage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

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
    private String eqPmId;
    /**
     * 科室讨论时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date kstlSj;
}