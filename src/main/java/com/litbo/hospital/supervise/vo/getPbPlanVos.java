package com.litbo.hospital.supervise.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class getPbPlanVos {
    private String pbJhid;

    private String bmName;


    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date pbDate;
}
