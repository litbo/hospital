package com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author 10366 2019-08-26 23:48
 **/
@Data
public class InspSelectPlanVo {

    private String inspPlId;

    private String inspPlName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inspPlCreateTime;

    private List<InspSelectPlanEqVo> inspSelectPlanEqVos;

}
