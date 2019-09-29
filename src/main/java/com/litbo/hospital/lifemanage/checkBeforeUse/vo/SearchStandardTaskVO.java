package com.litbo.hospital.lifemanage.checkBeforeUse.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SearchStandardTaskVO {


    private Integer taskId;
    /**设备编号*/
    private String eqSbbh;

    /**规范名称*/
    private String standardName;

    /**任务结果*/
    private Integer taskResult;

    /**结果名称*/
    private String resultName;

    /**操作id*/
    private String operationId;

    /**操作id*/
    private String operationName;

    /**项目id*/
    private String projectId;

    /**项目名称*/
    private String projectName;

    /**类型名称*/
    private String typeName;

    /**规范id*/
    private Integer standardId;

    /**操作人编码*/
    private String operatorNumber;

    /**操作人姓名*/
    private String userXm;


    /**操作时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date operationDate;

    /**科室名称*/
    private String bmName;


    /**设备名称*/
    private String eqName;


    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;

}
