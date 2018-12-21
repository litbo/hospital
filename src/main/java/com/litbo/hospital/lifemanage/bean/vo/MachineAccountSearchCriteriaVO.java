package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

/**
 * 设备台账搜索条件
 *
 * @author Administrator on 2018-12-16
 */
@Data
public class MachineAccountSearchCriteriaVO {
    /**
     * 购置类别
     */
    private String category;
    /**
     * 状态
     */
    private String state;
    /**
     * 部门id
     */
    private String departmentId;
    /**
     * 设备拼音码
     */
    private String equipmentPinyinCode;
    /**
     * 院内编码
     */
    private String departmentCoding;
    /**
     * 设备编码
     */
    private String equipmentNumber;
}
