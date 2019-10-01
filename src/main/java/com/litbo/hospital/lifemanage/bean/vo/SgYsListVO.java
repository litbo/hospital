package com.litbo.hospital.lifemanage.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 商务/临床/技术验收表VO
 */
@Data
public class SgYsListVO {

    /*科室Id*/
    private String bmId;

    /*科室名字*/
    private String bmName;

    /*验收Id*/
    private String ysId;

    /**
     * 登记货物id
     */
    private String djhwId;
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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date dhsj;


}