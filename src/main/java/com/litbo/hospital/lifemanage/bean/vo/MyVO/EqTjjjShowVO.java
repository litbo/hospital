package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class EqTjjjShowVO {

    /*主键*/
    private String id;

   private String  tjjjJllx;
    /*调入科室*/
    private String tjjjDrks;
    private String tjjjDrksName;
    /*调配日期*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tjjjTprq;

    /*调出科室*/
    private String tjjjDcks;

    private String tjjjDcksName;

    /*查询起始时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tjjjQssj;

    /*查询结束时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tjjjJssj;

    /*调入经办人*/
    private String tjjjDrjbr;

    /*调出经办人*/
    private String tjjjDcjbr;

    /*是否全部归还*/
    private String eqSfqbgh;

}
