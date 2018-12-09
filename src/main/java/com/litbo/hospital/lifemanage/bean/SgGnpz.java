package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

/**
 * 功能配置表实体类
 */
@Data
public class SgGnpz {
    /**
     * 功能配置主键
     */
    private String gnpzId;
    /**
     * 参考厂商设备id
     */
    private String ckcssbId;
    /**
     * 功能配置名称
     */
    private String gnpzMc;
    /**
     * 功能配置描述
     */
    private String gnpzMs;
    /**
     * 功能是否使用 0不使用 1使用
     */
    private String gnpzIssy;
    /**
     * 扩展列1
     */
    private String extendOne;
    /**
     * 扩展列2
     */
    private String extendTwo;
}