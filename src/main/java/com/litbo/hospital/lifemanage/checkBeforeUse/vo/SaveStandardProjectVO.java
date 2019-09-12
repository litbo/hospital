package com.litbo.hospital.lifemanage.checkBeforeUse.vo;

import lombok.Data;

@Data
public class SaveStandardProjectVO {
    private String operationId;

    private String projectId;

    public SaveStandardProjectVO(String operationId, String projectId) {
        this.operationId = operationId;
        this.projectId = projectId;
    }

    public SaveStandardProjectVO() {
    }
}
