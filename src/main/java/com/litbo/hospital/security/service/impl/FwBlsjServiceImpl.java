package com.litbo.hospital.security.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwBlsj;
import com.litbo.hospital.security.bean.FwLcjl;
import com.litbo.hospital.security.dao.FwBaoxiuDao;
import com.litbo.hospital.security.dao.FwBlsjDao;
import com.litbo.hospital.security.dao.FwLcjlDao;
import com.litbo.hospital.security.enums.EnumProcess;
import com.litbo.hospital.security.service.FwBlsjService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class FwBlsjServiceImpl implements FwBlsjService {
    @Autowired
    private FwBlsjDao blsjDao;
    @Autowired
    private FwLcjlDao lcjlDao;
    @Autowired
    private FwBaoxiuDao baoxiuDao;
    @Override
    @Transactional
    public int insertFwBlsj(FwBlsj blsj) {
        blsj.setBgTime(new Date());
        if(StringUtils.isNotBlank(blsj.getBxdh())){//如果保修单号不为空，存入流程
            FwLcjl lcjl = new FwLcjl();
            lcjl.setCreatTime(new Date());
            lcjl.setLc(EnumProcess.FW_BLSJ.getMessage());
            lcjl.setBxId(blsj.getBxdh());
            lcjl.setUserId(blsj.getUserId());
            lcjlDao.insertFwLcjl(lcjl);
            baoxiuDao.updateBaoxiuStatus(blsj.getBxdh(),EnumProcess.FW_BLSJ.getCode());//报修单状态更改
        }
        return blsjDao.insertFwBlsj(blsj);
    }

    @Override
    public PageInfo listFwBlsj(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(blsjDao.listFwBlsj());
    }
}
