package com.litbo.hospital.efficiency.vo;

import lombok.Data;

/**
 *  设备完好率
 */
@Data
public class IntegrityVO {

    /**设备名字*/
    private String eqName;

    /**设备完好数量*/
    private Integer usingNums;

    /**设备总数量*/
    private Integer eqNums;

    /**设备完好率*/
    private String rating;

    /**设备排名*/
    private Integer ranking;
}
