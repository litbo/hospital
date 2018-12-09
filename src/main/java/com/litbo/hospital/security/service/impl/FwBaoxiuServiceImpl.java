package com.litbo.hospital.security.service.impl;

import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.security.bean.FwBaoxiu;
import com.litbo.hospital.security.bean.FwLcjl;
import com.litbo.hospital.security.dao.FwBaoxiuDao;
import com.litbo.hospital.security.dao.FwLcjlDao;
import com.litbo.hospital.security.enums.EnumProcess;
import com.litbo.hospital.security.service.FwBaoxiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author zjc
 * @create 2018-12-03 11:13
 */
@Service
public class FwBaoxiuServiceImpl implements FwBaoxiuService {

    @Autowired
    private FwBaoxiuDao fwBaoxiuDao;

    @Autowired
    private FwLcjlDao fwLcjlDao;

    @Transactional
    @Override
    public void addBaoxiu(FwBaoxiu fwBaoxiu) {
        //添加到报修单
        String id = IDFormat.getIdByIDAndTime("fw_baoxiu", "id");
        fwBaoxiu.setId(id);
        fwBaoxiu.setBxTime(new Date());
        fwBaoxiu.setBxStatus(EnumProcess.FW_BX_SL.getCode());
        fwBaoxiu.setJjxStatus(1);
        fwBaoxiuDao.addBaoxiu(fwBaoxiu);
        //添加流程记录
        FwLcjl fwLcjl = new FwLcjl();
        fwLcjl.setUserId(fwBaoxiu.getBxrId());
        fwLcjl.setBxId(id);
        fwLcjl.setCreatTime(new Date());
        fwLcjl.setLc(EnumProcess.FW_GZ_BX.getMessage());
        fwLcjlDao.insertFwLcjl(fwLcjl);
    }

    @Override
    @Transactional
    public void updateBaoxiuStatusById(String id, Integer baoxiuStatus) {
        fwBaoxiuDao.updateBaoxiuStatus(id,baoxiuStatus);
    }
}
