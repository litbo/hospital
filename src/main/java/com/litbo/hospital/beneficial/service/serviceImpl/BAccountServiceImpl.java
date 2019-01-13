package com.litbo.hospital.beneficial.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.beneficial.dao.BAccountDao;
import com.litbo.hospital.beneficial.service.BAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BAccountServiceImpl implements BAccountService {

    @Autowired
    private BAccountDao bAccountDao;

    @Override
    public PageInfo listCbAccount(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(bAccountDao.listCbAccount());
    }

    public PageInfo listSrAccount(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(bAccountDao.listsrAccount());
    }
}
