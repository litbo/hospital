package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

/**
 * 报废字典实体
 */
@Data
public class SgScrappedDict {
    /**
     * 报废原因id
     */
    private Integer reasonId;

    /**
     * 报废原因
     */
    private String reasonName;
}