package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgPlan;
import com.litbo.hospital.lifemanage.bean.vo.SgPlanVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 审核计划Service
 *
 * @author Administrator on 2018-12-29
 */
public interface SgPlanService {

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
    PageInfo selectPlan(@Param("planName") String planName, @Param("planDate")
            String planDate, @Param("userName") String userName, @Param("pageNum") Integer pageNum,
                                @Param("pageSize") Integer pageSize);

    /**
     * 查询所有的计划名字
     * @return
     */
    List<String> getplanName();

    String selectIdByName(SgPlanVO sgPlanVO);

    void delPlan(String ids);
}
