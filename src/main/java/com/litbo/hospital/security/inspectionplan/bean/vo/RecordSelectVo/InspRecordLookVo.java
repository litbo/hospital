package com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 10366 2019-08-28 10:08
 **/
@Data
public class InspRecordLookVo {

    private String eqSbbh;

    private String eqName;

    private String bmName;

    private String eqXh;

    private String inspPlBmQz;

    private String inspPlExecutor;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inspPlExecutorTime;

    private String inspPlPeople;

    private String[] inspPlStandardNames;

    private String inspPlStandardResults;

    private String inspPlOtherProblem;


}