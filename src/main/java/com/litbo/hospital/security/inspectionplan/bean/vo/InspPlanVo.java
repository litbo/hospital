package com.litbo.hospital.security.inspectionplan.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author 10366 2019-08-12 18:54
 **/
@Data
public class InspPlanVo {

    private String inspPlanId;
    private String inspPlName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inspPlCreateTime;

    private String inspPlPlanner;
    private String inspPlSpare3;

    private String inspPlAuditor;
    private String inspPlSpare4;

    private String inspPlStatus;

    private String inspPlChangeReason;

    private String inspPlNote;


    private String inspPlPeriod;

    private Integer inspPlPeriodicUnit;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inspPlLastTime;

    private String inspPlExecutorType;

    private String inspPlType;

    private ArrayList<InspPlanEquipmentVo> inspPlanEquipmentVos;

}
