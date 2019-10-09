package com.litbo.hospital.lifemanage.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 账实核对列表VO
 *
 * @author Administrator on 2019-01-04
 */
@Data
public class SgCheckVO {
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
     * 审核日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date date;
    /**
     * 审核人
     */
    private String userId;
    /**
     * 是否存在
     */
    private String checks;
}
