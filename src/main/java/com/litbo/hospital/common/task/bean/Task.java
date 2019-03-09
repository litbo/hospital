package com.litbo.hospital.common.task.bean;

import lombok.Data;

import java.util.Date;
@Data
public class Task {
    private Integer taskId;
    private String actionName;
    private String workName;
    private Date creatTime;
    private String status;
    private String url;
    private String jsrId;
    private String other;
}
