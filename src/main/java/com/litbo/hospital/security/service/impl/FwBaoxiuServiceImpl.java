package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.security.bean.FwBaoxiu;
import com.litbo.hospital.security.bean.FwLcjl;
import com.litbo.hospital.security.dao.*;
import com.litbo.hospital.security.enums.EnumProcess;
import com.litbo.hospital.security.service.FwBaoxiuService;
import com.litbo.hospital.security.vo.BaoXiuRw;
import com.litbo.hospital.security.vo.BaoxiuEqVo;
import com.litbo.hospital.security.vo.FwBaoxiuIndexVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author zjc
 * @create 2018-12-03 11:13
 */
@Service
public class FwBaoxiuServiceImpl implements FwBaoxiuService {

    @Autowired
    private FwBaoxiuDao fwBaoxiuDao;

    @Autowired
    private FwLcjlDao fwLcjlDao;

    @Autowired
    private FwShouLiDao fwShouLiDao;

    @Autowired
    private FwWeixiuDao fwWeixiuDao;

    @Autowired
    private FwWxfDao fwWxfDao;

    @Override
    public PageInfo getBaoxiuEq(String userId,Integer pageSize,Integer pageNum,String bmName,String eqName) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<BaoxiuEqVo> pageInfo = new PageInfo<>(fwBaoxiuDao.findBaoxiuEq(userId,bmName,eqName));

        return pageInfo;
    }

    @Override
    public PageInfo baoxiuRw(String userId,Integer pageNum,Integer pageSize) {
        List<BaoXiuRw> baoxiuRw = fwBaoxiuDao.findBaoxiuRw(userId, EnumProcess.FW_BX_SL.getCode());
        List<BaoXiuRw> baoxiuRw1 = fwShouLiDao.findBaoxiuRw(userId);
        List<BaoXiuRw> baoxiuRw2 = fwWeixiuDao.getBaoXiuRw(userId);
        List<BaoXiuRw> baoxiuRw3 = fwWxfDao.getWxfRw(userId);
        baoxiuRw.addAll(baoxiuRw1);
        baoxiuRw.addAll(baoxiuRw1);
        baoxiuRw.addAll(baoxiuRw3);
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<BaoXiuRw>(baoxiuRw);
    }

    @Override
    public FwBaoxiuIndexVo baoxiuIndex(String eqId, String empId) {

        FwBaoxiuIndexVo baoxiuIndexVo = fwBaoxiuDao.findBaoxiuIndexVo(eqId, empId);

        return baoxiuIndexVo;
    }

    @Transactional
    @Override
    public void addBaoxiu(FwBaoxiu fwBaoxiu) {
        //添加到报修单
        String id = IDFormat.getIdByIDAndTime("fw_baoxiu", "id");
        fwBaoxiu.setId(id);
        fwBaoxiu.setBxTime(new Date());
        fwBaoxiu.setBxStatus(EnumProcess.FW_BX_SL.getCode());
        fwBaoxiu.setJjxStatus(1);
        fwBaoxiuDao.addBaoxiu(fwBaoxiu);
        //添加流程记录
        FwLcjl fwLcjl = new FwLcjl();
        fwLcjl.setUserId(fwBaoxiu.getBxrId());
        fwLcjl.setBxId(id);
        fwLcjl.setCreatTime(new Date());
        fwLcjl.setLc(EnumProcess.FW_GZ_BX.getMessage());
        fwLcjlDao.insertFwLcjl(fwLcjl);
    }

    @Override
    @Transactional
    public void updateBaoxiuStatusById(String id, Integer baoxiuStatus) {
        fwBaoxiuDao.updateBaoxiuStatus(id,baoxiuStatus);
    }

    @Override
    public PageInfo listWx(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        return new PageInfo(fwBaoxiuDao.listFwBaoxiuVo(EnumProcess.FW_WX_OVER.getCode()));
    }
}
