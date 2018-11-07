package com.litbo.hospital.common.utils.poi;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.List;

@Data
public class PdfData implements Serializable {
    // 表头
    private List<String> titles;
    // 数据
    private List<?> rows;
    // 标题
    private String name;
}
