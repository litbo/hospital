package com.litbo.hospital.security.inspectionplan.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class InspEqPlanRecord {

    private String inspReId;

    private String inspPlId;

    private String eqSbbh;

    private String inspPlStandardIds;

    private String inspPlStandardResults;

    private String inspPlOtherProblem;

    private String inspPlExecutor;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inspPlExecutorTime;

    private String inspPlBmQz;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date spare1;

    private String spare2;

    private String spare3;

    private String spare4;

    private String spare5;

    private String inspPlPeople;

}