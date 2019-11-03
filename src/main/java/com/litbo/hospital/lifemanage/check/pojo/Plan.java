package com.litbo.hospital.lifemanage.check.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class Plan {
    /*
        * id	主键
    2	user_id	制定人id
    3	bm_id	科室id
    4	plan_name   计划名称
    5	plan_date	计划时间
    */
    private String id;
    private String user_id;
    private String bm_id;
    private String plan_name;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date plan_date;
    private int plan_sum;

    private int yipan_sum;
    private int panying_sum;
    private int pankui_sum;
    private String plan_check;
    private String plan_file;
}