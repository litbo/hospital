package com.litbo.hospital.check_before_use.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 樊小铭
 * Date: 2019/9/5 14:29
 * @Version:
 * @Description:
 */
public class EqInfoCheckBeforeUseVo {
    //流水号
    private String eqId;
    //设备名称
    private String eqName;
    //设备编号
    private String eqSbbh;
    //设备规格
    private String eqGg;
    //设备型号
    private String eqXh;
    //部门名称
    private String eqBmName;
    //品牌
    private String eqPp;
    //查询分类name
    private String eqCxflName;

    @Override
    public String toString() {
        return "EqInfoCheckBeforeUseVo{" +
                "eqId='" + eqId + '\'' +
                ", eqName='" + eqName + '\'' +
                ", eqSbbh='" + eqSbbh + '\'' +
                ", eqGg='" + eqGg + '\'' +
                ", eqXh='" + eqXh + '\'' +
                ", eqBmName='" + eqBmName + '\'' +
                ", eqPp='" + eqPp + '\'' +
                ", eqCxflName='" + eqCxflName + '\'' +
                '}';
    }

    public EqInfoCheckBeforeUseVo() {
    }

    public EqInfoCheckBeforeUseVo(String eqId, String eqName, String eqSbbh, String eqGg, String eqXh, String eqBmName, String eqPp, String eqCxflName) {
        this.eqId = eqId;
        this.eqName = eqName;
        this.eqSbbh = eqSbbh;
        this.eqGg = eqGg;
        this.eqXh = eqXh;
        this.eqBmName = eqBmName;
        this.eqPp = eqPp;
        this.eqCxflName = eqCxflName;
    }
}
