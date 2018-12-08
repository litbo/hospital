package com.litbo.hospital.security.service;

import com.litbo.hospital.security.bean.JhRylr;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-02 14:53
 * 计划人员录入
 */
public interface JhRyLrService {

    /**
     * 计划人员批量录入
     * @param list
     */
    public void addJhRyLrList(List<JhRylr> list);

    /**
     * 添加（修改）计划人员
     * @param JhRylr
     */
    public void addOrUpdateJhRyLr(JhRylr JhRylr);

    /**
     * 根据计划查询参加计划的人员
     * @param jhId
     * @return
     */
    public List<JhRylr> findJhRyLrByJhId(Integer jhId);

    /**
     * 根据人员查询计划
     * @param empId
     * @return
     */
    public List<JhRylr> findJhRyLrByEmpId(String empId);
}
