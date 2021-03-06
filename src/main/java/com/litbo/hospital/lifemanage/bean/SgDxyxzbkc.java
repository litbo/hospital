package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.util.Date;

/**
 * 大型医学装备考察报告表实体类
 */
@Data
public class SgDxyxzbkc {
    /**
     * 主键
     */
    private String dxzbId;

    /**
     * 申购单id
     */
    private String sgId;
    /**
     * 时间
     */
    private Date dxzbSj;
    /**
     * 扩展一
     */
    private String extendOne;
    /**
     * 扩展二
     */
    private String extendTwo;
    /**
     * 考察地点及内容
     */
    private String dxzbDdnr;
    /**
     * 结论意见
     */
    private String dxzbYj;
}