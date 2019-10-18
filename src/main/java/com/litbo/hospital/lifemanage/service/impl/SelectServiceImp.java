package com.litbo.hospital.lifemanage.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.*;
import com.litbo.hospital.lifemanage.bean.vo.SgCheckVO;
import com.litbo.hospital.lifemanage.dao.SelectMapper;
import com.litbo.hospital.lifemanage.dao.SgCheckMapper;
import com.litbo.hospital.lifemanage.dao.SgPdMapper;
import com.litbo.hospital.lifemanage.service.SelectService;
import com.litbo.hospital.lifemanage.service.SgCheckService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SelectServiceImp implements SelectService {

    @Autowired
    private SgPdMapper sgPdMapper;
    @Autowired
    private SelectMapper selectMapper;
    @Autowired
    private SgCheckMapper sgCheckMapper;
    @Autowired
    private SgCheckService sgCheckService;
    @Override
    public PageInfo<SgPdZt> yipan(@Param("pdJhid")String pdJhid,
                                        @Param("bmId") String bmId
                                    , @Param("pageNum")Integer pageNum
                                    , @Param("pageSize")Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        String eqName="";
        List<SgPdZt> listYipan = selectMapper.findYipan(pdJhid,eqName);
        return new PageInfo<>(listYipan);
    }

    @Override
    public PageInfo<SgPdZt> pankui(String pdJhid, String bmId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        String eqName="";
        List<SgPdZt> listPankui = selectMapper.findPankui(pdJhid,eqName);
        return new PageInfo<>(listPankui);//返回
    }

    @Override
    public PageInfo<SgPdZt> allList(String pdJhid, String bmId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        String eqName="";
        List<SgPdZt> listAll = selectMapper.findInfo(pdJhid,eqName);
//        System.out.println(selectMapper.findInfo(pdJhid,eqName));
        return new PageInfo<>(listAll);
    }
    @Override
    public PageInfo<SgPdZt> panYing(@Param("pdJhid")String pdJhid,
                                        @Param("bmId") String bmId
            , @Param("pageNum")Integer pageNum
            , @Param("pageSize")Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        String eqName="";
        List<SgPdZt> listPanying = selectMapper.findPanying(pdJhid,eqName);
        return new PageInfo<>(listPanying);
    }

    @Override
    public PageInfo<SgPdZt> findInfo(String pdJhid, String eqName, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SgPdZt> listAll = selectMapper.findInfo(pdJhid,eqName);
//        System.out.println(selectMapper.findInfo(pdJhid,eqName));
        return new PageInfo<>(listAll);
    }


    public PageInfo<SgPdZt>  findYipan(String pdJhid, String eqName, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<SgPdZt> listYipan = selectMapper.findYipan(pdJhid,eqName);
        return new PageInfo<>(listYipan);
    }
    public PageInfo<SgPdZt>  findPanying(String pdJhid, String eqName, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<SgPdZt> listPanying = selectMapper.findPanying(pdJhid,eqName);
        return new PageInfo<>(listPanying);
    }
    public PageInfo<SgPdZt> findPankui(String pdJhid, String eqName, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<SgPdZt> listPankui = selectMapper.findPankui(pdJhid,eqName);
        return new PageInfo<>(listPankui);
    }



    public PageInfo<ListNum> listNum(String pdJhid ,Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        ListNum getNum = selectMapper.getListNum(pdJhid);
//        System.out.println(getNum);

        return new PageInfo<>();
    }
}



