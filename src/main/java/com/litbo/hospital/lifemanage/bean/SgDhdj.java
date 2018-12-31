package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 到货登记表实体类
 */
@Data
public class SgDhdj {
    /**
     * 到货登记表id
     */
    private String dhdjId;
    /**
     * 收获单位
     */
    private String dhdjShdw;
    /**
     * 发货单位
     */
    private String dhdjFhdw;
    /**
     * 收货人
     */
    private String dhdjShr;
    /**
     * 发货人
     */
    private String dhdjFhr;
    /**
     * 收货人电话
     */
    private String dhdjShrdh;
    /**
     * 发货人电话
     */
    private String dhdjFhrdh;
    /**
     * 目的地
     */
    private String dhdjMdd;
    /**
     * 发货地
     */
    private String dhdjFhd;
    /**
     * 收货人详细地址
     */
    private String dhdjShxxdz;
    /**
     * 发货人详细地址
     */
    private String dhdjFhxxdz;
    /**
     * 到货时间
     */
    private Date dhsj;
    /**
     * 物流公司
     */
    private String dhdjWlgs;
    /**
     * 搬家公司
     */
    private String dhdjBjgs;
    /**
     * 运输单号
     */
    private Integer dhdjYsdh;
    /**
     * 搬运费用
     */
    private BigDecimal dhdjByfy;
    /**
     * 运输方式
     */
    private String dhdjYsfs;
    /**
     * 接收人
     */
    private String dhdjJsr;
    /**
     * 存放地点
     */
    private String dhdjCfdd;
    /**
     * 合同id
     */
    private String htId;
    /**
     * 申购单id
     */
    private String sgId;
    /**
     * 发货箱数
     */
    private Integer dhdjFhxs;
    /**
     * 实到箱数
     */
    private Integer dhdjSdxs;
    /**
     * 残损箱数
     */
    private Integer dhdjCsxs;
    /**
     * 备注
     */
    private String dhdjBz;
    /**
     * 本合同是否全部到货
     */
    private String dhdjIsqbdh;
    /**
     * 扩展一
     */
    private String extendOne;
    /**
     * 扩展二
     */
    private String extendTwo;
}