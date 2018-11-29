package com.litbo.hospital.security.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwPjzd;
import com.litbo.hospital.security.dao.FwPjzdDao;
import com.litbo.hospital.security.service.FwPjzdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FwPjzdServiceImpl implements FwPjzdService {
    @Autowired
    private FwPjzdDao pjzdDao;
    public List<FwPjzd> listPjzd(){

        List<FwPjzd> list = pjzdDao.listPjzd();
        return  list;
    }

    @Override
    public int insetFwPjzd(FwPjzd pjzd) {
        return pjzdDao.insertPjzd(pjzd);
    }
}
