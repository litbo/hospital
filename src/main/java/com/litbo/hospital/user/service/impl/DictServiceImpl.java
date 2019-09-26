package com.litbo.hospital.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.user.vo.DictVo;
import com.litbo.hospital.user.bean.*;
import com.litbo.hospital.user.dao.DictDao;
import com.litbo.hospital.user.service.DictService;
import com.litbo.hospital.user.vo.SIntVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DictServiceImpl implements DictService{

    @Autowired
    DictDao dictDao;

    @Override
    public List<EqZjly> listZjlys() {

        return dictDao.listZjlys();
    }

    @Override
    public List<EqJldw> listJldw() {
        return dictDao.listJldw();
    }

    @Override
    public List<EqCxfl> listCxfl() {
        return dictDao.listCxfl();
    }

    @Override
    public List<EqQdfs> listQdfs() {
        return dictDao.listQdfs();
    }

    @Override
    public List<EqGzlb> listGzlb() {
        return dictDao.listGzlb();
    }

    @Override
    public PageInfo listJczd(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        return  new PageInfo(dictDao.listJczd());
    }

    @Override
    public PageInfo listDictByTName(int pageNum, int pageSize, String tName) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dictDao.listDictByTName(tName));
    }

    @Override
    public PageInfo listZyzd(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        return  new PageInfo(dictDao.listZyzd());
    }

    @Override
    public Integer addDictByTName(String tName, String dictName) {
        SIntVo sIntVo = dictDao.getLastIdByTName(tName);
        String sdictId=null;
        Integer dictId=null;
        if(sIntVo.getId()!=null){
          dictId = sIntVo.getId()+1;
        }
        if(sIntVo.getSId()!=null){
            sdictId = String.valueOf(Integer.parseInt(sIntVo.getSId().trim())+1);
        }
        try{
            dictDao.addDictByTName(tName,dictName,sdictId,dictId);
            return 1;
        }catch (Exception e){
            return 0;
        }


    }


}
