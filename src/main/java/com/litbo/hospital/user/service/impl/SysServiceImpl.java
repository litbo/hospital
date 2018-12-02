package com.litbo.hospital.user.service.impl;

import com.litbo.hospital.user.bean.SysDxm;
import com.litbo.hospital.user.bean.SysWjbb;
import com.litbo.hospital.user.bean.SysZxsj;
import com.litbo.hospital.user.dao.SysDao;
import com.litbo.hospital.user.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysServiceImpl implements SysService {
    @Autowired
    private SysDao sysDao;

    @Override
    public int setWjbb(SysWjbb wjbb) {
        String bname = "sys_wjbb";
        if(sysDao.count(bname)>0){
            return sysDao.updateWjbb(wjbb);
        }
        return sysDao.addWjbb(wjbb);
    }

    @Override
    public int setDxm(SysDxm dxm) {
        String bname = "sys_dxm";
        if(sysDao.count(bname)>0){
            return sysDao.updateDxm(dxm);
        }
        return sysDao.addDxm(dxm);
    }

    @Override
    public int setZxsj(SysZxsj zxsj) {
        String bname = "sys_zxsj";
        if(sysDao.count(bname)>0){
            return sysDao.updateZxsj(zxsj);
        }
        return sysDao.addZxsj(zxsj);
    }
}
