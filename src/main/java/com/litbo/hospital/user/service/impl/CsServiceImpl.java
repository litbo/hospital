package com.litbo.hospital.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.user.dao.CsDao;
import com.litbo.hospital.user.service.CsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CsServiceImpl implements CsService {
    @Autowired
    private CsDao csDao;

    @Override
    public PageInfo listScs(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(csDao.listScs());
    }

    @Override
    public PageInfo listWxs(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(csDao.listWxs());
    }

    @Override
    public PageInfo listGys(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(csDao.listGys());
    }
}
