package com.litbo.hospital.user.service.impl;

import com.litbo.hospital.user.bean.*;
import com.litbo.hospital.user.dao.DictDao;
import com.litbo.hospital.user.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
