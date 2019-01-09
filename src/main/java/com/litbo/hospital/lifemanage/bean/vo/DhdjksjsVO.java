package com.litbo.hospital.lifemanage.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * DhdjksjsVO 到货登记科室接收的返回vo
 *
 * @author Administrator on 2018-12-13
 */
@Data
public class DhdjksjsVO implements Serializable {
    /**
     * 到货登记表id
     */
    private String djhwId;
    /**
     * 合同编号
     */
    private String htId;
    /**
     * 申购单编号
     */
    private String bh;
    /**
     * 发货单位
     */
    private String dhdjFhdw;
    /**
     * 运输单号
     */
    private Integer dhdjYsdh;
    /**
     * 到货时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dhsj;
    /**
     * 存放地点
     */
    private String dhdjCfdd;
    /**
     * 实到箱数
     */
    private Integer dhdjSdxs;
}
