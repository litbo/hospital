package com.litbo.hospital.lifemanage.bean.MyBean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class EqBraz {
    private String id;

    private String brBxid;

    private String brZrmz;

    private String brName;

    private String brJibing;

    private Integer brAge;

    private String brSex;

    private String brJjdy;

    private String brBqgc;

    private String brBqbh;

    private String brYisheng;

    private String brHushi;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date brSj;
}