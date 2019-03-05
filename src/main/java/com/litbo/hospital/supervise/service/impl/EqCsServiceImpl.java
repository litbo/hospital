package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.dao.EqCsDao;
import com.litbo.hospital.supervise.service.EqCsService;
import com.litbo.hospital.supervise.vo.EqCsInsertReadyVO;
import com.litbo.hospital.supervise.vo.EqCsSelectVO;
import com.litbo.hospital.supervise.vo.EqCsVO;
import com.litbo.hospital.user.bean.EqCs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EqCsServiceImpl implements EqCsService {
    @Autowired
    private EqCsDao eqCsDao;

    @Override
    public PageInfo listEqCs(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<EqCs> eqcss = eqCsDao.listEqCs(pageNum,pageSize);
        return new PageInfo(eqcss);
    }

    @Override
    public EqCsInsertReadyVO readyResource() {
        EqCsInsertReadyVO readyVO = new EqCsInsertReadyVO();
//        List<Eqcs> = eqCsDao.listEqCslb();
        return null;

    }

    @Override
    public void insertEqCs(EqCs eqCs) {
        eqCsDao.insertEqCs(eqCs);
    }

    @Override
    public PageInfo listEqcsByX(int pageNum, int pageSize, EqCsSelectVO selectVo) {
        PageHelper.startPage(pageNum,pageSize);
        List<EqCs> date = eqCsDao.listEqcsByX(selectVo);
        return new PageInfo(date);
    }

    @Override
    public PageInfo listEqcsByX1(int pageNum, int pageSize, EqCsSelectVO selectVo) {
        PageHelper.startPage(pageNum,pageSize);
        selectVo.setEqCslb("3");
        List<EqCsVO> date = eqCsDao.listEqcsByX1(selectVo);
        return new PageInfo(date);
    }
    @Override
    public PageInfo listEqcsByX2(int pageNum, int pageSize, EqCsSelectVO selectVo) {
        PageHelper.startPage(pageNum,pageSize);
        selectVo.setEqCslb("1");
        List<EqCs> date = eqCsDao.listEqcsByX(selectVo);
        return new PageInfo(date);
    }
}
