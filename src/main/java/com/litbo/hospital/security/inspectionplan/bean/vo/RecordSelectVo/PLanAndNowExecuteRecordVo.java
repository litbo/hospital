package com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 10366 2019-08-31 10:02
 **/
@Data
public class PLanAndNowExecuteRecordVo {

    private String inspPlId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inspPlExecutorTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date spare1;

    private String spare2;

}