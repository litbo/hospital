package com.litbo.hospital.user.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class SysGgVo {

    private Integer id;

    private String gglxName;

    private String url;

    private String bmName;
    private String bmId;
    private Integer gglxId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date kssj;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date jssj;

    private String ggbt;

    private String status;

    private String ggnr;
    @JsonFormat(pattern = "yyyy-MM-dd")
     private Date ngsj;

}

