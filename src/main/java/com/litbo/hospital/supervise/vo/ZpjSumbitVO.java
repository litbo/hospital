package com.litbo.hospital.supervise.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class ZpjSumbitVO {
    private String gwId;
    private String zdId;
    private String userId;
    private String zpjReason;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String ztDate;
}
