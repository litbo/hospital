package com.litbo.hospital.common.utils.poi;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用于生成pdf时的数据封装
 */
@Data
public class PdfData implements Serializable {
    /**
     * 表头
     */
    private List<String> titles;
    /**
     * dpf中的数据
     */
    private List<?> rows;
    /**
     * 文件标题
     */
    private String name;
}
