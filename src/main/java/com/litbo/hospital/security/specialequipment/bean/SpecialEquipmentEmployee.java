package com.litbo.hospital.security.specialequipment.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SpecialEquipmentEmployee {
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

    private String speqSpare1;

    private String speqSpare2;

    private String speqSpare3;

    private String speqSpare4;

    private String speqSpare5;

    private String spemZjimage;


}