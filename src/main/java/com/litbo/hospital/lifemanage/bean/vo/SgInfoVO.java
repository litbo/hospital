package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 申购单表VO
 */
@Data
public class SgInfoVO {
    /**
     * 申购单id
     */
    private String id;
    /**
     * 部门id 关联s_bm表
     */
    private String bmId;
    /**
     * 申购单编号
     */
    private String bh;
    /**
     * 品名表主键id
     */
    private String eqPmId;
    /**
     * 托管科室id
     */
    private String tgBmId;
    /**
     * 购置类别表id
     */
    private Integer gzlbId;
    /**
     * 资金来源表id
     */
    private Integer zjlyId;
    /**
     * 使用性质表id
     */
    private Integer syxzId;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 外地收费价格
     */
    private BigDecimal priceWd;
    /**
     * 省内收费价格
     */
    private BigDecimal priceSn;
    /**
     * 估价(元)
     */
    private BigDecimal priceGjY;
    /**
     * 估价(美元)
     */
    private BigDecimal priceGjMy;
    /**
     * 检测量/日
     */
    private String jcl;
    /**
     * 购置理由
     */
    private String gzll;
    /**
     * 详细用途
     */
    private String xxyt;
    /**
     * 目的用途
     */
    private String mdyt;
    /**
     * 目前教学/科研/临床应用情况
     */
    private String jxkylcqk;
    /**
     * 基本参数要求
     */
    private String jbcsyq;
    /**
     * 配置详细需求
     */
    private String pzxq;
    /**
     * 设计使用率
     */
    private String syl;
    /**
     * 申购单对应的参考设备商列表
     */
    private List<SgCkcssbVO> sgCkcssbVOs;
}
