package com.litbo.hospital.beneficial.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.beneficial.dao.CbxySzDao;
import com.litbo.hospital.beneficial.service.CbxySzService;
import com.litbo.hospital.beneficial.vo.CbMhVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CbxySzServiceImpl implements CbxySzService {

    @Autowired
    private CbxySzDao cbxySzDao;

    @Override
    public PageInfo listCbxySz(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(cbxySzDao.listCbxySz());
    }

    @Override
    public PageInfo listCbxySzByX(int pageNum, int pageSize, CbMhVo cbMhVo) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(cbxySzDao.listCbxySzByX(cbMhVo));
    }

    @Override
    public List listCbxySzByXExport(CbMhVo cbMhVo) {
        return cbxySzDao.listCbxySzByX(cbMhVo);
    }

    @Override
    public PageInfo selectCbkmByEqId(int pageNum, int pageSize, Integer eqId) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(cbxySzDao.selectCbkmByEqId(eqId));
    }

    @Override
    public List selectCbkmByEqIdExport(Integer eqId) {
        return cbxySzDao.selectCbkmByEqId(eqId);
    }

    @Override
    public PageInfo listSrSz(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(cbxySzDao.listSrSz());
    }

    @Override
    public PageInfo listSrSzByX(int pageNum, int pageSize, CbMhVo cbMhVo) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(cbxySzDao.listSrSzByX(cbMhVo));
    }


    @Override
    public List listSrSzByXExport(CbMhVo cbMhVo) {
        return cbxySzDao.listSrSzByX(cbMhVo);
    }

    @Override
    public PageInfo selectSrkmByEqId(int pageNum, int pageSize, Integer eqId) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(cbxySzDao.selectSrkmByEqId(eqId));
    }

    @Override
    public List selectSrkmByEqIdExport(Integer eqId) {
        return cbxySzDao.selectSrkmByEqId(eqId);
    }


}
