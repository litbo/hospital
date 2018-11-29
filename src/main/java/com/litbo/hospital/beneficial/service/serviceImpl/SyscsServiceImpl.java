package com.litbo.hospital.beneficial.service.serviceImpl;

import com.litbo.hospital.beneficial.dao.SyscsDao;
import com.litbo.hospital.beneficial.service.SyscsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SyscsServiceImpl implements SyscsService {

    @Autowired
    private SyscsDao syscsDao;

    @Override
    public Integer InsertKjjzr(Integer kjjzr) {
        return syscsDao.insertKjjzr(kjjzr);
    }

    @Override
    public Integer UpdateKjjzr(Integer kjjzr) {
        return 0;
    }

    @Override
    public Integer InsertYlfx(float ylfx) {
        return syscsDao.insertYlfx(ylfx);
    }

    @Override
    public Integer UpdateYlfx(float ylfx) {
        return null;
    }
}
