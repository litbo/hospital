package com.litbo.hospital.supervise.vo;

import lombok.Data;

@Data
public class BmSelectVO {
    private Integer flag;
    private String bmName;   //科室名称关键词
    private String bmlb;    //科室类别
    private String gklb;    //归口类别
    private Integer isWx;   //是否维修


}
