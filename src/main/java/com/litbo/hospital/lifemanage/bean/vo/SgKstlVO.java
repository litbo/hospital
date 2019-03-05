package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 科室讨论表实体类
 */
@Data
public class SgKstlVO {
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
    /**
     * 科室讨论参与人员
     */
    List<String> usersId;
    /**
     * 讨论的品名列表
     */
    List<String> pmsId;
}