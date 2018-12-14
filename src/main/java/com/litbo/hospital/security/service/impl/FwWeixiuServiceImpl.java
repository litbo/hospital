package com.litbo.hospital.security.service.impl;

import com.litbo.hospital.security.bean.FwLcjl;
import com.litbo.hospital.security.bean.FwWeixiu;
import com.litbo.hospital.security.bean.FwWxqs;
import com.litbo.hospital.security.dao.FwBaoxiuDao;
import com.litbo.hospital.security.dao.FwLcjlDao;
import com.litbo.hospital.security.dao.FwWeixiuDao;
import com.litbo.hospital.security.enums.EnumProcess;
import com.litbo.hospital.security.service.FwWeixiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author zjc
 * @create 2018-12-06 13:05
 */
@Service
public class FwWeixiuServiceImpl implements FwWeixiuService {

    @Autowired
    private FwWeixiuDao fwWeixiuDao;

    @Autowired
    private FwLcjlDao fwLcjlDao;

    @Autowired
    private FwBaoxiuDao fwBaoxiuDao;

    @Override
    @Transactional
    public void addFwWeixiu(FwWeixiu fwWeixiu,String userId) {
        fwWeixiuDao.addFwWeiXiu(fwWeixiu);
        if(fwWeixiu.getGzwxFs()==EnumProcess.FW_ZJWX.getCode()){
            fwBaoxiuDao.updateBaoxiuStatus(fwWeixiu.getFwId(),EnumProcess.FW_WX_QR.getCode());
        }
        fwBaoxiuDao.updateBaoxiuStatus(fwWeixiu.getFwId(),fwWeixiu.getGzwxFs());
        FwLcjl fwLcjl = new FwLcjl();
        fwLcjl.setUserId(userId);
        fwLcjl.setCreatTime(new Date());
        fwLcjl.setBxId(fwWeixiu.getFwId());
        fwLcjl.setLc(EnumProcess.FW_GZ_JX.getMessage());
        fwLcjlDao.insertFwLcjl(fwLcjl);
    }

    @Override
    @Transactional
    public void addFwWxqs(FwWxqs fwWxqs,String userId) {
        fwWeixiuDao.addFwWxqr(fwWxqs);
        fwBaoxiuDao.updateBaoxiuStatus(fwWxqs.getFwId(),EnumProcess.FW_WX_SH.getCode());
        FwLcjl fwLcjl = new FwLcjl(userId,new Date(),fwWxqs.getFwId(),EnumProcess.FW_WX_QR.getMessage());
        fwLcjlDao.insertFwLcjl(fwLcjl);
    }

    @Override
    public void updateFwWxqs(String userId,String fwId) {
        fwWeixiuDao.updateFwWxsh(userId,fwId);
        fwBaoxiuDao.updateBaoxiuStatus(fwId,EnumProcess.FW_WX_OVER.getCode());
        FwLcjl fwLcjl = new FwLcjl(userId,new Date(),fwId,EnumProcess.FW_WX_QR.getMessage());
        fwLcjlDao.insertFwLcjl(fwLcjl);
    }


}
