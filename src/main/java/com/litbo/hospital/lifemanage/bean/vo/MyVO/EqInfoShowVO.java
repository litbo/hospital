package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import lombok.Data;

/*查找可调剂设备*/

@Data
public class EqInfoShowVO {

    /*装备主键*/
    private String eqId;

    /*装备编号*/
    private String eqSbbh;

    /*部门id*/
    private String bmId;

    /*部门名称*/
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
