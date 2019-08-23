package com.litbo.hospital.security.inspectionplan.bean;

import lombok.Data;

import java.util.Date;

@Data
public class InspEqPlan extends InspEqPlanKey {

    private String inspPlName;

    private Date inspPlCreateTime;

    private String inspPlPlanner;

    private String inspPlAuditor;

    private String inspPlNote;

    private String inspPlStatus;

    private String inspPlExecutorType;

    private String inspPlType;

    private String inspPlPeriod;

    private Integer inspPlPeriodicUnit;

    private Date inspPlLastTime;

    private String inspPlChangeReason;

    private Date inspPlPlanExecuteTime;

    private String inspPlEqStandards;

    private String inspPlSprare1;

    private String inspPlSprare2;

    private String inspPlSprare3;

    private String inspPlSprare4;

    private String inspPlSprare5;

}