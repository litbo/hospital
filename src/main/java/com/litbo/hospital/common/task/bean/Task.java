package com.litbo.hospital.common.task.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class Task {
    private Integer taskId;
    private String actionName;
    private String workName;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date creatTime;
    private String status;
    private String url;
    private String jsrId;
    private String other;
}
