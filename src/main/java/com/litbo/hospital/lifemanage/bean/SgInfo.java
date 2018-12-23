package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 申购单表实体类
 */
@Data
public class SgInfo {
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
     * 设计使用率
     */
    private String syl;
    /**
     * 科室讨论表id
     */
    private String kstlId;
    /**
     * 准入评价报告表id
     */
    private String pjbgId;
    /**
     * 可行性分析表id
     */
    private String kxfxId;
    /**
     * 大型医学装备考察报告表id
     */
    private String dxzbId;
    /**
     * 论证分析表id
     */
    private String lzfxId;
    /**
     * 是否通过科室审核
     */
    private String iskssh;
    /**
     * 科室审核时间
     */
    private Date ksshsj;
    /**
     * 科室审核人
     */
    private String ksshr;
    /**
     * 科室审核意见
     */
    private String ksshyj;
    /**
     * 是否通过医学工程处审核
     */
    private String isyxgccsh;
    /**
     * 医学工程处审核时间
     */
    private Date yxgccshsj;
    /**
     * 是否通过装备委员会审核
     */
    private String iszbwyhsh;
    /**
     * 装备委员会审批意见
     */
    private String zbwyhyj;
    /**
     * 装备委员会会议表id
     */
    private String zbwyhhyId;
    /**
     * 是否通过院办公会审核
     */
    private String isybghsh;
    /**
     * 院办公会审批意见
     */
    private String ybghyj;
    /**
     * 院办公会会议表id
     */
    private String ybghhyId;
    /**
     * 状态
     */
    private String zt;
    /**
     * 扩展名一
     */
    private String extendOne;
    /**
     * 扩展名二
     */
    private String extendTwo;
    /**
     * 医学工程处意见
     */
    private String yxgccyj;
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
}