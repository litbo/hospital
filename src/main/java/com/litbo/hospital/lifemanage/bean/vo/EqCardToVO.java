package com.litbo.hospital.lifemanage.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * EqCardToVO 设备卡
 *
 * @author Administrator on 2019-04-11
 */
@Data
@Accessors(chain = true)
public class EqCardToVO {
    /**
     * 设备编号
     */
    private String sbbh;
    /**
     * 技术状态
     */
    private String jszt;
    /**
     * 报修状态
     */
    private String bxzt;
    /**
     * 设备名称
     */
    private String sbmc;
    /**
     * 设备简称
     */
    private String sbjc;
    /**
     * 型号
     */
    private String xh;
    /**
     * 规格
     */
    private String gg;
    /**
     * 使用范围
     */
    private String syfw;
    /**
     * 启用日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date qyrq;
    /**
     * 分类代码
     */
    private String fldm;
    /**
     * 分类名称
     */
    private String flmc;
    /**
     * 分类标准
     */
    private String flbz;
    /**
     * 使用科室
     */
    private String syks;
    /**
     * 保管人
     */
    private String bgr;
    /**
     * 安装位置
     */
    private String azwz;
    /**
     * 风险等级
     */
    private String fxdj;
    /**
     * 管理品目
     */
    private String glpm;
    /**
     * 卷宗编号
     */
    private String jzbh;
    /**
     * 供应商
     */
    private String gys;
    /**
     * 采购日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date cgrq;
    /**
     * 配置
     */
    private String pz;
    /**
     * 附件
     */
    private String fj;
    /**
     * 合同编号
     */
    private String htbh;
    /**
     * 免税批号
     */
    private String msph;
    /**
     * 注册证号
     */
    private String zczh;
    /**
     * 经费来源
     */
    private String jfly;
    /**
     * 取得方式
     */
    private String qdfs;
    /**
     * 安装日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date azrq;
    /**
     * 转入日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date zrrq;
    /**
     * 使用年限
     */
    private String synx;
    /**
     * 生产商
     */
    private String scs;
    /**
     * 生产日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date scrq;
    /**
     * 设备序列号
     */
    private String sbxlh;
    /**
     * 国别
     */
    private String gb;
    /**
     * 维修商
     */
    private String wxs;
    /**
     * 第三方维修商
     */
    private String dsfwxs;
    /**
     * 产地
     */
    private String cd;
    /**
     * 进口产品
     */
    private String jkcp;
}
