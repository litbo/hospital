package com.litbo.hospital.lifemanage.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 核对对比列表VO
 *
 * @author Administrator on 2019-01-04
 */
@Data
public class SgCheckListVO {
    /**
     * 审核id
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
     * 设备规格
     */
    private String eqGg;
    /**
     * 设备型号
     */
    private String eqXh;
    /**
     * 制定人
     */
    private String planUser;
    /**
     * 科室id
     */
    private String bmName;
    /**
     * 计划时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date planDate;
    /**
     * 审核日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date date;
    /**
     * 审核人
     */
    private String checkUser;
    /**
     * 是否存在
     */
    private String checks;
}
