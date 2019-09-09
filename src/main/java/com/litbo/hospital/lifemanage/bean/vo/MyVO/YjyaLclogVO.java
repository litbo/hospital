package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*应急预案流程记录*/
@Data
public class YjyaLclogVO {

    private String yjyaBh;
    private String yjyaName;
    private String yjyaNr;
    private String yjyaNgr;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yjyaNgrq;

    private String yjyaShr;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yjyaShrq;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yjyaSykssj;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yjyaBakssj;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yjyaQykssj;
    /*再评价申请人【应急预案再评价申请】*/
    private String yjyaZpjsqr;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    /*再评价申请时间【应急预案再评价申请】*/
    private Date yjyaZpjsqrq;
    /*再评价审核人【再评价审核】*/
    private String yjyaZpjshr;
    /*再评价审核时间【再评价审核】*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yjyaZpjshrq;

    /*审核意见*/
    private String yjyaShyj;

    /*再评价审核意见*/
    private String yjyaZpjyj;
    /*再评价结果*/
    private String yjyaZpjjg;

    /*再评价原因*/
    private String yjyaZpjyy;

    private String yjyaZt;

    private String yjyaZpjjd;


}