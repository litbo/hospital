package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 申购设备公示查询的VO
 */
@Data
public class SgInfoListVO {
    /**
     * 申购单id
     */
    private String id;
    /**
     * 申购部门名字
     */
    private String bmName;
    /**
     * 申购编号
     */
    private String bh;
    /**
     * 设备名称
     */
    private String eqPmName;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 估价(元)
     */
    private BigDecimal priceGjY;
    /**
     * 状态
     */
    private String zt;
    /**
     * 未通过原因
     */
    private String reason;
    /**
     * 科室讨论表id
     */
    private String kstlId;
    /**
     * 准入评价报告表id
     */
    private String pjbgId;
    /**
     * 可行性分析表id
     */
    private String kxfxId;
    /**
     * 大型医学装备考察报告表id
     */
    private String dxzbId;
    /**
     * 论证分析表id
     */
    private String lzfxId;
    /**
     * 装备委员会会议表id
     */
    private String zbwyhhyId;
    /**
     * 院办公会会议表id
     */
    private String ybghhyId;
}
