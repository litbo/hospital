package com.litbo.hospital.lifemanage.bean.vo;

import com.litbo.hospital.lifemanage.bean.SgGnpz;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 参考厂商设备VO
 */
@Data
public class SgCkcssbVO implements Serializable {
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
     * 参考厂商对应的功能配置
     */
    private List<SgGnpz> sgGnpzs;
}
