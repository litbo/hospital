package com.litbo.hospital.security.service.impl;

import com.litbo.hospital.security.dao.PxDelAndSelDao;
import com.litbo.hospital.security.service.PxDelAndSelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
