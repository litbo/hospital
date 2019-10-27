package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.dao.PxDelAndSelDao;
import com.litbo.hospital.security.service.PxDelAndSelService;
import com.litbo.hospital.security.vo.EmpVo;
import com.litbo.hospital.security.vo.RyIdVo;
import com.litbo.hospital.security.vo.TjRyVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PxDelAndSelServiceImpl implements PxDelAndSelService {

    @Autowired(required = false)
    PxDelAndSelDao pxDelAndSelDao;

    @Override
    public PageInfo selByName(int pageNum,int pageSize,@Param("rName") String rName,@Param("id") String id) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(pxDelAndSelDao.selByName(rName,id));
    }

    @Override
    public List<RyIdVo> findUserId() {
        return pxDelAndSelDao.findUserId();
    }

    public Integer DelYyjh(String [] strs){
        return pxDelAndSelDao.DelYyjh(strs);
    }


    @Override
    public List<EmpVo> getRyBtNr(int pageNum, int pageSize,String id) {
        PageHelper.startPage(pageNum,pageSize);
        List<EmpVo> list = pxDelAndSelDao.getRyBtNr(id);
        return list;
    }

    @Override
    public PageInfo selYyjh(int pageNum,int pageSize,String name)
     {
         PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(pxDelAndSelDao.selYyJh(name));
     }

    @Override
    public List<TjRyVo> selectRy(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pxDelAndSelDao.selectRy();
    }

    @Override
    public Integer insertRy(@Param("tjRyVo") TjRyVo tjRyVo, @Param("id") String id) {
        tjRyVo.setTjryId(UUID.randomUUID().toString());
        tjRyVo.setJhId(id);
        return pxDelAndSelDao.insertRy(tjRyVo);
    }

    @Override
    public PageInfo findAllRy(int pageNum,int pageSize,String id) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(pxDelAndSelDao.findAllRy(id));
    }
}
