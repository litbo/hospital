package com.litbo.hospital.beneficial.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.beneficial.dao.SbcwDao;
import com.litbo.hospital.beneficial.service.SbcwService;
import com.litbo.hospital.beneficial.vo.CbMhVo;
import com.litbo.hospital.beneficial.vo.XyFxVo;
import com.litbo.hospital.beneficial.vo.XyPjVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.*;

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
    public List listZjcbByXExport(CbMhVo cbMhVo) {
        return sbcwDao.listZjcbByX(cbMhVo);
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
    public List listJjcbByXExport(CbMhVo cbMhVo) {
        return sbcwDao.listJjcbByX(cbMhVo);
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
    public List listSrByXExport(CbMhVo cbMhVo) {
        return sbcwDao.listSrByX(cbMhVo);
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

    @Override
    public List listXyFxByXExport(CbMhVo cbMhVo) {
        return sbcwDao.listXyFxByX(cbMhVo);
    }

    @Override
    public PageInfo listXyPj(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<XyPjVo> list1 = sbcwDao.listXyPj();
        List<XyPjVo> list2 = new ArrayList<XyPjVo>();
        Iterator it = list1.iterator();
        while (it.hasNext()) {
            XyPjVo xyPjVo = (XyPjVo) it.next();
            if (xyPjVo.getEqPrice() != BigDecimal.valueOf(0)) {
                //求收益率
                BigDecimal sylXs = xyPjVo.getSy().divide(xyPjVo.getEqPrice(), 4, RoundingMode.HALF_UP);
                //将收益率转化为两位小数
                BigDecimal  b =sylXs.setScale(2, RoundingMode.HALF_UP);
                //将收益率转化为百分数
                NumberFormat percent = NumberFormat.getPercentInstance();
                percent.setMaximumFractionDigits(2);
                xyPjVo.setSyl(percent.format(b.doubleValue()));
            } else {
                xyPjVo.setSyl("0");
            }

            //获取当前年份
            Calendar date = Calendar.getInstance();
            String year = String.valueOf(date.get(Calendar.YEAR));
            //获取启用年份
            Date qyDate = xyPjVo.getEqQysj();
            Calendar calendar = Calendar.getInstance();
            if(qyDate==null){
                calendar.setTime(new Date());
            }
            else {
                calendar.setTime(qyDate);
            }
            String year1 = String.valueOf(calendar.get(Calendar.YEAR));
            //使用多少年
            int y = Integer.parseInt(year) - Integer.parseInt(year1) + 1;
            //年收益
            int nsy = xyPjVo.getSy().intValue()/y;

            xyPjVo.setHbq(xyPjVo.getEqPrice().intValue()/nsy);
            list2.add(xyPjVo);
        }
        return new PageInfo(list2);
    }

    @Override
    public PageInfo listXyPjByX(int pageNum, int pageSize, CbMhVo cbMhVo) {
        PageHelper.startPage(pageNum,pageSize);
        List<XyPjVo> list1 = sbcwDao.listXyPjByX(cbMhVo);
        List<XyPjVo> list2 = new ArrayList<XyPjVo>();
        Iterator it = list1.iterator();
        while (it.hasNext()) {
            XyPjVo xyPjVo = (XyPjVo) it.next();
            if (xyPjVo.getEqPrice() != BigDecimal.valueOf(0)) {
                //求收益率
                BigDecimal sylXs = xyPjVo.getSy().divide(xyPjVo.getEqPrice(), 4, RoundingMode.HALF_UP);
                //将收益率转化为两位小数
                BigDecimal  b =sylXs.setScale(2, RoundingMode.HALF_UP);
                //将收益率转化为百分数
                NumberFormat percent = NumberFormat.getPercentInstance();
                percent.setMaximumFractionDigits(2);
                xyPjVo.setSyl(percent.format(b.doubleValue()));
            } else {
                xyPjVo.setSyl("0");
            }

            //获取当前年份
            Calendar date = Calendar.getInstance();
            String year = String.valueOf(date.get(Calendar.YEAR));
            //获取启用年份
            Date qyDate = xyPjVo.getEqQysj();
            Calendar calendar = Calendar.getInstance();
            if(qyDate==null){
                calendar.setTime(new Date());
            }
            else {
                calendar.setTime(qyDate);
            }
            String year1 = String.valueOf(calendar.get(Calendar.YEAR));
            //使用多少年
            int y = Integer.parseInt(year) - Integer.parseInt(year1) + 1;
            //年收益
            int nsy = xyPjVo.getSy().intValue()/y;

            xyPjVo.setHbq(xyPjVo.getEqPrice().intValue()/nsy);
            list2.add(xyPjVo);
        }
        return new PageInfo(list2);
    }

    @Override
    public List listXyPjByXExport(CbMhVo cbMhVo) {
        return sbcwDao.listXyPjByX(cbMhVo);
    }
}
