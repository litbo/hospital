package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.dao.PxDelAndSelDao;
import com.litbo.hospital.security.service.PxDelAndSelService;
import com.litbo.hospital.security.vo.EmpVo;
import com.litbo.hospital.security.vo.TjRyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PxDelAndSelServiceImpl implements PxDelAndSelService {

    @Autowired(required = false)
    PxDelAndSelDao pxDelAndSelDao;

    public Integer DelRyjh(int pageNum,int pageSize){
        return pxDelAndSelDao.DelRyjh();
    }

    public Integer DelYyjh(int pageNum,int pageSize){
        return pxDelAndSelDao.DelYyjh();
    }

    @Override
    public PageInfo selRyjh(int pageNum, int pageSize, String name) {

        return new PageInfo(pxDelAndSelDao.selRyjh(name));
    }

    @Override
    public List<EmpVo> getRyBtNr(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<EmpVo> list = pxDelAndSelDao.getRyBtNr();
        return list;
    }

    @Override
    public PageInfo selYyjh(int pageNum,int pageSize,String eqName)
     {
        return new PageInfo(pxDelAndSelDao.selYyJh(eqName));
     }

    @Override
    public List<TjRyVo> selectRy(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pxDelAndSelDao.selectRy();
    }

    @Override
    public Integer insertRy(TjRyVo tjRyVo) {
        tjRyVo.setTjryId(UUID.randomUUID().toString());
        return pxDelAndSelDao.insertRy(tjRyVo);
    }
}
