package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class EqTjKaoPingVO {


    /*编号*/
    private String id;

    /*调配时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dpsj;

    /*调配数量*/
    private int dpcount;

    /*指挥长*/
    private String zhz;



}
