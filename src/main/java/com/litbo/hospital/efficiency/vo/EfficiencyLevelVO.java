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

    /** 设备编号 */
    private String eqCode;

    /** 设备名字 */
    private String eqName;

    /** 机时利用率 */
    private String eqUsing;

    /** 设备的效率等级 */
    private String efficiencyLevel;

}
