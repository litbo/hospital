package com.litbo.hospital.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.user.bean.EqCs;
import com.litbo.hospital.user.dao.CsDao;
import com.litbo.hospital.user.service.CsService;
import com.litbo.hospital.user.vo.GysVo;
import com.litbo.hospital.user.vo.ScsVo;
import com.litbo.hospital.user.vo.WxsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PageInfo listScsByX(int pageNum, int pageSize, String sbcsName) {
        PageHelper.startPage(pageNum,pageSize);
        List<ScsVo> date = csDao.listScsByX(sbcsName);
        return new PageInfo(date);

    }

    @Override
    public PageInfo listWxsByX(int pageNum, int pageSize, String sbcsName) {
        PageHelper.startPage(pageNum,pageSize);
        List<WxsVo> date = csDao.listWxsByX(sbcsName);
        return new PageInfo(date);
    }

    @Override
    public PageInfo listGysByX(int pageNum, int pageSize, String sbcsName) {
        PageHelper.startPage(pageNum,pageSize);
        List<GysVo> date = csDao.listGysByX(sbcsName);
        return new PageInfo(date);
    }
}
