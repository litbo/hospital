package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgZbwyhRy;
import com.litbo.hospital.lifemanage.bean.SgZbwyhhy;
import com.litbo.hospital.lifemanage.bean.vo.SgInfoSumAuditListVO;
import com.litbo.hospital.lifemanage.bean.vo.SgZbwyhhyVO;
import com.litbo.hospital.lifemanage.bean.vo.ShVO;
import com.litbo.hospital.lifemanage.bean.vo.YearBudgetVO;
import com.litbo.hospital.lifemanage.dao.SgInfoMapper;
import com.litbo.hospital.lifemanage.dao.SgZbwyhRyMapper;
import com.litbo.hospital.lifemanage.dao.SgZbwyhhyMapper;
import com.litbo.hospital.lifemanage.service.SgInfoService;
import com.litbo.hospital.lifemanage.service.SgZbwyhhyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    SgInfoService sgInfoService;

    /**
     * 添加装备委员会信息
     *
     * @param sgZbwyhhyVO 装备委员会会议信息
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public void insertSgInfoZbwyhhy(SgZbwyhhyVO sgZbwyhhyVO) {
        ShVO shVO = new ShVO();
        BeanUtils.copyProperties(sgZbwyhhyVO,shVO);
        //更改申购单表中的状态
        sgInfoService.updateSgInfoZbwyhhy(shVO);
        //添加装备委员会审核信息
        for (String sgId : shVO.getIds()) {
            sgZbwyhhyVO.setSgId(sgId);
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
    }

    /**
     * 装备委员会年度采购计划
     *
     * @param year     年份
     * @param bmId     科室id
     * @param bh       申购单编号
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return PageInfo<SgInfoSumAuditListVO>
     */
    @Override
    public PageInfo<SgInfoSumAuditListVO> selectSgZbwyhYearPurchase(String year, String bmId, String bh, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(sgInfoMapper.selectSgZbwyhYearPurchase(year, bmId, bh));
    }

    /**
     * 装备委员会年度采购预算
     *
     * @param year     年份
     * @param bmId     科室id
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return PageInfo<YearBudgetVO>
     */
    @Override
    public PageInfo<YearBudgetVO> selectSgZbwyhYearBudget(String year, String bmId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(sgInfoMapper.selectSgZbwyhYearBudget(year, bmId));
    }

    /**
     * 装备委员会详情信息
     * @param zbwyhhyId 装备会员会id
     * @return SgZbwyhhyVO
     */
    @Override
    public SgZbwyhhyVO selectSgZbwyhById(String zbwyhhyId) {
        return sgZbwyhhyMapper.selectSgZbwyhById(zbwyhhyId);
    }
}
