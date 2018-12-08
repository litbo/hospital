package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SZhidu;
import com.litbo.hospital.supervise.bean.SZhiduzhizeZt;
import com.litbo.hospital.supervise.dao.ZhiduDao;
import com.litbo.hospital.supervise.service.ZhiduService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ZhiduServiceImpl implements ZhiduService {
    @Autowired
    private ZhiduDao zhiduDao;
    @Override
    public PageInfo getZds(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SZhidu> date =  zhiduDao.getZds();
        return new PageInfo(date);
    }

    @Override
    public void saveZd(SZhidu zd) {
        zhiduDao.saveZd(zd);
    }

    @Override
    public void deteleZd(int zd_id) {
        zhiduDao.deteleZd(zd_id);
    }

    @Override
    public void updateZd(SZhidu zd) {
        zhiduDao.updateZd(zd);
    }

    @Override
    public void submit(SZhidu zd, String shr_id) {
        //先保存制度信息
        zhiduDao.saveZd(zd);
        SZhiduzhizeZt ztc = new SZhiduzhizeZt();
        ztc.setZdId(zd.getZdId());
        ztc.setUserId(zd.getUserId());
        ztc.setZtDate(zd.getCreateTime());
        ztc.setZtCzname("提交");
        ztc.setZtCzzt("1");
        zhiduDao.saveZdZz(ztc);
        //准备状态信息  插入审核信息信息
        SZhiduzhizeZt zt = new SZhiduzhizeZt();
        zt.setZdId(zd.getZdId());
        zt.setUserId(shr_id);
        zt.setZtDate(zd.getCreateTime());
        zt.setZtCzname("待审核");
        zt.setZtCzzt("0");
        zhiduDao.saveZdZz(zt);
    }
}
