package com.litbo.hospital.attendanceAndScheduling.attendance.vo;

import java.io.PipedReader;
import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/10/5 15:54
 * @Version:
 * @Description:
 */
public class SignVo {
    private List<String> ids;
    private String sign;

    @Override
    public String toString() {
        return "SignVo{" +
                "ids=" + ids +
                ", sign='" + sign + '\'' +
                '}';
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public SignVo() {
    }

    public SignVo(List<String> ids, String sign) {
        this.ids = ids;
        this.sign = sign;
    }
}
