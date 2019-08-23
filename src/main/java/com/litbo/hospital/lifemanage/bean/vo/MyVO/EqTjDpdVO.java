package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/*调配单Show VO*/
@Data
public class EqTjDpdVO {

    /*调配单号*/
    private String id;

    /*调配时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String tjDpsj;

    /*调剂指挥长*/
    private String tjZhz;

    /*调剂科室名称*/
    private String bmName;

    /*调剂送达科室名称*/
    private String zbSdks;


}
