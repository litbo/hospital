package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 论证分析参考型号及报价表实体类
 */
@Data
public class SgLzfxxhbj {
    private String xhbjId;

    private String lzfxId;

    private Integer sbcsId;

    private String xhbjXh;

    private BigDecimal xhbjBj;

    private String extendOne;

    private String extendTwo;

    private String xhbjJszb;
}