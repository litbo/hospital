package com.litbo.hospital.supervise.vo;

public class EmpSelectVO {

//    部门	编号	姓名	性别	学历	岗位  毕业院校
    private String bmName;
    private String userId;
    private String userXm;
    private String sex;
    private String xllb;
    private String zwlb;
    private String byyx;
    private Integer status;

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserXm() {
        return userXm;
    }

    public void setUserXm(String userXm) {
        this.userXm = userXm;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getXllb() {
        return xllb;
    }

    public void setXllb(String xllb) {
        this.xllb = xllb;
    }

    public String getZwlb() {
        return zwlb;
    }

    public void setZwlb(String zwlb) {
        this.zwlb = zwlb;
    }

    public String getByyx() {
        return byyx;
    }

    public void setByyx(String byyx) {
        this.byyx = byyx;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
