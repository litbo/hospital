package com.litbo.hospital.security.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.dao.KhDao;
import com.litbo.hospital.security.dao.PxDao;
import com.litbo.hospital.security.service.KhService;
import com.litbo.hospital.security.service.PxService;
import com.litbo.hospital.security.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class KhServiceImpl implements KhService{

    @Autowired(required = false)
    KhDao khDao;

    @Override
    public ListCanJiaVo findByPxjgIs(String id) {
        return khDao.findByPxjgIs(id);
    }

    @Override
    public void updateLv(@Param("pxl") String pxl,@Param("hgl") String khhgl,@Param("jh_id") String jh_id) {
        khDao.updateLv(pxl,khhgl,jh_id);
    }

    @Override
    public void insertLv(@Param("hgl") String khhgl, @Param("pxl") String pxl, String jh_id) {
        String id = UUID.randomUUID().toString();
        khDao.insertLv(id,khhgl,pxl,jh_id);
    }

    @Override
    public ListSumRenVo findsumRen(String id) {
        return khDao.findsumRen(id);
    }

    @Override
    public ListJiGeVo findByKhjgJg(String id) {
        return khDao.findByKhjgJg(id);
    }

    @Override
    public LvJcVos getPxlAndKhl(String jh_id) {
        return khDao.getPxlAndKhl(jh_id);
    }

    @Override
    public NumVos getNum() {
        return khDao.getNum();
    }

    @Override
    public boolean khBc(KhZxinxiVo ks) {
        ks.setId(UUID.randomUUID().toString());
        return khDao.khBc(ks);
    }

    @Override
    public PageInfo findInfo(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
//        NumVos numVos = khDao.getNum();
//        List<ListCheckLvVos> list = khDao.findInfo();
//        List<ListCheckLvVos> vos = new ArrayList<>();
//        for(ListCheckLvVos l:list){
//            l.setSdNum(numVos.getSdNum());
//            l.setYdNum(numVos.getYdNum());
//            l.setWdNum(numVos.getWdNum());
//            l.setHgNum(numVos.getHgNum());
//            vos.add(l);
//        }
        PageInfo pageInfo = new PageInfo(khDao.findInfo());
        return pageInfo;
    }

    @Override
    public List<RenYuanVo> getYdRen(int pageNum, int pageSize, String id) {
        PageHelper.startPage(pageNum,pageSize);
        List<RenYuanVo> renYuanVos =  khDao.getYdRen(id);
        return renYuanVos;
    }

    @Override
    public List<RenYuanVo> getSdRen(int pageNum, int pageSize, String id) {
        PageHelper.startPage(pageNum,pageSize);
        List<RenYuanVo> renYuanVos =  khDao.getSdRen(id);
        return renYuanVos;
    }

    @Override
    public List<RenYuanVo> getHgRen(int pageNum, int pageSize, String id) {
        PageHelper.startPage(pageNum,pageSize);
        List<RenYuanVo> renYuanVos =  khDao.getHgRen(id);
        return renYuanVos;
    }

    @Override
    public List<RenYuanVo> getWdRen(int pageNum, int pageSize, String id) {
        PageHelper.startPage(pageNum,pageSize);
        List<RenYuanVo> renYuanVos =  khDao.getWdRen(id);
        return renYuanVos;
    }

    @Override
    public PageInfo kh(int pageNum, int pageSize, String id) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(khDao.kh(id));
    }
}
