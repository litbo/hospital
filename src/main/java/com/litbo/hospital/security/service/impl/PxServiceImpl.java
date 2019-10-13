package com.litbo.hospital.security.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.dao.PxDao;
import com.litbo.hospital.security.service.PxService;
import com.litbo.hospital.security.vo.BmVo;
import com.litbo.hospital.security.vo.RyPxJhVo;
import com.litbo.hospital.security.vo.YyPxJhVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PxServiceImpl implements PxService {

    @Autowired(required = false)
    PxDao pxDao;

    public PageInfo getYypxNr(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(pxDao.getYypxNr());
    }

    public Integer addYypxjh(RyPxJhVo ryPxJhVo){
        return pxDao.addYypxjh(ryPxJhVo);
    }
   public List<BmVo> getYypxKsNr(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return pxDao.getYypxKsNr();
   }
}