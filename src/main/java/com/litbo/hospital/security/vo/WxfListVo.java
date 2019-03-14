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
 * @create 2019-03-11 21:51
 */
@ToString
@Getter
@Setter
public class WxfListVo {

    private String fwId;

    private String eqName;

    private String bmName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date bxTime;

    private Integer wxfStatus;

    private String wxfStatusString;

    public WxfListVo(String fwId, String eqName, String bmName, Timestamp bxTime, Integer wxfStatus) {
        this.fwId = fwId;
        this.eqName = eqName;
        this.bmName = bmName;
        this.bxTime = bxTime;
        this.wxfStatus = wxfStatus;
        if(wxfStatus == null){
            this.wxfStatusString = "未申请";
        }else if(wxfStatus == 0){
            this.wxfStatusString = "待审核";
        }else if(wxfStatus == 1){
            this.wxfStatusString = "申请完成";
        }else{
            this.wxfStatusString = "错误";
        }
    }
}
