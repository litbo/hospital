package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean;

import lombok.Data;

/**
 * 设备值班表
 * @author looli
 */
@Data
public class EqDutyTab {
    private String id;

    private String eqMacId;

//    /**值班类型：默认行政班*/
    private String dtype ;

    /**默认不值班*/
    private String w1 = "2";

    private String w2 = "2";

    private String w3 = "2";

    private String w4 = "2";

    private String w5 = "2";

    private String w6 = "2";

    private String w7 = "2";

    private String amW1 = "2";

    private String amW2 = "2";

    private String amW3 = "2";

    private String amW4 = "2";

    private String amW5 = "2";

    private String amW6 = "2";

    private String amW7 = "2";

    private String pmW1 = "2";

    private String pmW2 = "2";

    private String pmW3 = "2";

    private String pmW4 = "2";

    private String pmW5 = "2";

    private String pmW6 = "2";

    private String pmW7 = "2";

    private String fmW1 = "2";

    private String fmW2 = "2";

    private String fmW3 = "2";

    private String fmW4 = "2";

    private String fmW5 = "2";

    private String fmW6 = "2";

    private String fmW7 = "2";
}