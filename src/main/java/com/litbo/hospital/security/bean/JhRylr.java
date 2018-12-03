package com.litbo.hospital.security.bean;

import java.util.Date;

public class JhRylr {
    private Integer id;

    private String jhlrPxgw;

    private Integer jhId;

    private Double jhlrCj;

    private String jhlrSgzmc;

    private String jhlrZjurl;

    private Integer sbId;

    private String jhlrFzdw;

    private Date jhlrFzTime;

    private Date jhlrYxq;

    private String empId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJhlrPxgw() {
        return jhlrPxgw;
    }

    public void setJhlrPxgw(String jhlrPxgw) {
        this.jhlrPxgw = jhlrPxgw == null ? null : jhlrPxgw.trim();
    }

    public Integer getJhId() {
        return jhId;
    }

    public void setJhId(Integer jhId) {
        this.jhId = jhId;
    }

    public Double getJhlrCj() {
        return jhlrCj;
    }

    public void setJhlrCj(Double jhlrCj) {
        this.jhlrCj = jhlrCj;
    }

    public String getJhlrSgzmc() {
        return jhlrSgzmc;
    }

    public void setJhlrSgzmc(String jhlrSgzmc) {
        this.jhlrSgzmc = jhlrSgzmc == null ? null : jhlrSgzmc.trim();
    }

    public String getJhlrZjurl() {
        return jhlrZjurl;
    }

    public void setJhlrZjurl(String jhlrZjurl) {
        this.jhlrZjurl = jhlrZjurl == null ? null : jhlrZjurl.trim();
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }

    public String getJhlrFzdw() {
        return jhlrFzdw;
    }

    public void setJhlrFzdw(String jhlrFzdw) {
        this.jhlrFzdw = jhlrFzdw == null ? null : jhlrFzdw.trim();
    }

    public Date getJhlrFzTime() {
        return jhlrFzTime;
    }

    public void setJhlrFzTime(Date jhlrFzTime) {
        this.jhlrFzTime = jhlrFzTime;
    }

    public Date getJhlrYxq() {
        return jhlrYxq;
    }

    public void setJhlrYxq(Date jhlrYxq) {
        this.jhlrYxq = jhlrYxq;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }
}