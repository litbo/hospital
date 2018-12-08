package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SGangwei;
import com.litbo.hospital.supervise.dao.GangweiDao;
import com.litbo.hospital.supervise.service.GangweiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GangweiServiceImpl implements GangweiService {

    @Autowired
    private GangweiDao gangweiDao;


    @Override
    public void saveGw(SGangwei gw) {
        gangweiDao.saveGw(gw);
    }

    @Override
    public void deleteGwByGwId(String gw_id) {
        gangweiDao.deleteGwByGwId(gw_id);
    }

    @Override
    public PageInfo getGws(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SGangwei> list =  gangweiDao.getGws();
        return new PageInfo(list);
    }

    @Override
    public SGangwei getGwsByGwId(int pageNum, int pageSize, String gw_id) {
        PageHelper.startPage(pageNum,pageSize);
        SGangwei gw =  gangweiDao.getGwsByGwId(gw_id);
        return gw;
    }

    @Override
    public void updateGw(SGangwei gw) {
        gangweiDao.updateGw(gw);


    }
}
