package com.litbo.hospital.common.task.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(actionName, task.actionName) &&
                Objects.equals(workName, task.workName) &&
                Objects.equals(creatTime, task.creatTime) &&
                Objects.equals(url, task.url) &&
                Objects.equals(other, task.other);
    }

    @Override
    public int hashCode() {
        return Objects.hash( actionName, workName, creatTime, status, url, other);
    }

}
