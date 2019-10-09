package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.litbo.hospital.common.utils.EnumUtils;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.enums.EnumProcess;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author zjc
 * @create 2019-01-03 15:30
 */
@ToString
public class BaoXiuRw {

    private String eqId;

    private String fwId;

    private String bmName;

    private String eqName;

    private String userXm;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bxTime;

    private Integer jjxStatus;

    private Integer bxStatus;

    private Integer wxfStatus;

    private String jjxStatusString;

    private String baoxiuRw;

    private String link;

    public BaoXiuRw() {
    }



    public void setId(String id) {

        this.fwId=id;
    }

    public String getEqId() {
        return eqId;
    }

    public void setEqId(String eqId) {
        this.eqId = eqId;
    }

    public String getFwId() {
        return fwId;
    }

    public void setFwId(String fwId) {
        this.fwId = fwId;
        this.baoxiuRw = bmName+";"+eqName+";"+eqId+";"+ EnumUtils.getByCode(EnumProcess.class,bxStatus).getMessage();
        this.link = "/admin/index/safe/service-management/child/repair-repairs"+this.bxStatus+".html";
    }

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }

    public String getEqName() {
        return eqName;
    }

    public void setEqName(String eqName) {
        this.eqName = eqName;
    }

    public String getUserXm() {
        return userXm;
    }

    public void setUserXm(String userXm) {
        this.userXm = userXm;
    }

    public Date getBxTime() {
        return bxTime;
    }

    public void setBxTime(Date bxTime) {
        this.bxTime = bxTime;
    }

    public Integer getJjxStatus() {
        return jjxStatus;
    }

    public void setJjxStatus(Integer jjxStatus) {
        this.jjxStatus = jjxStatus;
        if(jjxStatus == 1){
            this.jjxStatusString =  "低";
        }
        else if(jjxStatus == 2){
            this.jjxStatusString =  "中";
        }
        else if(jjxStatus == 3){
            this.jjxStatusString =  "高";
        }
        else{
            this.jjxStatusString =  "未知";
        }
    }

    public Integer getBxStatus() {
        return bxStatus;
    }

    public void setBxStatus(Integer bxStatus) {
        this.bxStatus = bxStatus;
    }

    public Integer getWxfStatus() {
        return wxfStatus;
    }

    public void setWxfStatus(Integer wxfStatus) {
        this.wxfStatus = wxfStatus;
        this.baoxiuRw = bmName+";"+eqName+";"+eqId+";维修费申请"+ EnumUtils.getByCode(EnumApplyStatus.class,wxfStatus).getMessage();
        this.link = "/admin/index/safe/service-management/child/repair-CostAudit.html";
    }

    public String getJjxStatusString() {
        return jjxStatusString;
    }

    public void setJjxStatusString(String jjxStatusString) {
        this.jjxStatusString = jjxStatusString;

    }

    public String getBaoxiuRw() {
        return baoxiuRw;
    }

    public void setBaoxiuRw(String baoxiuRw) {
        this.baoxiuRw = baoxiuRw;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public BaoXiuRw(String bmName, String eqName, String userXm, Timestamp bxTime, Integer jjxStatus, String eqId, Integer bxStatus, String fwId) {
        this.eqId = eqId;
        this.fwId = fwId;
        this.bmName = bmName;
        this.eqName = eqName;
        this.userXm = userXm;
        this.bxTime = bxTime;
        this.jjxStatus = jjxStatus;
        this.bxStatus = bxStatus;
        if(jjxStatus == 1){
            this.jjxStatusString =  "低";
        }
        else if(jjxStatus == 2){
            this.jjxStatusString =  "中";
        }
        else if(jjxStatus == 3){
            this.jjxStatusString =  "高";
        }
        else{
            this.jjxStatusString =  "未知";
        }
        this.baoxiuRw = bmName+";"+eqName+";"+eqId+";"+ EnumUtils.getByCode(EnumProcess.class,bxStatus).getMessage();
        this.link = "/admin/index/safe/service-management/child/repair-repairs"+this.bxStatus+".html";
    }
    public BaoXiuRw(String bmName, String eqName, String userXm, Timestamp bxTime, Integer jjxStatus, String eqId,  Integer id,Integer wxfStatus) {
        this.eqId = eqId;
        this.fwId = id.toString();
        this.bmName = bmName;
        this.eqName = eqName;
        this.userXm = userXm;
        this.bxTime = bxTime;
        this.jjxStatus = jjxStatus;
        this.wxfStatus = wxfStatus;
        if(jjxStatus == 1){
            this.jjxStatusString =  "低";
        }
        else if(jjxStatus == 2){
            this.jjxStatusString =  "中";
        }
        else if(jjxStatus == 3){
            this.jjxStatusString =  "高";
        }
        else{
            this.jjxStatusString =  "未知";
        }
        this.baoxiuRw = bmName+";"+eqName+";"+eqId+";维修费申请"+ EnumUtils.getByCode(EnumApplyStatus.class,wxfStatus).getMessage();
        this.link = "/admin/index/safe/service-management/child/repair-CostAudit.html";
    }

}
