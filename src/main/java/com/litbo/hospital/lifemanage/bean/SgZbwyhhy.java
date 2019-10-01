package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.util.Date;

/**
 * 装备委员会会议信息表实体类
 */
@Data
public class SgZbwyhhy {
    /**
     * 主键id
     */
    private String zbwyhhyId;
    /**
     * 申购单id
     */
    private String sgId;
    /**
     * 计划采购年度
     */
    private String zbwyhhyNd;
    /**
     * 参会人员签字
     */
    private String zbwyhhyChry;
    /**
     * 分管领导
     */
    private String zbwyhhyFgld;
    /**
     * 分管领导意见
     */
    private String zbwyhhyFgldyj;
    /**
     * 会议时间
     */
    private Date zbwyhhySj;
    /**
     * 会议地点
     */
    private String zbwyhhyDd;
    /**
     * 主管科室
     */
    private String zbwyhhyZgbm;
    /**
     * 主管科室意见
     */
    private String zbwyhhyZgbmyj;
    /**
     * 会议内容
     */
    private String zbwyhhyNr;
    /**
     * 扩展一
     */
    private String extendOne;
    /**
     * 扩展二
     */
    private String extendTwo;
}