package com.litbo.hospital.security.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwBlsj;
import com.litbo.hospital.security.bean.FwLcjl;
import com.litbo.hospital.security.bean.FwPjzd;
import com.litbo.hospital.security.dao.FwBlsjDao;
import com.litbo.hospital.security.dao.FwLcjlDao;
import com.litbo.hospital.security.enums.EnumProcess;
import com.litbo.hospital.security.service.FwBlsjService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.invoke.empty.Empty;

import java.util.Date;
import java.util.List;

@Service
public class FwBlsjServiceImpl implements FwBlsjService {
    @Autowired
    private FwBlsjDao blsjDao;
    @Autowired
    private FwLcjlDao lcjlDao;
    @Override
    public int insertFwBlsj(FwBlsj blsj) {
        blsj.setBgTime(new Date());

        if(StringUtils.isNotBlank(blsj.getBxdh())){
            FwLcjl lcjl = new FwLcjl();
            lcjl.setCreatTime(new Date());
            lcjl.setLc(EnumProcess.FW_BLSJ.getMessage());
            lcjl.setBxId(blsj.getBxdh());
            lcjl.setUserId(blsj.getUserId());
            lcjlDao.insertFwLcjl(lcjl);
        }
        return blsjDao.insertFwBlsj(blsj);

    }

    @Override
    public PageInfo listFwBlsj(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(blsjDao.listFwBlsj());
    }
}
