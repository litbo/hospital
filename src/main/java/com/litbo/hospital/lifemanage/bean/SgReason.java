package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

/**
 * 报废原因实体
 */
@Data
public class SgReason {
    /**
     * 处置管理id
     */
    private String lcclId;

    /**
     * 报废原因id
     */
    private String reasonId;
}