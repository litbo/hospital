package com.litbo.hospital.efficiency.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * description: 空转率
 * @Author: jz
 * @Date: 2019/8/1 16:28
 */
@Data
public class IdlingVO {

    /** 搜索的开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date startSTime;

    /** 搜索的结束时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date endSTime;

    /**搜索的部门名称*/
    private String bmSName;

    /** 搜索设备名称 */
    private String eqSName;

    /**设备编号*/
    private String eqCode;

    /**设备名字*/
    private String eqJc;

    /**开机时间*/
    private String openTimes;

    /** 工作时间 */
    private String workTimes;

    /**待机时间*/
    private String idleTimes;

    /**设备空转率*/
    private String rating;

    /**设备空转率排名*/
    private Integer ranking;

}
