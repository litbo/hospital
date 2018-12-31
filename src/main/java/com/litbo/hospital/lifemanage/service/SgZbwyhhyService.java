package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.SgInfoSumAuditListVO;
import com.litbo.hospital.lifemanage.bean.vo.SgZbwyhhyVO;
import com.litbo.hospital.lifemanage.bean.vo.YearBudgetVO;

/**
 * 装备委员会会议信息表Service接口
 */
public interface SgZbwyhhyService {
    /**
     * 添加装备委员会信息
     *
     * @param sgZbwyhhyVO 装备委员会会议信息
     */
    void insertSgInfoZbwyhhy(SgZbwyhhyVO sgZbwyhhyVO);

    /**
     * 装备委员会年度采购计划
     *
     * @param year 年份
     * @param bmId 部门id
     * @param pageNum 当前页数
     * @param pageSize 每页显示的记录数
     * @return PageInfo<SgInfoSumAuditListVO>
     */
    PageInfo<SgInfoSumAuditListVO> selectSgZbwyhYearPurchase(String year, String bmId, Integer pageNum, Integer pageSize);

    /**
     * 装备委员会年度采购预算
     *
     * @param year     年份
     * @param bmId     部门id
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return PageInfo<YearBudgetVO>
     */
    PageInfo<YearBudgetVO> selectSgZbwyhYearBudget(String year, String bmId, Integer pageNum, Integer pageSize);
}
