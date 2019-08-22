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

    private String inspPlName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inspPlCreateTime;

    private String inspPlPlanner;

    private String inspPlAuditor;

    private String inspPlStatus;

    private String inspPlNote;

    private ArrayList<InspPlanProgramVo> inspPlanProgramVos;

}
