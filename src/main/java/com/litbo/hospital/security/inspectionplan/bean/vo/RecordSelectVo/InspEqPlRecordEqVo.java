package com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo;

import lombok.Data;

/**
 * @author 10366 2019-08-26 23:22
 **/
@Data
public class InspEqPlRecordEqVo {

    private String eqSbbh;

    private String qzzp;

    private String[] inspPlStandardIds;

    private String[] inspPlStandardResults;

    private String[] inspPlOtherProblem;

}
