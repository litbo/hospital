package com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author 10366 2019-08-26 23:16
 **/
@Data
public class InspEqPlRecordVo {

    private String inspReId;

    private String inspPlId;

    private String inspPlExecutor;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inspPlExecutorTime;

    private String inspPlPeople;

    private List<InspEqPlRecordEqVo> inspEqPlRecordEqVos;

}
