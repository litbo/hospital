package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgZbwyhRy;
import com.litbo.hospital.lifemanage.bean.SgZbwyhhy;
import com.litbo.hospital.lifemanage.bean.vo.SgInfoSumAuditListVO;
import com.litbo.hospital.lifemanage.bean.vo.SgZbwyhhyVO;
import com.litbo.hospital.lifemanage.bean.vo.YearBudgetVO;
import com.litbo.hospital.lifemanage.dao.SgInfoMapper;
import com.litbo.hospital.lifemanage.dao.SgZbwyhRyMapper;
import com.litbo.hospital.lifemanage.dao.SgZbwyhhyMapper;
import com.litbo.hospital.lifemanage.service.SgZbwyhhyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * 装备委员会会议信息表Service实现类
 */
@Service
public class SgZbwyhhyServiceImpl implements SgZbwyhhyService {
    @Autowired
    private SgZbwyhhyMapper sgZbwyhhyMapper;
    @Autowired
    private SgZbwyhRyMapper sgZbwyhRyMapper;
    @Autowired
    private SgInfoMapper sgInfoMapper;

    /**
     * 添加装备委员会信息
     *
     * @param sgZbwyhhyVO 装备委员会会议信息
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public void insertSgInfoZbwyhhy(SgZbwyhhyVO sgZbwyhhyVO) {
        SgZbwyhhy sgZbwyhhy = new SgZbwyhhy();
        BeanUtils.copyProperties(sgZbwyhhyVO, sgZbwyhhy);
        String zbwyhId = UUID.randomUUID().toString();
        sgZbwyhhy.setZbwyhhyId(zbwyhId);

        sgZbwyhhyMapper.insertSgInfoZbwyhhy(sgZbwyhhy);
        //在申购单中添加装备委员会会议id
        sgInfoMapper.updateSgInfoZbwyhhyIdById(sgZbwyhhy.getSgId(), zbwyhId);
        //添加会议人员信息
        SgZbwyhRy sgZbwyhRy = new SgZbwyhRy();
        sgZbwyhRy.setZbwyhhyId(zbwyhId);
        for (String ryId : sgZbwyhhyVO.getSgZbwyhRys()) {
            sgZbwyhRy.setUserId(ryId);
            sgZbwyhRyMapper.insertZbwyhhyRy(sgZbwyhRy);
        }
    }

    /**
     * 装备委员会年度采购计划
     *
     * @param year     年份
     * @param bmId     部门id
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return PageInfo<SgInfoSumAuditListVO>
     */
    @Override
    public PageInfo<SgInfoSumAuditListVO> selectSgZbwyhYearPurchase(String year, String bmId, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<SgInfoSumAuditListVO> selectKsShHzs = sgInfoMapper.selectSgZbwyhYearPurchase(year, bmId);
        for (SgInfoSumAuditListVO selectKsShHz : selectKsShHzs) {
            //TODO 根据部门id查询部门名称
            // selectKsShHz.getBmId();
            selectKsShHz.setBmName("部门1");
        }
        return new PageInfo<>(selectKsShHzs);
    }

    /**
     * 装备委员会年度采购预算
     *
     * @param year     年份
     * @param bmId     部门id
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return PageInfo<YearBudgetVO>
     */
    @Override
    public PageInfo<YearBudgetVO> selectSgZbwyhYearBudget(String year, String bmId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<YearBudgetVO> yearBudgetVOS = sgInfoMapper.selectSgZbwyhYearBudget(year, bmId);
        for (YearBudgetVO yearBudgetVO : yearBudgetVOS) {
            //TODO 根据部门id查询部门名称
            // selectKsShHz.getBmId();
            yearBudgetVO.setBmName("部门1");
        }
        return new PageInfo<>(yearBudgetVOS);
    }
}
