package com.litbo.hospital.supervise.vo;

import lombok.Data;

@Data
public class BmSelectVO {
    private Integer flag;
    private String bmName;   //部门名称关键词
    private String bmlb;    //部门类别
    private String gklb;    //归口类别
    private String isWx;   //是否维修


}
