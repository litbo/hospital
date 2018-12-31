package com.litbo.hospital.supervise.vo;

public class ZDSelectAsBaseShMsg {
    private Integer zdId;    //制度编号
    private String zdName;  // 制度名称
    private String ztCzname;    //制度状态操作名称

    public Integer getZdId() {
        return zdId;
    }

    public void setZdId(Integer zdId) {
        this.zdId = zdId;
    }

    public String getZdName() {
        return zdName;
    }

    public void setZdName(String zdName) {
        this.zdName = zdName;
    }

    public String getZtCzname() {
        return ztCzname;
    }

    public void setZtCzname(String ztCzname) {
        this.ztCzname = ztCzname;
    }
}
