package com.litbo.hospital.lifemanage.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date dhsj;
}