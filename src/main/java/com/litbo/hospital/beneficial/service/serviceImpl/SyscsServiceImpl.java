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
    public Integer UpdateKjjzr(Integer kjjzr) {
        if((kjjzr<1)||(kjjzr>30)){
            return 0;
        }
        return syscsDao.updateKjjzr(kjjzr);
    }

    @Override
    public Integer UpdateYlfx(float ylfx) {
        if((ylfx<0.01)||(ylfx>0.03)){
            return 0;
        }
        return syscsDao.insertYlfx(ylfx);
    }
}
