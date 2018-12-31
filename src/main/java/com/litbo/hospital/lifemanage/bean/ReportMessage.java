package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

/**
 * 禁忌报停设备信息
 *
 * @author Administrator on 2018-12-17
 */
@Data
public class ReportMessage {
    /**
     * 主键
     */
    private String id;
    /**
     * 设备id
     */
    private String eqId;
}
