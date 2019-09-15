package com.litbo.hospital.lifemanage.checkBeforeUse.vo;

import lombok.Data;

@Data
public class SaveStandardProjectVO {


    /**操作id*/
    private String operationId;

    /**项目id*/
    private String projectId;

    public SaveStandardProjectVO(String operationId, String projectId) {
        this.operationId = operationId;
        this.projectId = projectId;
    }

    public SaveStandardProjectVO() {
    }
}
