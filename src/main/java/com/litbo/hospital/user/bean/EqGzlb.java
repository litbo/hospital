package com.litbo.hospital.user.bean;

public class EqGzlb {
    private Integer gzlbId;

    private String gzlbName;

    public Integer getGzlbId() {
        return gzlbId;
    }

    public void setGzlbId(Integer gzlbId) {
        this.gzlbId = gzlbId;
    }

    public String getGzlbName() {
        return gzlbName;
    }

    public void setGzlbName(String gzlbName) {
        this.gzlbName = gzlbName == null ? null : gzlbName.trim();
    }
}