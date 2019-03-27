package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author zjc
 * @create 2019-02-21 13:39
 */
@ToString
@Getter
@Setter
public class HtVo {

    private String id;

    private String fkHtbh;

    private String htName;

    private BigDecimal htPrice;

    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date htTime;

    private String sbcsName;

    private Integer htStatus;

    private String htStatusString;

    private Integer htZffs;

    private String fkzs; //总付款数

    private String fkcs; //付款数


    public HtVo(String id, String htName, BigDecimal htPrice, Timestamp htTime, String sbcsName, Integer htStatus) {
        this.id = id;
        this.htName = htName;
        this.htPrice = htPrice;
        this.htTime = htTime;
        this.sbcsName = sbcsName;
        this.htStatus = htStatus;
        if(htStatus == 0){
            this.htStatusString = "未支付";
        }else if (htStatus == 1){
            this.htStatusString = "已支付";
        }else{
            this.htStatusString = "支付错误";
        }
    }

    public HtVo(String id, String htName, BigDecimal htPrice, Timestamp htTime, Integer htZffs ,String sbcsName) {
        this.id = id;
        this.htName = htName;
        this.htPrice = htPrice;
        this.htTime = htTime;
        this.htZffs = htZffs;
        this.sbcsName = sbcsName;
        if(htZffs == 1){
            this.fkzs = "一次";
        }else if (htZffs == 2){
            this.fkzs = "两次";
        }else if (htZffs == 3){
            this.fkzs = "三次";
        }else{
            this.fkzs = "支付错误";
        }
    }

    public HtVo(String fkHtbh, String htName, Timestamp htTime , BigDecimal htPrice) {
        this.id = fkHtbh;
        this.htName = htName;
        this.htPrice = htPrice;
        this.htTime = htTime;
    }




}
