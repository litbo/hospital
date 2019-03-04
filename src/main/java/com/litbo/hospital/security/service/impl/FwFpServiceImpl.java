package com.litbo.hospital.security.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwFp;
import com.litbo.hospital.security.dao.FwFpDao;
import com.litbo.hospital.security.service.FwFpService;
import com.litbo.hospital.security.vo.SelectFwFpByIdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FwFpServiceImpl implements FwFpService {
    @Autowired
    private FwFpDao fwFpDao;
    @Override
    public PageInfo listFwFpByWaitExamine(int pageNum, int pageSize, String fpHm, String eqName, String wxDh) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(fwFpDao.listFwFpByWaitExamine( fpHm, eqName, wxDh));
    }

    @Override
    public PageInfo listFwFpByApplyApproval(int pageNum, int pageSize, String fpHm, String eqName, String wxDh) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(fwFpDao.listFwFpByApplyApproval( fpHm, eqName, wxDh));

    }

    @Override
    public Integer insertFwFp(FwFp fp) {

        return fwFpDao.insertFwFp(fp);
    }

    @Override
    public int updateFwFp(FwFp fp) {
        return fwFpDao.updateFwFp(fp);
    }

    @Override
    public SelectFwFpByIdVo selectFwFpById(Integer id) {
        return fwFpDao.selectFwFpById(id);
    }
}
