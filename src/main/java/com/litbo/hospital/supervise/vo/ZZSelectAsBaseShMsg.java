package com.litbo.hospital.supervise.vo;

public class ZZSelectAsBaseShMsg {
    private Integer gwId;    //制度编号
    private String gwName;  // 制度名称
    private String ztCzname;    //制度状态操作名称


    public Integer getGwId() {
        return gwId;
    }

    public void setGwId(Integer gwId) {
        this.gwId = gwId;
    }

    public String getGwName() {
        return gwName;
    }

    public void setGwName(String gwName) {
        this.gwName = gwName;
    }

    public String getZtCzname() {
        return ztCzname;
    }

    public void setZtCzname(String ztCzname) {
        this.ztCzname = ztCzname;
    }
}
