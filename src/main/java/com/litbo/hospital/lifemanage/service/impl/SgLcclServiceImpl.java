package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.lifemanage.bean.SgLccl;
import com.litbo.hospital.lifemanage.bean.SgReason;
import com.litbo.hospital.lifemanage.bean.vo.*;
import com.litbo.hospital.lifemanage.dao.SgLcclMapper;
import com.litbo.hospital.lifemanage.dao.SgReasonMapper;
import com.litbo.hospital.lifemanage.enums.ModeEnum;
import com.litbo.hospital.lifemanage.service.SgLcclService;
import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.service.EqService;
import com.litbo.hospital.user.vo.LiveEmpVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 处置管理ServiceImpl
 *
 * @author Administrator on 2018-12-19
 */
@Service
public class SgLcclServiceImpl implements SgLcclService {
    @Autowired
    private SgLcclMapper sgLcclMapper;
    @Autowired
    private SgReasonMapper sgReasonMapper;
    @Autowired
    private EqService eqService;

    /**
     * 处置查询列表
     *
     * @param pageNum             当前页数
     * @param pageSize            每页显示记录数
     * @param dateLowerAndUpperVO 时间下限 时间上限
     * @return PageInfo<DisposalQueryVO>
     */
    @Override
    public PageInfo<DisposalQueryVO> selectSgLccLList(Integer pageNum, Integer pageSize, DateLowerAndUpperVO dateLowerAndUpperVO) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(sgLcclMapper.selectSgLccLList(dateLowerAndUpperVO));
    }

    /**
     * 待报废清单
     *
     * @param pageNum  当前页数
     * @param pageSize 每页显示记录数
     * @param bmId     部门id
     * @return PageInfo<ScrappedListVO>
     */
    @Override
    public PageInfo<ScrappedListVO> selectScrappedList(Integer pageNum, Integer pageSize, String bmId, String isScrapped) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(sgLcclMapper.selectScrappedList(bmId, isScrapped));
    }

    /**
     * 处置申请
     *
     * @param pageNum  当前页数
     * @param pageSize 每页显示记录数
     * @param bmId     部门id
     * @return PageInfo<ScrappedListVO>
     */
    @Override
    public PageInfo<ScrappedListVO> selectApplyList(Integer pageNum, Integer pageSize, String bmId) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(sgLcclMapper.selectApplyList(bmId));
    }

    /**
     * 添加处置申请信息
     *
     * @param sgLcclVO 处置申请信息
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public void updateApply(SgLcclVO sgLcclVO) {
        SgLccl sgLccl = new SgLccl();

        BeanUtils.copyProperties(sgLcclVO, sgLccl);
        //设置流程单号
        String idByIDAndTime = IDFormat.getIdByIDAndTime("sg_lccl", "lccl_id");
        sgLccl.setLcclId(idByIDAndTime);
        //添加处置信息
        sgLcclMapper.updateByEqIdSelective(sgLccl);
        List<String> reasonIds = sgLcclVO.getReasonIds();
        if (reasonIds != null) {
            SgReason sgReason = new SgReason();
            sgReason.setLcclId(sgLccl.getId());
            for (String reasonId : reasonIds) {
                sgReason.setReasonId(reasonId);
                //添加报废原因
                sgReasonMapper.insert(sgReason);
            }
        }
    }

    /**
     * 申请报废
     *
     * @param sgLc 设备id
     */
    @Override
    public void insertApplyScrap(ListIdsVO sgLc) {
        SgLccl sgLccl = new SgLccl();
        BeanUtils.copyProperties(sgLc,sgLccl);
        //获取登陆人id
        LiveEmpVo emp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        sgLccl.setUserId(emp.getUserId());
        sgLccl.setDeclareTime(new Date());
        sgLccl.setState("科室申请报废");
        if (sgLc.getIds().size() > 0) {
            for (String eqId : sgLc.getIds()) {
                sgLccl.setId(UUID.randomUUID().toString());
                sgLccl.setEqId(eqId);
                sgLcclMapper.insert(sgLccl);
            }
        }
    }

    /**
     * 处置任务
     *
     * @param sgLc 上报审核信息
     */
    @Override
    public void updateSgLccLByEqId(SgLcclVO sgLc) {
        SgLccl sgLccl = new SgLccl();
        BeanUtils.copyProperties(sgLc,sgLccl);
        List<String> ids = sgLc.getIds();
        for (String id : ids) {
            sgLccl.setId(id);
            sgLcclMapper.updateByEqIdSelective(sgLccl);
        }
    }

    /**
     * 处置备案
     *
     * @param sgLc 上报审核信息
     */
    @Transactional(propagation = Propagation.REQUIRED ,rollbackFor = RuntimeException.class)
    @Override
    public void updateSgLccLByEqId4(SgLcclVO sgLc) {
        SgLccl sgLccl = new SgLccl();
        EqInfo eqInfo = new EqInfo();
        eqInfo.setEqSyzt("报废");
        BeanUtils.copyProperties(sgLc,sgLccl);

        List<String> ids = sgLc.getIds();
        for (String id : ids) {
            sgLccl.setId(id);
            eqInfo.setEqId(sgLcclMapper.selectEqIdById(id));
            eqService.updateEq(eqInfo);
            sgLcclMapper.updateByEqIdSelective(sgLccl);
        }
    }

    /**
     * 待上报列表
     *
     * @param pageNum  当前页数
     * @param pageSize 每页显示记录数
     * @param tab      标记 1待上报列表 2待批复列表 3待清理设备 4待备案处置设备
     * @return PageInfo<DisposalReportListVO>
     */
    @Override
    public PageInfo<DisposalReportListVO> selectXList(Integer pageNum, Integer pageSize, String tab) {
        PageHelper.startPage(pageNum, pageSize);
        List<DisposalReportListVO> list = sgLcclMapper.selectXList(tab);
        if (list != null) {
            for (DisposalReportListVO aList : list) {
                aList.setMode(ModeEnum.getMessageByCode(Integer.parseInt(aList.getMode())));
            }
        }
        return new PageInfo<>(list);
    }

    /**
     * 处置流程信息查询
     *
     * @param eqId 设备id
     * @return DisposalProcessListVO
     */
    @Override
    public DisposalProcessListVO selectDisposalProcess(String eqId) {
        return sgLcclMapper.selectDisposalProcess(eqId);
    }
}
