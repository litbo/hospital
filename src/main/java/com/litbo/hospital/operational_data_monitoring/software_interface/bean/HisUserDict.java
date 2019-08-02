package com.litbo.hospital.operational_data_monitoring.software_interface.bean;

import lombok.Data;

import java.util.Date;

@Data
public class HisUserDict {
    private String userNO;

    private String deptID;

    private String userName;

    private String userSex;

    private String userAge;

    private String userProf;

    private String userTech;
}