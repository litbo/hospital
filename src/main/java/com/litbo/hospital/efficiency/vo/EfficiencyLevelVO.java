package com.litbo.hospital.efficiency.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * description: 效率等级
 * @author: sz
 * @date: 2019/8/5 10:27
 */
@Data
public class EfficiencyLevelVO {

    /** 搜索的开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date startTime;

    /** 搜索的结束时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date endTime;

    /** 搜索的效率等级 */
    private String searchLevel;

    /** 搜索的部门名字 */
    private String searchBmName;

    /** 设备编号 */
    private String eqCode;

    /** 设备名字 */
    private String eqName;

    /** 机时利用率 */
    private String eqUsing;

    /** 设备的效率等级 */
    private String efficiencyLevel;

}
