package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商务/临床/技术验收表实体类
 */
@Data
public class SgYs {
    /**
     * 主键
     */
    private String ysId;
    /**
     * 档案编号
     */
    private String ysDabh;
    /**
     * 合同id
     */
    private String htId;
    /**
     * 申购单id
     */
    private String sgId;
    /**
     * 资质审核结果
     */
    private String ysZzshjg;
    /**
     * 资质审核人
     */
    private String ysZzshr;
    /**
     * 装箱单
     */
    private String ysZxd;
    /**
     * 说明书
     */
    private String ysSms;
    /**
     * 操作手册
     */
    private String ysCzsc;
    /**
     * 维修手册
     */
    private String ysWxsc;
    /**
     * 其他技术资料
     */
    private String ysQtjszl;
    /**
     * 产品合格证明
     */
    private String ysCphgzm;
    /**
     * 保修卡
     */
    private String ysBxk;
    /**
     * 3c认证
     */
    private String ys3crz;
    /**
     * 计量器具认证
     */
    private String ysJlqjrz;
    /**
     * 报关单
     */
    private String ysBgd;
    /**
     * 检验检疫证明
     */
    private String ysJyjyzm;
    /**
     * 是否是高风险器械
     */
    private String ysIsgfxqx;
    /**
     * 包装标识
     */
    private String ysBzbs;
    /**
     * 标签
     */
    private String ysBq;
    /**
     * 高风险说明书
     */
    private String ysGfxsms;
    /**
     * 合格证明
     */
    private String ysHgzm;
    /**
     * 其他材料
     */
    private String ysQtcl;
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
     * 验收工程师
     */
    private String ysYsgcs;
    /**
     * 厂商工程师
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
     * 使用情况及使用科室意见
     */
    private String ysSyqkyj;
    /**
     * 验收日期
     */
    private Date ysYsrq;
    /**
     * 使用情况及使用科室意见
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
    /**
     * 验收结果
     */
    private String ysYsjg;
    /**
     * 验收确认时间
     */
    private Date ysYsqrsj;
    /**
     * 启用时间
     */
    private Date ysQysj;
    /**
     * 操作规程
     */
    private String ysCzgc;
    /**
     * 注意事项
     */
    private String ysZysx;
    /**
     * 保养制度
     */
    private String ysByzd;
    /**
     * 产品禁忌
     */
    private String ysCpjj;
    /**
     * 质量控制
     */
    private String ysZlkz;
    /**
     * 是否通过验收
     */
    private String ysIstg;
    /**
     * 是否退换货
     */
    private String ysThh;
    /**
     * 退换货时间
     */
    private Date ysThsj;
    /**
     * 退换原因
     */
    private String ysThyy;


    /**
     * 资金来源表id
     */
    private Integer zjlyId;


  /*  登记货物id*/

    private String djhwId;

    /*是否质检*/
    private String ysSfzj;
}