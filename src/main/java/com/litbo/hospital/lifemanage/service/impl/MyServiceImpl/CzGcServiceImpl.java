package com.litbo.hospital.lifemanage.service.impl.MyServiceImpl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.lifemanage.bean.MyBean.CzGc;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.CzGcShowEqVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.CzGcVO;
import com.litbo.hospital.lifemanage.dao.MyMapper.CzGcMapper;
import com.litbo.hospital.lifemanage.dao.MyMapper.EqTjsqMapper;
import com.litbo.hospital.lifemanage.service.MyService.CzGcService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CzGcServiceImpl implements CzGcService {
    @Autowired
    private CzGcMapper mapper;
    @Autowired
    private EqTjsqMapper tjsqMapper;


    @Override
    public PageInfo<CzGc> AllDshCzgc(Integer pageNum, Integer pageSize, String bh, String mc, String ngr, Date qssj, Date jssj) {
        PageHelper.startPage(pageNum, pageSize);

        List<CzGc> gcs = mapper.AllDshCzgc(bh, mc, ngr, qssj, jssj);
        gcs.forEach(item -> {
            if (item.getCzGcZpjsqr() != null && StringUtils.isBlank(item.getCzGcZpjShr()) ) {
                item.setShlx("1");
            } else {
                item.setShlx("0");
            }
        });
        return new PageInfo<>(gcs);
    }

    @Override
    public int insertCzgc(CzGc gc) {

        gc.setId("ST-OPE-"+ IDFormat.getIdByIDAndTime3("cz_gc","id"));
        return mapper.insertCzgc(gc);
    }

    @Override
    public int ShAfterUpdate(CzGc gc) {
      boolean zpjtg=false;
        /*再评价审核时*/
        if (StringUtils.isNotBlank(gc.getCzGcZpjShr()) && StringUtils.isNotBlank(gc.getCzGcZpjsqr())) {
            /*再评价审核通过时*/
            if("1".equals(gc.getCzGcZpjShjg())){
                gc.setCzGcNr(gc.getCzGcNrdxg());
                gc.setCzGcBbh(gc.getCzGcBbhdxg());
                gc.setCzGcZys(gc.getCzGcZysdxg());
                gc.setCzGcZt("1");
                gc.setCzGcSxrq(new Date());
                zpjtg=true;

            }

            /*审核未通过时啥也不干*/
            CzGcVO vo = mapper.selectOneCzgc(gc.getId());
            BeanUtil.copyProperties(gc, vo, true,
                    CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            BeanUtil.copyProperties(vo, gc, true,
                    CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            gc.setCzGcZpjjd("1");
        }
        /*普通审核啥也不干*/
        else{
            gc.setCzGcSxrq(gc.getCzGcShrq());
        }
        CzGcVO vo = mapper.selectOneCzgc(gc.getId());
        BeanUtil.copyProperties(gc, vo, true,
                CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        BeanUtil.copyProperties(vo, gc, true,
                CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        if(zpjtg){
            gc.setCzGcBakssj(null);
        }
        return mapper.updateOneCzgc(gc);
    }

    @Override
    public int updateOneCzgc(CzGc gc) {

        CzGcVO oldvo = mapper.selectOneCzgc(gc.getId());
        BeanUtil.copyProperties(gc, oldvo, true,
                CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        BeanUtil.copyProperties(oldvo, gc, true,
                CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        /*是否为再评价申请*/

        if(StringUtils.isNotBlank(gc.getCzGcZpjsqr())){
            gc.setCzGcZpjShjg(null);
            gc.setCzGcZpjShr(null);
            gc.setCzGcZpjShyj(null);
            gc.setCzGcZpjjd("0");
        }
        return mapper.updateOneCzgc(gc);

    }

    @Override
    public int updateCzgcZt(String id) {
        CzGcVO vo = mapper.selectOneCzgc(id);
        if(vo.getCzGcQykssj()!=null){
            return mapper.updateCzgcZt(id, null);
        }
        else{
            return mapper.updateCzgcZt(id, new Date());
        }
    }

    @Override
    public PageInfo<CzGc> Tjcx(Integer pageNum, Integer pageSize, String zt, Date qssj, Date jssj, String bh, String mc) {
        PageHelper.startPage(pageNum, pageSize);
        List<CzGc> gcs = mapper.Tjcx(zt, qssj, jssj, bh, mc);
        System.out.println();
        gcs.forEach(item->{
            Date date = item.getCzGcSxrq();
            if(date!=null){
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.DATE,30);
                if("1".equals(item.getCzGcZt())){
                    if(new Date().getTime()>=cal.getTime().getTime()){
                        item.setCzGcZt("2");
                        item.setCzGcBakssj(cal.getTime());
                        updateOneCzgc(item);
                    }
                }
            }

        });

        return new PageInfo<>(gcs);
    }

    @Override
    public CzGcVO selectOneCzgc(String id) {
        CzGcVO vo = mapper.selectOneCzgc(id);
        CzGcShowEqVO eq = mapper.selectEqBySbbh(vo.getEqSbbh());
        BeanUtil.copyProperties(eq, vo, true,
                CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        vo.setBmName(tjsqMapper.selectBmNameByBmid(vo.getBmId()));
        return vo;
    }
}
