package com.litbo.hospital.security.specialequipment.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SpecialEquipmentEmployeeVo {


    private String userId;

    private String userXm;

    private String bmName;

    private String spemSgzzfw;

    private String spemZczh;

    @DateTimeFormat( pattern = "yyy-MM-dd")
    @JsonFormat( pattern = "yyy-MM-dd")
    private Date spemQfrq;

    @DateTimeFormat( pattern = "yyy-MM-dd")
    @JsonFormat( pattern = "yyy-MM-dd")
    private Date spemYxqsq;

    @DateTimeFormat( pattern = "yyy-MM-dd")
    @JsonFormat( pattern = "yyy-MM-dd")
    private Date spemYxjsq;

    private String spemDabh;

    private String spemFzjg;

    private String spemZjimage;

    private String speqSpare1;

}
