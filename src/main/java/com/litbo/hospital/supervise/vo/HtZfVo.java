package com.litbo.hospital.supervise.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zjc
 * @create 2019-03-05 22:25
 */
@Data
public class HtZfVo {

    private String id;

    private String htName;

    private BigDecimal htPrice;

    private BigDecimal fkPrice1;

    private BigDecimal fkPrice2;

    private BigDecimal fkPrice3;
}
