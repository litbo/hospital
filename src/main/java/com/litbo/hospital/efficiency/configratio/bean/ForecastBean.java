package com.litbo.hospital.efficiency.configratio.bean;

import lombok.Data;

/**
 * description: 预测符合率
 * @author: sz
 * @date: 2019/8/9 14:32
 */
@Data
public class ForecastBean {

    private String eqSbbh;

    private String eqName;

    private String actualNum;

    private String forecastNum;

    private Double ratio;

}
