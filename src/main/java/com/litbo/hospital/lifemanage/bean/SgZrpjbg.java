package com.litbo.hospital.lifemanage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 准入评价报告表实体类
 */
@Data
public class SgZrpjbg {
    /**
     * 准入评价报考主键
     */
    private String pjbgId;
    /**
     * 申购单id
     */
    private String sgId;
    /**
     * 准入评价报告单位
     */
    private String pjbgDw;
    /**
     * 准入评价报告装备项目
     */
    private String pjbgZbxm;
    /**
     * 准入评价报告部门负责人
     */
    private String pjbgBmfzr;
    /**
     * 准入评价报告制表单位
     */
    private String pjbgZbdw;
    /**
     * 准入评价报告日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date pjbgRq;
    /**
     * 准入评价报告扩展名1
     */
    private String extendOne;
    /**
     * 准入评价报告扩展名2
     */
    private String extendTwo;
}