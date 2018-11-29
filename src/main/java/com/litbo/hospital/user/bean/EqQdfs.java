package com.litbo.hospital.user.bean;

public class EqQdfs {
    private Integer qdfsId;

    private String qdfsName;

    private String bz;

    public Integer getQdfsId() {
        return qdfsId;
    }

    public void setQdfsId(Integer qdfsId) {
        this.qdfsId = qdfsId;
    }

    public String getQdfsName() {
        return qdfsName;
    }

    public void setQdfsName(String qdfsName) {
        this.qdfsName = qdfsName == null ? null : qdfsName.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }
}