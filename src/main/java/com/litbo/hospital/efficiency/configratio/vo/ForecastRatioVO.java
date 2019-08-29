package com.litbo.hospital.efficiency.configratio.vo;

import lombok.Data;

/**
 * description: 预测符合率
 * @author: sz
 * @date: 2019/8/9 15:00
 */
@Data
public class ForecastRatioVO {

    private Integer id;

    private String eqSbbh;

    private String eqName;

    private String actualNum;

    private String forecastNum;

    private String ratio;

}
