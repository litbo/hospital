package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * @create 2019-06-17 21:32
 */
@ToString
@Getter
@Setter
public class FwBxLcTableVo {

    private String fwId;

    private String eqName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bxTime;

    private Integer jjxStatus;

    private Integer bxStatus;

    private String jjxStatusString;

    private String bxStatusString;


    public FwBxLcTableVo(String fwId, String eqName, Timestamp bxTime, Integer jjxStatus, Integer bxStatus) {
        this.fwId = fwId;
        this.eqName = eqName;
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
        this.bxStatusString = EnumUtils.getByCode(EnumProcess.class,bxStatus).getMessage()+"中";
    }
}
