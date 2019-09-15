package com.litbo.hospital.lifemanage.checkBeforeUse.vo;

import lombok.Data;

@Data
public class SearchStandardProjectVO {

    private String operationId;

    private String projectId;

    private String operationName;

    private String projectName;

    private String typeId;

    private String typeName;





    public SearchStandardProjectVO(String operationId, String projectId) {
        this.operationId = operationId;
        this.projectId = projectId;
    }

    public SearchStandardProjectVO() {
    }
}
