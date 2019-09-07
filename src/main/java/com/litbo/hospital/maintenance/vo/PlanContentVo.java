package com.litbo.hospital.maintenance.vo;

import com.litbo.hospital.maintenance.pojo.Maintenance;

import java.util.List;

public class PlanContentVo {
    MaintenancePlanVo vo;
    List projects;

    public PlanContentVo(Maintenance vo, List projects) {
        this.vo = new MaintenancePlanVo(vo);
        this.projects = projects;
    }

    public MaintenancePlanVo getVo() {
        return vo;
    }

    public void setVo(MaintenancePlanVo vo) {
        this.vo = vo;
    }

    public List getProjects() {
        return projects;
    }

    public void setProjects(List projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "PlanContentVo{" +
                "vo=" + vo +
                ", projects=" + projects +
                '}';
    }
}
