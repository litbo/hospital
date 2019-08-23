package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*改变合同状态中间VO*/
@Data
public class LoginCheckHtStatusVO {

    /*合同id*/
    private String htId;
    /*数量*/
    private Integer count;
    /*验收确认最小日期*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;
}
