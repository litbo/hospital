package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import lombok.Data;

/*查询可调剂设备*/

@Data
public class EqInfoShowVO {

    /*装备主键*/
    private String eqId;

    /*装备编号*/
    private String eqSbbh;

    /*科室id*/
    private String bmId;

    private String eqBmid;
  /*科室名称*/
    private String bmName;

    /*设备名称*/
    private String eqName;

    /*设备规格*/
    private String eqGg;

    /*设备型号*/
    private String eqXh;

    /*规格型号*/
    private String ggxh;

    /*设备院区*/
    private String eqYq;

}
