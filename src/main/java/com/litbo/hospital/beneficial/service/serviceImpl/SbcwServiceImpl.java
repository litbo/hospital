package com.litbo.hospital.beneficial.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.beneficial.dao.SbcwDao;
import com.litbo.hospital.beneficial.service.SbcwService;
import com.litbo.hospital.beneficial.vo.*;
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
    public PageInfo listZjcb(int pageNum, int pageSize,Date kssj,Date jssj) {
        PageHelper.startPage(pageNum,pageSize);
        List<ZjcbVo> list = sbcwDao.listZjcb(kssj, jssj);
        list.forEach(item->{
             if(item.getYlsbzjf()!=null){
                 item.setGdzczjf(item.getYlsbzjf().add(item.getGdzczjf()));
             }
             item.setZj(item.getRyjf().add(item.getWsclf()).add(item.getYpf()).
                     add(item.getGdzczjf()).add(item.getWxzctxf()).add(item.getYlfxf()).add(item.getQt()));
        });
        PageInfo<ZjcbVo> info = new PageInfo<>(list);
        return info;
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
    public PageInfo listJjcb(int pageNum, int pageSize,Date qs,Date js) {
        PageHelper.startPage(pageNum,pageSize);
        List<JjcbVo> list = sbcwDao.listJjcb(qs, js);
        list.forEach(item->{
            item.setZj(item.getFzkscb().add(item.getGlfy()).add(item.getQt()));
        });
        PageInfo<JjcbVo> info = new PageInfo<>(list);
        return info;
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
    public PageInfo listSr(int pageNum, int pageSize,Date qs,Date js) {
        PageHelper.startPage(pageNum,pageSize);
        List<SrVo> list = sbcwDao.listSr(qs, js);
        list.forEach(item->{
            item.setZj(item.getMzsr().add(item.getKjxmsr()).add(item.getZysr()).add(item.getQt()));
        });
        return new PageInfo(list);
    }

    @Override
    public List<SrVo> SrBobiao(Date qs, Date js) {
        List<SrVo> vos = sbcwDao.listSr(qs, js);
        vos.forEach(item->{
            item.setZj(item.getMzsr().add(item.getKjxmsr()).add(item.getZysr()).add(item.getQt()));
        });
        return vos;
    }

    @Override
    public PageInfo listSrByX(int pageNum, int pageSize, CbMhVo cbMhVo) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(sbcwDao.listSrByX(cbMhVo));
    }

    @Override
    public List listSrByXExport(CbMhVo cbMhVo) {
        return sbcwDao.listSrByX(cbMhVo);
    }

    @Override
    public PageInfo listXyFx(int pageNum, int pageSize,Date qs,Date js) {
        PageHelper.startPage(pageNum,pageSize);
        List<XyFxVo> list1 = sbcwDao.listXyFx(qs,js);
//        List<XyFxVo> list2 = new ArrayList<XyFxVo>();
//        Iterator it = list1.iterator();
        list1.forEach(xyFxVo->{
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
        });
//        while (it.hasNext()){
//            XyFxVo xyFxVo = (XyFxVo)it.next();
//            xyFxVo.setSy(xyFxVo.getSr().subtract(xyFxVo.getCb()));
//            if(xyFxVo.getQjlc()!=0) {
//                xyFxVo.setZcsr(xyFxVo.getSr().divide(BigDecimal.valueOf(xyFxVo.getQjlc()), 4, RoundingMode.HALF_UP));
//                xyFxVo.setZccb(xyFxVo.getCb().divide(BigDecimal.valueOf(xyFxVo.getQjlc()), 4, RoundingMode.HALF_UP));
//            }else {
//                xyFxVo.setQjlc(0);
//                xyFxVo.setZcsr(xyFxVo.getSr());
//                xyFxVo.setZccb(xyFxVo.getCb());
//            }
//            xyFxVo.setZcsy(xyFxVo.getZcsr().subtract(xyFxVo.getZccb()));
//            list2.add(xyFxVo);
//        }
        PageInfo info = new PageInfo(list1);
        return info;
    }

    @Override
    public List<XyFxVo> XyfxBaobiao(Date qs, Date js) {
        List<XyFxVo> vos = sbcwDao.listXyFx(qs, js);
        vos.forEach(xyFxVo->{
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
        });
        return vos;
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
    public PageInfo listXyPj(int pageNum, int pageSize,Date qs,Date js) {
        PageHelper.startPage(pageNum,pageSize);
        List<XyPjVo> list1 = sbcwDao.listXyPj(qs,js);
        list1.forEach(xyPjVo->{
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
            int nsy = (xyPjVo.getSy().intValue())/y;
            if(nsy!=0)
                xyPjVo.setHbq(xyPjVo.getEqPrice().intValue() / nsy);
            else     xyPjVo.setHbq(0);
        });
//        List<XyPjVo> list2 = new ArrayList<XyPjVo>();
//        Iterator it = list1.iterator();
//        while (it.hasNext()) {
//            XyPjVo xyPjVo = (XyPjVo) it.next();
//            if (xyPjVo.getEqPrice() != BigDecimal.valueOf(0)) {
//                //求收益率
//                BigDecimal sylXs = xyPjVo.getSy().divide(xyPjVo.getEqPrice(), 4, RoundingMode.HALF_UP);
//                //将收益率转化为两位小数
//                BigDecimal  b =sylXs.setScale(2, RoundingMode.HALF_UP);
//                //将收益率转化为百分数
//                NumberFormat percent = NumberFormat.getPercentInstance();
//                percent.setMaximumFractionDigits(2);
//                xyPjVo.setSyl(percent.format(b.doubleValue()));
//            } else {
//                xyPjVo.setSyl("0");
//            }
//
//            //获取当前年份
//            Calendar date = Calendar.getInstance();
//            String year = String.valueOf(date.get(Calendar.YEAR));
//            //获取启用年份
//            Date qyDate = xyPjVo.getEqQysj();
//            Calendar calendar = Calendar.getInstance();
//            if(qyDate==null){
//                calendar.setTime(new Date());
//            }
//            else {
//                calendar.setTime(qyDate);
//            }
//            String year1 = String.valueOf(calendar.get(Calendar.YEAR));
//            //使用多少年
//            int y = Integer.parseInt(year) - Integer.parseInt(year1) + 1;
//            //年收益
//            int nsy = (xyPjVo.getSy().intValue())/y;
//            if(nsy!=0)
//                xyPjVo.setHbq(xyPjVo.getEqPrice().intValue() / nsy);
//            else     xyPjVo.setHbq(0);
//
//            list2.add(xyPjVo);
//        }
        PageInfo info = new PageInfo(list1);
        return info;
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
