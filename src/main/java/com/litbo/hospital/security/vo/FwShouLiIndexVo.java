package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author zjc
 * @create 2019-03-10 0:55
 */
@ToString
@Getter
@Setter
public class FwShouLiIndexVo {

    private String id; //维修单号

    private String eqName; //报修设备名称

    private String eqGg; //报修设备规格

    private String eqXh; //报修设备型号

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date eqBxjssj; //保修结束时间

    private String eqBxStatus; //保修状态

    private String bmName; //报修部门名字

    private String bxksdh; //报修科室电话

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bxTime; //保修时间

    private String bxLx ;

    private String userXm; //报修人姓名

    private String bxrdh; //用户电话

    private String bxfs; //报修方式

    private Integer jjxStatus; //紧急性

    private String jjxStatusString;

    private String slrId;

    private String slrName;

    public FwShouLiIndexVo(String id, String eqName, String eqGg, String eqXh, java.sql.Date eqBxjssj, String bmName, String bxksdh, Timestamp bxTime, String userXm, String bxrdh, String bxfs, Integer jjxStatus) {
        this.id = id;
        this.eqName = eqName;
        this.eqGg = eqGg;
        this.eqXh = eqXh;
        this.eqBxjssj = eqBxjssj;
        this.bmName = bmName;
        this.bxksdh = bxksdh;
        this.bxTime = bxTime;
        this.userXm = userXm;
        this.bxrdh = bxrdh;
        this.bxfs = bxfs;
        this.jjxStatus = jjxStatus;
        this.bxLx = "科室故障维修";
        if(this.eqBxjssj.before(new Date())){
            this.eqBxStatus = "在保";
        }else{
            this.eqBxStatus = "过保";
        }
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

    /*this.bxLx = "科室故障维修";
        if(this.eqBxjssj.before(new Date())){
            this.eqBxStatus = "在保";
        }else{
            this.eqBxStatus = "过保";
        }
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
        }*/

}
