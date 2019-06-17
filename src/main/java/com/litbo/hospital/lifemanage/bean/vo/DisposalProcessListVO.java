package com.litbo.hospital.lifemanage.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * DisposalProcessListVO 处置流程信息VO
 *
 * @author Administrator on 2019-03-11
 */
@Data
public class DisposalProcessListVO {
    /**
     * 处置申请id
     */
    private String id;
    /**
     * 设备编号
     */
    private String eqSbbh;
    /**
     * 设备名称
     */
    private String eqName;
    /**
     * 型号
     */
    private String eqXh;
    /**
     * 规格
     */
    private String eqGg;
    /**
     * 采购日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date eqCgrq;
    /**
     * 设备价格
     */
    private String eqPrice;
    /**
     * 院内编号 资产编号
     */
    private String eqZcbh;
    /**
     * 启用日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date eqQysj;
    /**
     * 申报人
     */
    private String userId;
    /**
     * 申报时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date declareTime;
}
