package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgPlan;
import com.litbo.hospital.lifemanage.bean.vo.SgPlanVO;

import java.util.List;

/**
 * 审核计划Service
 *
 * @author Administrator on 2018-12-29
 */
public interface SgPlanService {
    /**
     * 计划制定
     *
     * @param sgPlan 计划内容
     */
    void insertPlan(SgPlan sgPlan);

    /**
     * 计划列表
     *
     * @param planName 计划名称
     * @param planDate 制定时间
     * @param userName   制定人
     * @param pageNum  当前页数
     * @param pageSize 每页记录数
     * @return PageInfo<SgPlan>
     */
    PageInfo<SgPlan> selectPlan(String planName, String planDate, String userName, Integer pageNum, Integer pageSize);

    /**
     * 查询所有的计划名字
     * @return
     */
    List<String> getplanName();

    String selectIdByName(SgPlanVO sgPlanVO);
}
