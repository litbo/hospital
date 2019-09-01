package com.litbo.hospital.security.inspectionplan.bean.vo.SelectVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspPlanEquipmentVo;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author 10366 2019-08-12 18:58
 **/

@Data
public class InspPlanProgramVo1 {





    private ArrayList<InspPlanEquipmentVo1> inspPlanEquipmentVos;

}
