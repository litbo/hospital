package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class FwPjsgZjbVo {
    private Integer id;

    private Integer pjsgId;

    private String pjName;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date pjRkTime;

    private String sgrName;

    private String shrName;

    private Integer pjsgCount;

    private Double pjsgPrice;

}
