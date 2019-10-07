package com.litbo.hospital.attendanceAndScheduling.attendance.vo;

/**
 * @Author: 樊小铭
 * Date: 2019/10/5 15:29
 * @Version:
 * @Description:
 */
public class UserInfoVo {
    private String id;
    private String name;
    private String bm;
    private String tel;
    private String zc;

    @Override
    public String toString() {
        return "UserInfoVo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bm='" + bm + '\'' +
                ", tel='" + tel + '\'' +
                ", zc='" + zc + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getZc() {
        return zc;
    }

    public void setZc(String zc) {
        this.zc = zc;
    }

    public UserInfoVo() {
    }

    public UserInfoVo(String id, String name, String bm, String tel, String zc) {
        this.id = id;
        this.name = name;
        this.bm = bm;
        this.tel = tel;
        this.zc = zc;
    }
}
