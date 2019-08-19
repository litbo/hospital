package com.litbo.hospital.security.specialequipment.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SpecialEquipmentRecord {
    private String speqJglrid;

    private String speqId;

    private String speqJczbh;

    @DateTimeFormat( pattern = "yyy-MM-dd")
    @JsonFormat( pattern = "yyy-MM-dd")
    private Date speqJcsj;

    private String speqSjsqr;

    @DateTimeFormat( pattern = "yyy-MM-dd")
    @JsonFormat( pattern = "yyy-MM-dd")
    private Date speqSjsqsj;

    private String speqSjspr;

    @DateTimeFormat( pattern = "yyy-MM-dd")
    @JsonFormat( pattern = "yyy-MM-dd")
    private Date speqSjspsj;

    private Integer speqRun;

    private String speqSpare1;

    private String speqSpare2;

    private String speqSpare3;

    private String speqSpare4;

    private String speqSpare5;

    public String getSpeqJglrid() {
        return speqJglrid;
    }

    public void setSpeqJglrid(String speqJglrid) {
        this.speqJglrid = speqJglrid == null ? null : speqJglrid.trim();
    }

    public String getSpeqId() {
        return speqId;
    }

    public void setSpeqId(String speqId) {
        this.speqId = speqId == null ? null : speqId.trim();
    }

    public String getSpeqJczbh() {
        return speqJczbh;
    }

    public void setSpeqJczbh(String speqJczbh) {
        this.speqJczbh = speqJczbh == null ? null : speqJczbh.trim();
    }

    public Date getSpeqJcsj() {
        return speqJcsj;
    }

    public void setSpeqJcsj(Date speqJcsj) {
        this.speqJcsj = speqJcsj;
    }

    public String getSpeqSjsqr() {
        return speqSjsqr;
    }

    public void setSpeqSjsqr(String speqSjsqr) {
        this.speqSjsqr = speqSjsqr == null ? null : speqSjsqr.trim();
    }

    public Date getSpeqSjsqsj() {
        return speqSjsqsj;
    }

    public void setSpeqSjsqsj(Date speqSjsqsj) {
        this.speqSjsqsj = speqSjsqsj;
    }

    public String getSpeqSjspr() {
        return speqSjspr;
    }

    public void setSpeqSjspr(String speqSjspr) {
        this.speqSjspr = speqSjspr == null ? null : speqSjspr.trim();
    }

    public Date getSpeqSjspsj() {
        return speqSjspsj;
    }

    public void setSpeqSjspsj(Date speqSjspsj) {
        this.speqSjspsj = speqSjspsj;
    }

    public Integer getSpeqRun() {
        return speqRun;
    }

    public void setSpeqRun(Integer speqRun) {
        this.speqRun = speqRun;
    }

    public String getSpeqSpare1() {
        return speqSpare1;
    }

    public void setSpeqSpare1(String speqSpare1) {
        this.speqSpare1 = speqSpare1 == null ? null : speqSpare1.trim();
    }

    public String getSpeqSpare2() {
        return speqSpare2;
    }

    public void setSpeqSpare2(String speqSpare2) {
        this.speqSpare2 = speqSpare2 == null ? null : speqSpare2.trim();
    }

    public String getSpeqSpare3() {
        return speqSpare3;
    }

    public void setSpeqSpare3(String speqSpare3) {
        this.speqSpare3 = speqSpare3 == null ? null : speqSpare3.trim();
    }

    public String getSpeqSpare4() {
        return speqSpare4;
    }

    public void setSpeqSpare4(String speqSpare4) {
        this.speqSpare4 = speqSpare4 == null ? null : speqSpare4.trim();
    }

    public String getSpeqSpare5() {
        return speqSpare5;
    }

    public void setSpeqSpare5(String speqSpare5) {
        this.speqSpare5 = speqSpare5 == null ? null : speqSpare5.trim();
    }
}