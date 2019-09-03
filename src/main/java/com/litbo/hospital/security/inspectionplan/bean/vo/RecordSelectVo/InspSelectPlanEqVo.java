package com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo;

import lombok.Data;

import java.util.List;

/**
 * @author 10366 2019-08-26 23:59
 **/
@Data
public class InspSelectPlanEqVo {

    private String eqSbbh;

    private String eqName;

    private String bmName;

    private String eqXh;

    private String qzzp;

    private List<InspSelectPlanEqStandardsVo> inspSelectPlanEqStandardsVos;

}
