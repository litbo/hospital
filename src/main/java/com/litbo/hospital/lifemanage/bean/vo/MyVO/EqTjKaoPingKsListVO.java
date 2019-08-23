package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EqTjKaoPingKsListVO {

    /*科室*/
    private String bmid;

    /*装备名称*/
    private String zbmc;

    /*调用数量*/
    private String count;

    /*送达及时数量*/
    private int jscount;

    /*送达及时比例*/
    private BigDecimal jszhanbi;

    /*送达不及时数量*/
    private int bjscount;

    /*送达不及时比例*/
    private BigDecimal bjszhanbi;

    /*未送达数量*/
    private int wscount;

    /*未送达数量占比*/
    private BigDecimal wszhnbi;

    /*考评*/
    private String kaoping;
}
