package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

/**
 * SgInfoReasonVO
 *
 * @author Administrator on 2018-12-23
 */
@Data
public class SgInfoReasonVO {
    /**
     * 是否通过科室审核
     */
    private String iskssh;
    /**
     * 科室审核意见
     */
    private String ksshyj;
    /**
     * 是否通过医学工程处审核
     */
    private String isyxgccsh;
    /**
     * 医学工程处审核意见
     */
    private String yxgccshyj;
    /**
     * 是否通过装备委员会审核
     */
    private String iszbwyhsh;
    /**
     * 装备委员会审批意见
     */
    private String zbwyhyj;
    /**
     * 是否通过院办公会审核
     */
    private String isybghsh;
    /**
     * 院办公会审批意见
     */
    private String ybghyj;
}
