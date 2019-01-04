package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

import java.util.Date;

/**
 * 商务/临床/技术验收表VO
 */
@Data
public class SgYsListVO {
    /**
     * 合同id
     */
    private String htId;
    /**
     * 申购单id
     */
    private String sgId;
    /**
     * 箱内设备
     */
    private String djhwXnsb;
    /**
     * 规格
     */
    private String djhwGg;
    /**
     * 型号
     */
    private String djhwXh;
    /**
     * 数量
     */
    private Integer djhwSl;
    /**
     * 到货时间
     */
    private Date dhsj;
}