package com.litbo.hospital.security.inspectionplan.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author 10366 2019-08-12 18:58
 **/

@Data
public class InspPlanProgramVo {

    private String inspPlExecutorType;

    private String inspPlType;

    private String inspPlPeriod;

    private Integer inspPlPeriodicUnit;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inspPlLastTime;

    private ArrayList<InspPlanEquipmentVo> inspPlanEquipmentVos;

}
