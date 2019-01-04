package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

/**
 * SgDict
 *
 * @author Administrator on 2018-12-11
 */
@Data
public class SgDict {
    /**
     * 申购字典主键
     */
    private String sgDictId;
    /**
     * 论证分析金额设置
     */
    private String lzfxPrice;
    /**
     * 科室讨论人员数量最低限制
     */
    private String sgKstlRySl;
}
