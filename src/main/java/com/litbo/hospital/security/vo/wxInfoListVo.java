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
 * @create 2019-04-18 21:19
 */
@ToString
@Getter
@Setter
public class wxInfoListVo {

    private String bmName;

    private String eqName;

    private String gzxx;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bxTime;

    private String zxrName;

    private Integer jjxStatus;

    private String jjxStatusString;

    private Integer bxStatus;

    private String bxStatusString;

    public wxInfoListVo(String bmName, String eqName, String gzxx, Timestamp bxTime, String zxrName, Integer jjxStatus, Integer bxStatus) {
        this.bmName = bmName;
        this.eqName = eqName;
        this.gzxx = gzxx;
        this.bxTime = bxTime;
        this.zxrName = zxrName;
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
        if(bxStatus == 2){
            this.bxStatusString = "未受理";
        }else if(bxStatus == 14){
            this.bxStatusString = "院外维修";
        }else{
            this.bxStatusString = "维修中";
        }

    }
}
