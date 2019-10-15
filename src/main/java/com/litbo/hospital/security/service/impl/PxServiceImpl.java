package com.litbo.hospital.security.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.dao.PxDao;
import com.litbo.hospital.security.service.PxService;
import com.litbo.hospital.security.vo.BmVo;
import com.litbo.hospital.security.vo.KsFzVo;
import com.litbo.hospital.security.vo.RyPxJhVo;
import com.litbo.hospital.security.vo.YyPxJhVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PxServiceImpl implements PxService {

    @Autowired(required = false)
    PxDao pxDao;

    public PageInfo getYypxNr(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(pxDao.getYypxNr());
    }

    public PageInfo findAllYyJh(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(pxDao.findAllYyJh());
    }

    public PageInfo findAllRyjh(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(pxDao.findAllRyJh());
    }

    public Integer addRypxjh(RyPxJhVo ryPxJhVo){
        ryPxJhVo.setId(UUID.randomUUID().toString());
        return pxDao.addRypxjh(ryPxJhVo);
    }

    public Integer addYypxjh(YyPxJhVo yyPxJhVo){
        yyPxJhVo.setId(UUID.randomUUID().toString());
        return pxDao.addYypxjh(yyPxJhVo);
    }
    public List<KsFzVo> getYypxKsNr(int pageNum, int pageSize){
            PageHelper.startPage(pageNum,pageSize);
    //        System.out.println(pxDao.getYypxKsNr());
            return pxDao.getYypxKsNr();
    }

}
