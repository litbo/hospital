package com.litbo.hospital.security.inspectionplan.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class InspPlanSelectVo1 {

    private String inspPlId;

    private String inspPlName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inspPlPlanExecuteTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inspPlLastTime;

    private String inspPlPlanner;

    private String inspPlAuditor;

    private String inspPlStatus;

}
