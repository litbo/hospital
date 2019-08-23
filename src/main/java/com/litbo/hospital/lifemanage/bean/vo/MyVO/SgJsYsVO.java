package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SgJsYsVO {

    /*验收Id*/
    private String ysId;
    /**
     * 使用科室
     */
    private String ysSyks;
    /**
     * 设备型号
     */
    private String ysSbxh;
    /**
     * 国别
     */
    private String ysGb;
    /**
     * 生产厂商
     */
    private String ysSccs;
    /**
     * 产地
     */
    private String ysCd;
    /**
     * 生产日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date ysScrq;
    /**
     * 单价
     */
    private BigDecimal ysDj;
    /**
     * 序列号
     */
    private String ysXlh;
    /**
     * 附件名称型号
     */
    private String ysFjmcxh;
    /**
     * 附件序列号
     */
    private String ysFjxlh;
    /**
     * 验收工程师(可选多个)
     */
    private String ysYsgcs;
    /**
     * 厂商工程师(可选多个)
     */
    private String ysCsgcs;
    /**
     * 联系电话
     */
    private String ysLxdh;
    /**
     * 新购时性能
     */
    private String ysXgsxn;
    /**
     * 验收日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date ysYsrq;
    /**
     * 使用科室负责人
     */
    private String ysSyksfzr;
    /**
     * 科室负责人
     */
    private String ysKsfzr;

    /**
     * 验收记录
     */

    private String ysYsjl;
    /**
     * 管理使用人
     */
    private String ysGlsyr;
}
