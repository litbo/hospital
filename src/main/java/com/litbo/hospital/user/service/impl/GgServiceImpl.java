package com.litbo.hospital.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.user.bean.SysGg;
import com.litbo.hospital.user.dao.GgDao;
import com.litbo.hospital.user.service.GgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GgServiceImpl implements GgService {

    @Autowired
    private GgDao ggDao;

    @Override
    public int addGg(SysGg gg) {
        return ggDao.addGg(gg);
    }

    @Override
    public PageInfo listShowGgs(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        return new PageInfo(ggDao.listShowGgs());
    }

    @Override
    public int checkGg(Integer id) {
        return ggDao.checkGg(id);
    }
}