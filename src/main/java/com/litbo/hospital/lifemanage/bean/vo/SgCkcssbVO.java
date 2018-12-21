package com.litbo.hospital.lifemanage.bean.vo;

import com.litbo.hospital.lifemanage.bean.SgGnpz;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 参考厂商设备VO
 */
@Data
public class SgCkcssbVO {
    /**
     * 参考厂商设备主键
     */
    private String ckcssbId;
    /**
     * 申购单id
     */
    private String sgId;
    /**
     * 设备厂商id
     */
    private Integer sbcsId;
    /**
     * 型号
     */
    private String ckcssbXh;
    /**
     * 规格
     */
    private String ckcssbGg;
    /**
     * 数量
     */
    private Integer ckcssbSl;
    /**
     * 估价
     */
    private BigDecimal ckcssbGj;
    /**
     * 扩展列1
     */
    private String extendOne;
    /**
     * 扩展列2
     */
    private String extendTwo;
    /**
     * 参考厂商对应的功能配置
     */
    private List<SgGnpz> sgGnpzs;
}
