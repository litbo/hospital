package com.litbo.hospital.metering.vo;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/15 22:58
 * @Version:
 * @Description:
 */
public class AddSomeMeteringUtilToProcessVo {
    private List<Integer> utilIds;
    private String department;

    @Override
    public String toString() {
        return "AddSomeMeteringUtilToProcessVo{" +
                "utilIds=" + utilIds +
                ", department='" + department + '\'' +
                '}';
    }

    public String getDepartment() {

        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Integer> getUtilIds() {
        return utilIds;
    }

    public void setUtilIds(List<Integer> utilIds) {
        this.utilIds = utilIds;
    }

    public AddSomeMeteringUtilToProcessVo() {
    }

    public AddSomeMeteringUtilToProcessVo(List<Integer> utilIds, String department) {
        this.utilIds = utilIds;
        this.department = department;
    }
}
