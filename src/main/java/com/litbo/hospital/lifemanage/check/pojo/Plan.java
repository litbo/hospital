package com.litbo.hospital.lifemanage.check.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class Plan {
    @Override
    public String toString() {
        return "Plan{" +
                "id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", bm_id='" + bm_id + '\'' +
                ", plan_name='" + plan_name + '\'' +
                ", plan_date=" + plan_date +
                '}';
    }

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

    public Plan() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getBm_id() {
        return bm_id;
    }

    public void setBm_id(String bm_id) {
        this.bm_id = bm_id;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public Date getPlan_date() {
        return plan_date;
    }

    public void setPlan_date(Date plan_date) {
        this.plan_date = plan_date;
    }

    public Plan(String id, String user_id, String bm_id, String plan_name, Date plan_date) {
        this.id = id;
        this.user_id = user_id;
        this.bm_id = bm_id;
        this.plan_name = plan_name;
        this.plan_date = plan_date;
    }
}