package com.litbo.hospital.security.inspectionplan.bean.vo.SelectVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspPlanProgramVo;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author 10366 2019-08-12 18:54
 **/
@Data
public class InspPlanVo1 {

    private String inspPlanId;

    private String inspPlName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inspPlCreateTime;

    private String inspPlPlanner;

    private String inspPlAuditor;

    private String inspPlStatus;

    private String inspPlNote;

    private String inspPlChangeReason;

    private String inspPlPeriod;

    private Integer inspPlPeriodicUnit;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inspPlLastTime;

    private String inspPlExecutorType;

    private String inspPlType;

    private ArrayList<InspPlanEquipmentVo1> inspPlanEquipmentVo1s;

}
