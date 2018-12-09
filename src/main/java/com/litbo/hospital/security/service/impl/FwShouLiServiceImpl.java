package com.litbo.hospital.security.service.impl;

import com.litbo.hospital.security.bean.FwLcjl;
import com.litbo.hospital.security.bean.FwShouli;
import com.litbo.hospital.security.dao.FwBaoxiuDao;
import com.litbo.hospital.security.dao.FwLcjlDao;
import com.litbo.hospital.security.dao.FwShouLiDao;
import com.litbo.hospital.security.enums.EnumProcess;
import com.litbo.hospital.security.service.FwShouLiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author zjc
 * @create 2018-12-06 9:28
 */
@Service
public class FwShouLiServiceImpl implements FwShouLiService {

    @Autowired
    private FwShouLiDao fwShouLiDao;

    @Autowired
    private FwLcjlDao fwLcjlDao;

    @Autowired
    private FwBaoxiuDao fwBaoxiuDao;

    @Transactional
    @Override
    public void addShouli(FwShouli fwShouli) {
        fwShouLiDao.addShouLi(fwShouli);
        fwBaoxiuDao.updateBaoxiuStatus(fwShouli.getId(),EnumProcess.FW_GZ_JX.getCode());
        FwLcjl fwLcjl = new FwLcjl();
        fwLcjl.setCreatTime(new Date());
        fwLcjl.setBxId(fwShouli.getId());
        fwLcjl.setUserId(fwShouli.getSlrId());
        fwLcjl.setLc(EnumProcess.FW_BX_SL.getMessage());
        fwLcjlDao.insertFwLcjl(fwLcjl);
    }
}
