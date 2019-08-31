package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import lombok.Data;

import java.math.BigDecimal;

/*零配件列表*/

@Data
public class EqLpjHtZbVO {

    /*配件名称(配件可以购买多个)*/
    private String htPjmc;

    /*规格型号*/
    private String htGgxh;

    /*数量*/
    private Integer htCount;

    /*报价*/
    private BigDecimal htBj;

    /*优惠价*/
    private BigDecimal htYhj;

    /*总价*/
    private BigDecimal htZj;

}
