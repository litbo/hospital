package com.litbo.hospital.lifemanage.check.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Check {
    /*
    *
    * id
eq_id
date
user_id
checks
plan_id
*/


    private String id;
    private String eq_id;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date date;
    private String user_id ;
    private String checks; //状态
    private String plan_id;

    public Check() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEq_id(String eq_id) {
        this.eq_id = eq_id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setChecks(String checks) {
        this.checks = checks;
    }

    public void setPlan_id(String plan_id) {
        this.plan_id = plan_id;
    }

    public String getId() {
        return id;
    }

    public String getEq_id() {
        return eq_id;
    }

    public Date getDate() {
        return date;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getChecks() {
        return checks;
    }

    public String getPlan_id() {
        return plan_id;
    }

    @Override
    public String toString() {
        return "Check{" +

                ", id='" + id + '\'' +
                ", eq_id='" + eq_id + '\'' +
                ", date=" + date +
                ", user_id='" + user_id + '\'' +
                ", checks='" + checks + '\'' +
                ", plan_id='" + plan_id + '\'' +
                '}';
    }
}
