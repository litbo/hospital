package com.litbo.hospital.security.bean;

import lombok.Data;

import java.util.Date;
@Data
public class FwLcjl {
    public  FwLcjl(){

    }
    public FwLcjl(String userId, Date creatTime, String bxId, String lc) {
        this.userId = userId;
        this.creatTime = creatTime;
        this.bxId = bxId;
        this.lc = lc;
    }

    private Integer id;

    private String userId;

    private Date creatTime;


    private String bxId;

    private String lc;


}