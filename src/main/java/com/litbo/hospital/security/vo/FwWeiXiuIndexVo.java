package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

/**
 * FwWeiXiuIndexVo
 *
 * @author Administrator on 2019-03-10
 */
@ToString
@Getter
@Setter
public class FwWeiXiuIndexVo {

    private String fwId;

    private String eqName;

    private String bxrName;

    private String bxrdh;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bxTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date eqBxjssj; //保修结束时间

    private String bxLx ;

    private String bxksdh;

    private Integer jjxStatus; //紧急性

    private String jjxStatusString;

    private String gzxx;

    private String wxrId;

    public FwWeiXiuIndexVo(String fwId, String eqName, String bxrName, String bxrdh, Timestamp bxTime, java.sql.Date eqBxjssj, String bxksdh, Integer jjxStatus, String gzxx) {
        this.fwId = fwId;
        this.eqName = eqName;
        this.bxrName = bxrName;
        this.bxrdh = bxrdh;
        this.bxTime = bxTime;
        this.eqBxjssj = eqBxjssj;
        this.bxksdh = bxksdh;
        this.jjxStatus = jjxStatus;
        this.gzxx = gzxx;
        this.bxLx = "科室故障维修";
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
}
