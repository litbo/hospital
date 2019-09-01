package com.litbo.hospital.security.inspectionplan.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 10366 2019-08-28 0:07
 **/
@Data
public class SelectRecordVo {

    private String inspReId;
    private String inspPlName;
    private String eqSbbh;
    private String eqName;
    private String bmName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inspPlExecutorTime;

}