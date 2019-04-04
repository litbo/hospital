package com.litbo.hospital.security.vo;

import lombok.Data;

import java.util.Date;
@Data
public class FwBlsjVO {
    private Integer id;
    private String eqName;//设备名称
    private String bmName;//报告科室
    private String bgmc;//报告名称
    private Date bgTime;//报告时间
    private String sjxz;//报告性质
    private String eqGg;//设备规格
    private String sbcsName;//生产商
    private Date eqAzrq;//设备安装时间

}
