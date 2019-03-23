package com.litbo.hospital.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.user.bean.SysTxcl;
import com.litbo.hospital.user.bean.SysTxlb;
import com.litbo.hospital.user.dao.XttxDao;
import com.litbo.hospital.user.service.XttxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XttxServiceImpl implements XttxService {

    @Autowired
    private XttxDao xttxDao;

    @Override
    public Integer addTxlb(SysTxlb sysTxlb) {

        return xttxDao.addTxlb(sysTxlb);
    }

    @Override
    public Integer addTxcl(SysTxcl sysTxcl) {
        return xttxDao.addTxcl(sysTxcl);
    }

    @Override
    public PageInfo listTxlb(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        return new PageInfo(xttxDao.listTxlb());
    }

    @Override
    public PageInfo listTxcl(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        return new PageInfo(xttxDao.listTxcl());
    }
}
