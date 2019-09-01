package com.litbo.hospital.security.inspectionplan.bean.vo;

import lombok.Data;

import java.util.Date;

@Data
public class InspEqPlanChange {
    private String inspPlChangeId;

    private String inspPlId;

    private String inspPlChangeChangePerson;

    private Date inspPlChangeTime;

    private String inspPlChangeReason;

    private String inspPlChangeAuditor;

    private Date inspPlChangeExamineTime;

    private String inspPlChangeExamineOpinion;

    private String spare1;

    private String spare2;

    private String spare3;

    private String spare4;

    private String spare5;

    public String getInspPlChangeId() {
        return inspPlChangeId;
    }

    public void setInspPlChangeId(String inspPlChangeId) {
        this.inspPlChangeId = inspPlChangeId == null ? null : inspPlChangeId.trim();
    }

    public String getInspPlId() {
        return inspPlId;
    }

    public void setInspPlId(String inspPlId) {
        this.inspPlId = inspPlId == null ? null : inspPlId.trim();
    }

    public String getInspPlChangeChangePerson() {
        return inspPlChangeChangePerson;
    }

    public void setInspPlChangeChangePerson(String inspPlChangeChangePerson) {
        this.inspPlChangeChangePerson = inspPlChangeChangePerson == null ? null : inspPlChangeChangePerson.trim();
    }

    public Date getInspPlChangeTime() {
        return inspPlChangeTime;
    }

    public void setInspPlChangeTime(Date inspPlChangeTime) {
        this.inspPlChangeTime = inspPlChangeTime;
    }

    public String getInspPlChangeReason() {
        return inspPlChangeReason;
    }

    public void setInspPlChangeReason(String inspPlChangeReason) {
        this.inspPlChangeReason = inspPlChangeReason;
    }

    public String getInspPlChangeAuditor() {
        return inspPlChangeAuditor;
    }

    public void setInspPlChangeAuditor(String inspPlChangeAuditor) {
        this.inspPlChangeAuditor = inspPlChangeAuditor == null ? null : inspPlChangeAuditor.trim();
    }

    public Date getInspPlChangeExamineTime() {
        return inspPlChangeExamineTime;
    }

    public void setInspPlChangeExamineTime(Date inspPlChangeExamineTime) {
        this.inspPlChangeExamineTime = inspPlChangeExamineTime;
    }

    public String getInspPlChangeExamineOpinion() {
        return inspPlChangeExamineOpinion;
    }

    public void setInspPlChangeExamineOpinion(String inspPlChangeExamineOpinion) {
        this.inspPlChangeExamineOpinion = inspPlChangeExamineOpinion == null ? null : inspPlChangeExamineOpinion.trim();
    }

    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1 == null ? null : spare1.trim();
    }

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2 == null ? null : spare2.trim();
    }

    public String getSpare3() {
        return spare3;
    }

    public void setSpare3(String spare3) {
        this.spare3 = spare3 == null ? null : spare3.trim();
    }

    public String getSpare4() {
        return spare4;
    }

    public void setSpare4(String spare4) {
        this.spare4 = spare4 == null ? null : spare4.trim();
    }

    public String getSpare5() {
        return spare5;
    }

    public void setSpare5(String spare5) {
        this.spare5 = spare5 == null ? null : spare5.trim();
    }
}