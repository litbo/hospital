package com.litbo.hospital.lifemanage.checkBeforeUse.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BmTaskEqVO {

    private String bmName;

    private String bmId;

    //覆盖设备数
    private Integer totalEqs;

    //执行设备数
    private Integer doneEqs;

    //执行率
    private double enforced;

    //日期
    private LocalDate date;


}
