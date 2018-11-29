package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwHt;
import com.litbo.hospital.security.dao.FwHtDao;
import com.litbo.hospital.security.service.FwHtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zjc
 * @create 2018-11-29 19:36
 */
@Service
public class FwHtServiceImpl implements FwHtService {

    @Autowired
    private FwHtDao fwHtDao;

    @Override
    public int addFwHt(FwHt fwHt) {
        String id = IDFormat.getIdByIDAndTime("fw_ht", "id");
        fwHt.setId(id);
        int i = fwHtDao.addFwHt(fwHt);
        return i;
    }

    @Override
    public Result getAllFwHt(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<FwHt> pageInfo = new PageInfo<>(fwHtDao.getAllFwHt());
        return Result.success(pageInfo);
    }
}
