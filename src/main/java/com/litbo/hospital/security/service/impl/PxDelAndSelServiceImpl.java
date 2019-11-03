package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.dao.PxDelAndSelDao;
import com.litbo.hospital.security.service.PxDelAndSelService;
import com.litbo.hospital.security.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<XqZsVo> xqZsVos =  pxDelAndSelDao.findAllRy(id);
        DsVo dVos = pxDelAndSelDao.findN(id);
        List<DVo> dVoList = new ArrayList<>();
        List<JhVo> jhVoList = new ArrayList<>();
        if(xqZsVos.size()<=0){
            JhVo vos = new JhVo();
            vos.setEqName(dVos.getEqName());
            vos.setJstime(dVos.getJstime());
            vos.setKstime(dVos.getKstime());
            jhVoList.add(vos);
            return new PageInfo(jhVoList);
        }else{
            for(XqZsVo x:xqZsVos){
                DVo vos = new DVo();
                vos.setUserId(x.getUserId());
                vos.setBmName(x.getBmName());
                vos.setUserName(x.getUserName());
                vos.setEqName(dVos.getEqName());
                vos.setJstime(dVos.getJstime());
                vos.setKstime(dVos.getKstime());
                dVoList.add(vos);
            }
//            for(DVo V:dVoList){
//                System.out.println(V);
//            }
        }
        return new PageInfo(dVoList);
    }
}
