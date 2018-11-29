package com.litbo.hospital.security.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwBlsj;
import com.litbo.hospital.security.bean.FwPjzd;
import com.litbo.hospital.security.dao.FwBlsjDao;
import com.litbo.hospital.security.service.FwBlsjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FwBlsjServiceImpl implements FwBlsjService {
    @Autowired
    private FwBlsjDao blsjDao;

    @Override
    public int insertFwBlsj(FwBlsj blsj) {
        return blsjDao.insertFwBlsj(blsj);

    }

    @Override
    public PageInfo listFwBlsj(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(blsjDao.listFwBlsj());
    }
}
