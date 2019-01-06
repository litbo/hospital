package com.litbo.hospital.security.vo;

import com.litbo.hospital.common.utils.EnumUtils;
import com.litbo.hospital.security.enums.EnumProcess;
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
@Getter
@Setter
public class BaoXiuRw {

    private String eqId;

    private String fwId;

    private String bmName;

    private String eqName;

    private String userXm;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bxTime;

    private Integer jjxStatus;

    private Integer bxStatus;

    private String jjxStatusString;

    private String baoxiuRw;


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
    }

}
