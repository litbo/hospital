package com.litbo.hospital.security.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.dao.KhDao;
import com.litbo.hospital.security.dao.PxDao;
import com.litbo.hospital.security.service.KhService;
import com.litbo.hospital.security.service.PxService;
import com.litbo.hospital.security.vo.KsFzVo;
import com.litbo.hospital.security.vo.RyPxJhVo;
import com.litbo.hospital.security.vo.YyPxJhVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KhServiceImpl implements KhService{

    @Autowired(required = false)
    KhDao khDao;

    @Override
    public void khBc() {

    }

    @Override
    public PageInfo kh(int pageNum, int pageSize, String id) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(khDao.kh(id));
    }
}
