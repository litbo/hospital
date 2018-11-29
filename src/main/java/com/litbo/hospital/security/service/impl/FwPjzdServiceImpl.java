package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwPjzd;
import com.litbo.hospital.security.dao.FwPjzdDao;
import com.litbo.hospital.security.service.FwPjzdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FwPjzdServiceImpl implements FwPjzdService {
    @Autowired
    private FwPjzdDao pjzdDao;
    public PageInfo listFwPjzd(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return  new PageInfo(pjzdDao.listFwPjzd());
    }
    @Override
    public int insertFwPjzd(FwPjzd pjzd) {
        return pjzdDao.insertPjzd(pjzd);

    }
}
