package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import lombok.Data;

@Data
public class SgSwYsVO {
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

    /*到货登记id*/
    private String djhwId;

    /*是否质检*/
    private String ysSfzj;
}
