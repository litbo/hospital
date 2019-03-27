package com.litbo.hospital.supervise.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ZZSelectAsBaseShMsg {
    private Integer gwId;    //制度编号
    private String gwName;  // 制度名称
    private String ztCzname;    //制度状态操作名称
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;

}
