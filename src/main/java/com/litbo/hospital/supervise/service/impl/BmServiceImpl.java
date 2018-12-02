package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.dao.BmDao;
import com.litbo.hospital.supervise.service.BmService;
import com.litbo.hospital.supervise.vo.BmSelectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BmServiceImpl implements BmService {

    @Autowired
    private BmDao bmDao;
    @Override
    public PageInfo getBmList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SBm> date = bmDao.getBmList();
        return new PageInfo(date);
    }

    @Override
    public PageInfo getBmListByPid(int pageNum, int pageSize, String pid) {
        PageHelper.startPage(pageNum,pageSize);
        List<SBm> date = bmDao.getBmListByPid(pid);
        return new PageInfo(date);
    }
    @Override
    public SBm getBmListById(String id) {
        SBm date = bmDao.getBmListById(id);
        return date;
    }

    @Override
    public void saveBm(SBm bm) {
        bmDao.saveBm(bm);
    }

    @Override
    public PageInfo getBmListByX(int pageNum, int pageSize, BmSelectVO selectVo) {
        PageHelper.startPage(pageNum,pageSize);
        List<SBm> date = bmDao.getBmListByX(selectVo);
        return new PageInfo(date);
    }

    @Override
    public void removeBm(String bm_id) {
        bmDao.removeBm(bm_id);
    }
}
