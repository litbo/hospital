package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.dao.FwPjkDao;
import com.litbo.hospital.security.service.FwPjkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FwPjkServiceImpl implements FwPjkService {
    @Autowired
    private FwPjkDao fwPjkDao;
    public PageInfo listFwPjk(int pageNum, int pageSize, String pjSzm){
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(fwPjkDao.listFwPjk(pjSzm));

    }

}
