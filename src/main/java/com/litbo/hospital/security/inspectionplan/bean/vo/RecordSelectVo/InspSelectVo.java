package com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 10366 2019-08-27 0:07
 **/
@Data
public class InspSelectVo {

    private String inspPlId;

    private String inspPlName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inspPlCreateTime;

    private String inspPlEqSbbh;

    private String inspPlEqStandards;

}
