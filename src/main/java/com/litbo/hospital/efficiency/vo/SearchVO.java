package com.litbo.hospital.efficiency.vo;

import lombok.Data;

/**
 * description: 查询的VO
 * @author: sz
 * @date: 2019/8/25 15:35
 */
@Data
public class SearchVO {

    /** 查询开始时间 */
    private String startSTime;

    /** 查询的结束时间 */
    private String endSTime;

    /** 查询科室的名字 */
    private String bmSName;

    /** 查询设备的名字 */
    private String eqSName;

    /** 查询的效率等级 */
    private String searchLevel;

}
