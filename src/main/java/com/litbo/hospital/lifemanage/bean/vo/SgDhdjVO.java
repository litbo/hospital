package com.litbo.hospital.lifemanage.bean.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.litbo.hospital.lifemanage.bean.SgDjhw;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 到货登记表实体类
 * @author Administrator
 */
@Data
public class SgDhdjVO {

    /**到货登记id*/
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
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
     * 登记货物列表
     */
    private List<SgDjhw> sgDjhws=new ArrayList<>();
}