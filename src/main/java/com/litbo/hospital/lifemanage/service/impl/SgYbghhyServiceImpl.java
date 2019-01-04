package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgYbghhy;
import com.litbo.hospital.lifemanage.bean.vo.SgInfoSumAuditListVO;
import com.litbo.hospital.lifemanage.bean.vo.SgYbghhyVO;
import com.litbo.hospital.lifemanage.bean.vo.YearBudgetVO;
import com.litbo.hospital.lifemanage.dao.SgInfoMapper;
import com.litbo.hospital.lifemanage.dao.SgYbghhyMapper;
import com.litbo.hospital.lifemanage.service.SgYbghhyService;
import com.litbo.hospital.supervise.dao.BmDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * 院办公会会议信息表Service实现类
 */
@Service
public class SgYbghhyServiceImpl implements SgYbghhyService {
    @Autowired
    private SgYbghhyMapper sgYbghhyMapper;
    @Autowired
    private SgInfoMapper sgInfoMapper;
    @Autowired
    private BmDao bmDao;

    /**
     * 添加院办公会信息
     *
     * @param sgYbghhyVO 装备委员会会议信息
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public void insertSgInfoYbghhy(SgYbghhyVO sgYbghhyVO) {
        SgYbghhy sgYbghhy = new SgYbghhy();
        BeanUtils.copyProperties(sgYbghhyVO, sgYbghhy);
        String ybghhyId = UUID.randomUUID().toString();
        sgYbghhy.setYbghhyId(ybghhyId);

        sgYbghhyMapper.insertSgInfoZbwyhhy(sgYbghhy);
        //在申购单中添加装备委员会会议id
        sgInfoMapper.updateSgInfoYbghhyIdById(sgYbghhy.getSgId(), ybghhyId);
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
    public PageInfo<SgInfoSumAuditListVO> selectSgYbghhyYearPurchase(String year, String bmId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SgInfoSumAuditListVO> selectKsShHzs = sgInfoMapper.selectSgYbghhyYearPurchase(year, bmId);
        for (SgInfoSumAuditListVO selectKsShHz : selectKsShHzs) {
            //根据部门id查询部门名称
            selectKsShHz.setBmName(bmDao.getBmBybmid(bmId).getBmName());
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
     * @return List<YearBudgetVO>
     */
    @Override
    public PageInfo<YearBudgetVO> selectSgYbghhyYearBudget(String year, String bmId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(sgInfoMapper.selectSgYbghhyYearBudget(year,bmId));
    }
}
