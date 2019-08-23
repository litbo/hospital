package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import lombok.Data;

import java.math.BigDecimal;

/*装备列表*/
@Data
public class EqHtZbVO {
    /*医学装备名称*/
    private String htZbmc;

    /*规格型号*/
    private String htGgxh;

    /*品牌*/
    private String htPinpai;

    /*原产地*/
    private String htYcd;

    /*单位*/
    private String htDanwei;

    /*数量*/
    private Integer htCount;

    /*单价*/
    private BigDecimal htDanjia;

    /*总价*/
    private BigDecimal htZongjia;
   
}
