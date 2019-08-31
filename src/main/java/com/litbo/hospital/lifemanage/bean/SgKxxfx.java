package com.litbo.hospital.lifemanage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 可行性分析表实体类
 */
@Data
public class SgKxxfx {
    /**
     * 主键id
     */
    private String kxfxId;

    /**
     * 申购单id
     */
    private String sgId;
    /**
     * 使用日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date kxfxSyrq;
    /**
     * 使用期限 月
     */
    private Integer kxfxSyqx;
    /**
     * 还本期限 月
     */
    private Integer kxfxHbqx;
    /**
     * 收费项目
     */
    private String kxfxSfxm;
    /**
     * 平均每例收费
     */
    private BigDecimal kxfxPjsf;
    /**
     * 预计月使用人次
     */
    private Integer kxfxYjyrc;
    /**
     * 预计月收入总额
     */
    private BigDecimal kxfxYjyze;
    /**
     * 预计卫材月收入
     */
    private BigDecimal kxfxYjwcysr;
    /**
     * 医学设备投资
     */
    private BigDecimal kxfxZxsbtz;
    /**
     * 配套设备设施
     */
    private BigDecimal kxfxPtss;
    /**
     * 月检查维修费
     */
    private BigDecimal kxfxYjcwxfy;
    /**
     * 月材料费用
     */
    private BigDecimal kxfxYclf;
    /**
     * 月设备折旧费
     */
    private BigDecimal kxfxSbzjf;
    /**
     * 月其他折旧费用
     */
    private BigDecimal kxfxQtzjf;
    /**
     * 月人员管理费用
     */
    private BigDecimal kxfxRyglf;
    /**
     * 还本起始期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date kxfxHbqsq;
    /**
     * 还本总月数
     */
    private Integer kxfxHbzys;
    /**
     * 每月还本额 元
     */
    private BigDecimal kxfxMyhb;
    /**
     * 需还本总额 元
     */
    private BigDecimal kxfxXhbze;
    /**
     * 科室负责人
     */
    private String kxfxKsfzr;
    /**
     * 扩展名一
     */
    private String extendOne;
    /**
     * 扩展名二
     */
    private String extendTwo;
    /**
     * 目前情况
     */
    private String kxfxMqqk;
    /**
     * 预期使用情况
     */
    private String kxfxYqqk;
    /**
     * 安装场地
     */
    private String kxfxAzcd;
    /**
     * 配套设施
     */
    private String kxfxPzss;
    /**
     * 技术情况
     */
    private String kxfxJsqk;
    /**
     * 社会效益
     */
    private String kxfxXhxy;
    /**
     * 可行性分析结论
     */
    private String kxfxKxxjl;
    /**
     * 耗材供应情况
     */
    private String kxfxHcgy;
}