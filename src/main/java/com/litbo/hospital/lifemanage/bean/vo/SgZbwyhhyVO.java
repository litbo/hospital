package com.litbo.hospital.lifemanage.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.litbo.hospital.supervise.bean.SEmp;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 装备委员会会议信息表实体类
 */
@Data
public class SgZbwyhhyVO {
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
    @JsonFormat(pattern = "yyyy-MM-dd")
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
     * 装备委员会参加人员姓名
     */
    private List<String> sgZbwyhRys;
    /**
     * 人员信息
     */
    private List<SEmp> users;
    /**
     * 审核人
     */
    private String shr;
    /**
     * 是否通过审核
     */
    private String issh;
    /**
     * 审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date shsj;
    /**
     * 审核意见
     */
    private String shyj;
    /**
     * 审核状态
     */
    private String zt;
    /**
     * 审核申购单列表
     */
    private List<String> ids;
}