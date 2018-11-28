package com.litbo.hospital.security.bean;

import lombok.Data;

import java.util.Date;
@Data
public class FwPjck {
    private Integer id;

    private String userId;

    private String bxId;

    private Integer pjId;

    private Date pjCkTime;

    private Integer pjCkXsl;

    private Integer pjCkLsl;


}