package com.litbo.hospital.user.bean;

import lombok.Data;

import java.util.Date;

/**
*
* 作息时间
* @author : ljl
**/
@Data
public class SysZxsj {
    private Integer id;

    private Date amSbsj;

    private Date amXbsj;

    private Date pmSbsj;

    private Date pmXbsj;

    private Date ybSbsj;

    private Date ybXbsj;


}