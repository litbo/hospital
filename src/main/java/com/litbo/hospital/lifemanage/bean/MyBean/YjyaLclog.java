package com.litbo.hospital.lifemanage.bean.MyBean;

import lombok.Data;

import java.util.Date;

/*应急预案流程记录*/
@Data
public class YjyaLclog {
    private String yjyaId;

    private String yjyaBh;

    private String yjyaNgr;

    private Date yjyaNgrq;

    private String yjyaShr;

    private Date yjyaShrq;

    private Date yjyaSykssj;

    private Date yjyaBakssj;

    private Date yjyaQykssj;

    private String yjyaZpjsqr;

    private Date yjyaZpjsqsj;

    private String yjyaZpjshr;

    private Date yjyaZpjshsj;

    }