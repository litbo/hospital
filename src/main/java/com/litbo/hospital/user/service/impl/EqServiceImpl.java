package com.litbo.hospital.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.dao.EqDao;
import com.litbo.hospital.user.service.EqService;
import com.litbo.hospital.user.vo.EqShowVo;
import com.litbo.hospital.user.vo.EqVo;
import com.litbo.hospital.user.vo.SelectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EqServiceImpl implements EqService {

    @Autowired
    EqDao eqDao;
    @Override
    public List<EqVo> getAllEq() {
        return eqDao.getAllEq();
    }

    @Override
    public PageInfo listShowEqs(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqDao.listShowEqs());
    }

    @Override
    public int addEq(EqInfo eqInfo) {

        return eqDao.addEq(eqInfo);
    }

    @Override
    public PageInfo listEqByX(int pageNum, int pageSize, SelectVo selectVo) {
        PageHelper.startPage(pageNum,pageSize);

        return new PageInfo(eqDao.listEqByX(selectVo));
    }


}
