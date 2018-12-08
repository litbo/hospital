package com.litbo.hospital.beneficial.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.beneficial.dao.SbcwDao;
import com.litbo.hospital.beneficial.service.SbcwService;
import com.litbo.hospital.beneficial.vo.CbMhVo;
import com.litbo.hospital.beneficial.vo.XyFxVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class SbcwServiceImpl implements SbcwService {
    @Autowired
    private SbcwDao sbcwDao;

    @Override
    public PageInfo listZjcb(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(sbcwDao.listZjcb());
    }

    @Override
    public PageInfo listZjcbByX(int pageNum, int pageSize, CbMhVo cbMhVo) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(sbcwDao.listZjcbByX(cbMhVo));
    }

    @Override
    public PageInfo listJjcb(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(sbcwDao.listJjcb());
    }

    public PageInfo listJjcbByX(int pageNum, int pageSize, CbMhVo cbMhVo) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(sbcwDao.listJjcbByX(cbMhVo));
    }

    @Override
    public PageInfo listSr(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(sbcwDao.listSr());
    }

    public PageInfo listSrByX(int pageNum, int pageSize, CbMhVo cbMhVo) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(sbcwDao.listSrByX(cbMhVo));
    }

    @Override
    public PageInfo listXyFx(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<XyFxVo> list1 = sbcwDao.listXyFx();
        List<XyFxVo> list2 = new ArrayList<XyFxVo>();
        Iterator it = list1.iterator();
        while (it.hasNext()){
            XyFxVo xyFxVo = (XyFxVo)it.next();
            xyFxVo.setSy(xyFxVo.getSr().subtract(xyFxVo.getCb()));
            if(xyFxVo.getQjlc()!=0) {
                xyFxVo.setZcsr(xyFxVo.getSr().divide(BigDecimal.valueOf(xyFxVo.getQjlc()), 4, RoundingMode.HALF_UP));
                xyFxVo.setZccb(xyFxVo.getCb().divide(BigDecimal.valueOf(xyFxVo.getQjlc()), 4, RoundingMode.HALF_UP));
            }else {
                xyFxVo.setQjlc(0);
                xyFxVo.setZcsr(xyFxVo.getSr());
                xyFxVo.setZccb(xyFxVo.getCb());
            }
            xyFxVo.setZcsy(xyFxVo.getZcsr().subtract(xyFxVo.getZccb()));
            list2.add(xyFxVo);
        }
        return new PageInfo(list2);
    }

    public PageInfo listXyFxByX(int pageNum, int pageSize, CbMhVo cbMhVo) {
        PageHelper.startPage(pageNum,pageSize);
        List<XyFxVo> list1 = sbcwDao.listXyFxByX(cbMhVo);
        List<XyFxVo> list2 = new ArrayList<XyFxVo>();
        Iterator it = list1.iterator();
        while (it.hasNext()){
            XyFxVo xyFxVo = (XyFxVo)it.next();
            xyFxVo.setSy(xyFxVo.getSr().subtract(xyFxVo.getCb()));
            if(xyFxVo.getQjlc()!=0) {
                xyFxVo.setZcsr(xyFxVo.getSr().divide(BigDecimal.valueOf(xyFxVo.getQjlc()), 4, RoundingMode.HALF_UP));
                xyFxVo.setZccb(xyFxVo.getCb().divide(BigDecimal.valueOf(xyFxVo.getQjlc()), 4, RoundingMode.HALF_UP));
            }else {
                xyFxVo.setQjlc(0);
                xyFxVo.setZcsr(xyFxVo.getSr());
                xyFxVo.setZccb(xyFxVo.getCb());
            }
            xyFxVo.setZcsy(xyFxVo.getZcsr().subtract(xyFxVo.getZccb()));
            list2.add(xyFxVo);
        }
        return new PageInfo(list2);
    }
}
