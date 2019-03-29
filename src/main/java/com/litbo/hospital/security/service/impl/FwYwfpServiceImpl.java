package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwYwfp;
import com.litbo.hospital.security.dao.FwYwfpDao;
import com.litbo.hospital.security.service.FwYwfpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FwYwfpServiceImpl implements FwYwfpService {
    @Autowired
    private FwYwfpDao fwYwfpDao;
    @Override
    public int insertFwYwFp(FwYwfp fwYwfp) {
        fwYwfp.setYwfpCjTime(new Date());
        return fwYwfpDao.insertFwYwFp(fwYwfp);
    }

    @Override
    public PageInfo listFwYwFp(int pageNum, int pageSize, String fpHm, String eqName, String wxDh) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(fwYwfpDao.listFwYwFp( fpHm, eqName, wxDh));
    }
}
