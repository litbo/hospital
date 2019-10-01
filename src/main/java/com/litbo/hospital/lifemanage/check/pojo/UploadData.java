package com.litbo.hospital.lifemanage.check.pojo;

import java.util.List;

public class UploadData {
    private String pdCzr;

    private String pdJhid;

    private List<String> pid;

    private List<String> pdScsj;

    @Override
    public String toString() {
        return "UploadData{" +
                "pdCzr='" + pdCzr + '\'' +
                ", pdJhid='" + pdJhid + '\'' +
                ", pid=" + pid +
                ", pdScsj=" + pdScsj +
                '}';
    }

    public UploadData() {
    }

    public UploadData(String pdCzr, String pdJhid, List<String> pid, List<String> pdScsj) {
        this.pdCzr = pdCzr;
        this.pdJhid = pdJhid;
        this.pid = pid;
        this.pdScsj = pdScsj;
    }

    public String getPdCzr() {
        return pdCzr;
    }

    public void setPdCzr(String pdCzr) {
        this.pdCzr = pdCzr;
    }

    public String getPdJhid() {
        return pdJhid;
    }

    public void setPdJhid(String pdJhid) {
        this.pdJhid = pdJhid;
    }

    public List<String> getPid() {
        return pid;
    }

    public void setPid(List<String> pid) {
        this.pid = pid;
    }

    public List<String> getPdScsj() {
        return pdScsj;
    }

    public void setPdScsj(List<String> pdScsj) {
        this.pdScsj = pdScsj;
    }
}
