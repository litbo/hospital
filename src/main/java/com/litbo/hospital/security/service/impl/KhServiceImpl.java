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
    public boolean khBc(KhZxinxiVo ks) {
        ks.setId(UUID.randomUUID().toString());
        return khDao.khBc(ks);
    }

    @Override
    public List<ListJhVos> findInfo(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        NumVos numVos;
        List<ListJhVos> listJhVos = new ArrayList<>();

       // ListJhVos jhVos = new ListJhVos();

        List<ListCheckLvVos> vos = khDao.findInfo();

        for(ListCheckLvVos os:vos){
            ListJhVos jhVos = new ListJhVos();
            System.out.println(os.getId());
            numVos = khDao.getNum(os.getId());
//            System.out.println("合格人数："+numVos.getHgNum());
//            System.out.println("未到人数"+numVos.getWdNum());
//            System.out.println("实到人数"+numVos.getSdNum());
//            System.out.println("应到人数"+numVos.getYdNum());
            jhVos.setId(os.getId());
            jhVos.setEqName(os.getEqName());
            jhVos.setPxnrlb(os.getPxnrlb());
            jhVos.setPxlx(os.getPxlx());
            jhVos.setPxfs(os.getPxfs());
            jhVos.setPxl(os.getPxl());
            jhVos.setKhhgl(os.getKhhgl());
            jhVos.setYdNum(numVos.getYdNum());
            jhVos.setSdNum(numVos.getSdNum());
            jhVos.setWdNum(numVos.getWdNum());
            jhVos.setHgNum(numVos.getHgNum());

            listJhVos.add(jhVos);
        }
        return listJhVos;
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
