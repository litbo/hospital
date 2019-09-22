package com.litbo.hospital.lifemanage.checkBeforeUse.vo;

import lombok.Data;

@Data
public class SaveStandardTaskResult {
    private Integer taskId;
    private Integer taskResult;
    private String operatorNumber;
}
