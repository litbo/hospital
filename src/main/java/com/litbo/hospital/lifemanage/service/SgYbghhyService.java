package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.SgInfoSumAuditListVO;
import com.litbo.hospital.lifemanage.bean.vo.SgYbghhyVO;
import com.litbo.hospital.lifemanage.bean.vo.YearBudgetVO;

/**
 * 院办公会会议信息表Service接口
 */
public interface SgYbghhyService {
    /**
     * 添加院办公会信息
     *
     * @param sgYbghhyVO 装备委员会会议信息
     */
    void insertSgInfoYbghhy(SgYbghhyVO sgYbghhyVO);

    /**
     * 院办公会年度采购计划
     *
     * @param year     年份
     * @param bmId     部门id
     * @param bh       申购单编号
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return PageInfo<SgInfoSumAuditListVO>
     */
    PageInfo<SgInfoSumAuditListVO> selectSgYbghhyYearPurchase(String year, String bmId, String bh, Integer pageNum, Integer pageSize);

    /**
     * 院办公会年度采购预算
     *
     * @param year     年份
     * @param bmId     部门id
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return PageInfo<YearBudgetVO>
     */
    PageInfo<YearBudgetVO> selectSgYbghhyYearBudget(String year, String bmId, Integer pageNum, Integer pageSize);

    /**
     * 院办公会会议详情
     *
     * @param ybghhyId 院办公会会议id
     * @return SgYbghhyVO
     */
    SgYbghhyVO selectSgYbghhyById(String ybghhyId);
}
