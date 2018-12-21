package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 审核表单VO
 */
@Data
public class ShVO {
    /**
     * 审核人
     */
    private String shr;
    /**
     * 是否通过审核
     */
    private String issh;
    /**
     * 审核时间
     */
    private Date shsj;
    /**
     * 审核意见
     */
    private String shyj;
    /**
     * 审核状态
     */
    private String zt;
    /**
     * 审核申购单列表
     */
    private List<String> ids;
}
