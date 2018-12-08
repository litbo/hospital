package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.util.Date;

/**
 * 科室讨论表实体类
 */
@Data
public class SgKstl {
    /**
     * 科室讨论主键id
     */
    private String kstlId;
    /**
     * 记录人id关联员工表id
     */
    private String userIdJl;
    /**
     * 部门id关联部门表id
     */
    private String bmId;
    /**
     * 科室讨论时间
     */
    private Date kstlTime;
    /**
     * 地点
     */
    private String kstlAddr;
    /**
     * 意见
     */
    private String kstlYj;
    /**
     * 内容
     */
    private String kstlContent;
    /**
     * 扩展一
     */
    private String extendOne;
    /**
     * 扩展二
     */
    private String extendTwo;
}