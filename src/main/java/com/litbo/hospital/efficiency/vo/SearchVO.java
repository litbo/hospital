package com.litbo.hospital.efficiency.vo;

import lombok.Data;

/**
 * description: 搜索的VO
 * @author: sz
 * @date: 2019/8/25 15:35
 */
@Data
public class SearchVO {

    /** 搜索开始时间 */
    private String startSTime;

    /** 搜索的结束时间 */
    private String endSTime;

    /** 搜索科室的名字 */
    private String bmSName;

    /** 搜索设备的名字 */
    private String eqSName;

    /** 搜索的效率等级 */
    private String searchLevel;

}
