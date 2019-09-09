package com.litbo.hospital.lifemanage.service.impl.MyServiceImpl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.lifemanage.MyUtils.DelSpaceUtils;
import com.litbo.hospital.lifemanage.bean.Example.YjyaZdExample;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.YjyaLclogVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.YjyaZdVO;
import com.litbo.hospital.lifemanage.dao.MyMapper.EqTjsqMapper;
import com.litbo.hospital.lifemanage.dao.MyMapper.YjyaLclogMapper;
import com.litbo.hospital.lifemanage.dao.MyMapper.YjyaZdMapper;
import com.litbo.hospital.lifemanage.service.MyService.YjyaLclogService;
import com.litbo.hospital.lifemanage.service.MyService.YjyaZdService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class YjyaZdServiceImpl implements YjyaZdService {
    @Autowired
    private YjyaZdMapper mapper;
    @Autowired
    private YjyaLclogMapper logmapper;
    @Autowired
    private YjyaLclogService logservice;
@Autowired
private EqTjsqMapper tjmapper;
    @Override
    public int insertYjyaZd(YjyaZdVO vo) {
        String id = IDFormat.getIdByIDAndTime2("yjya_zd", "yjya_bh");
        vo.setYjyaBh("EM-PL-"+id);
         mapper.insertYjyaZd(vo);
         YjyaLclogVO lclogVO = new YjyaLclogVO();
         /*同时增加记录*/
         BeanUtils.copyProperties(vo,lclogVO);
         return logservice.insertYjyaLclog(lclogVO);

    }

    @Override
    public int updateYjyaZd(YjyaZdVO vo) {
        boolean zpj=false;
        YjyaZdVO old = mapper.selectOneYjyaByBh(vo.getYjyaBh());
        /*再评价申请时清空再评价审核信息*/
        if(old.getYjyaZpjshr()!=null && old.getYjyaZpjshrq()!=null ){
            zpj=true;
            mapper.ClearShr(old.getYjyaBh());
        }
        BeanUtil.copyProperties(vo, old, true,
                CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        YjyaLclogVO lclogVO = logmapper.selectYalogByBh(vo.getYjyaBh());
        if(zpj)
        {
            old.setYjyaZpjshr(null);
            old.setYjyaZpjyj(null);
            old.setYjyaZpjjg(null);
            old.setYjyaZpjshrq(null);

        }
        if("".equals(old.getYjyaZpjjd())){
            old.setYjyaZpjjd("0");
        }
         mapper.updateYjyaZd(old);

        /*同时修改记录*/
        BeanUtils.copyProperties(old,lclogVO);
//        lclogVO.setYjyaZpjshrq(old.getYjyaZpjsqrq());
        if(zpj){
            lclogVO.setYjyaBakssj(null);
        }
        return  logmapper.updateYalog(lclogVO);
    }

    @Override
    public int updateShYjyaZd(YjyaZdVO vo) {
        YjyaZdVO old = mapper.selectOneYjyaByBh(vo.getYjyaBh());
        YjyaLclogVO lclogVO = new YjyaLclogVO();
        /*更新试用时间*/
        boolean gxsysj=false;
        BeanUtil.copyProperties(vo, old, true,
                CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        if(old.getYjyaZpjjd()!=null){
            if("0".equals(old.getYjyaZpjjd())){
                if("1".equals(old.getYjyaZpjjg())){
                    old.setYjyaZt("1");
                    old.setYjyaNr(old.getYjyaNrdxg());
                    old.setYjyaBbh(old.getYjyaBbhdxg());
                    old.setYjyaZys(Integer.parseInt(old.getYjyaZysdxg()));
                    gxsysj=true;
                }
                old.setYjyaZpjjd("1");
            }
        }


        mapper.updateYjyaZd(old);

        /*同时修改记录*/
        BeanUtils.copyProperties(vo,lclogVO);
        lclogVO.setYjyaSykssj(old.getYjyaShrq());
        if(gxsysj){
            lclogVO.setYjyaSykssj(new Date());
        }
        return  logservice.updateYalog(lclogVO);
    }

    @Override
    public List<YjyaZdVO> selectAllPtYa(String bh, String mc, String ngr, Date qssj, Date jssj) {
        YjyaZdExample example = getSameExample(bh, mc, ngr, qssj, jssj);
        YjyaZdExample.Criteria criteria = example.getOredCriteria().get(0);
        criteria.andYjyaShrIsNull();
        List<YjyaZdVO> list = mapper.selectYjyaZdByExample(example);
        /*普通审核类型设置为0*/
        list.stream().forEach(item->item.setShlx("0"));

        return list;
    }

    @Override
    public List<YjyaZdVO> selectAllZpjYa(String bh, String mc, String ngr, Date qssj, Date jssj) {

        YjyaZdExample example = getSameExample(bh, mc, ngr, qssj, jssj);
        YjyaZdExample.Criteria criteria = example.getOredCriteria().get(0);
        criteria.andYjyaShrIsNotNull().andYjyaZpjshrqIsNull()
                .andYjyaZpjsqrIsNotNull()
                .andYjyaZpjsqrqIsNotNull().andYjyaZpjyyIsNotNull();

        List<YjyaZdVO> list = mapper.selectYjyaZdByExample(example);
        /*再评价审核类型设置为1*/
        list.stream().forEach(item->item.setShlx("1"));
        return list;
    }

    @Override
    public PageInfo<YjyaZdVO> selectAllSh(Integer pageNum, Integer pageSize, String bh, String mc, String ngr, Date qssj, Date jssj) {
        PageHelper.startPage(pageNum,pageSize);
        List<YjyaZdVO> list = selectAllPtYa( bh,  mc, ngr, qssj, jssj);
        list.addAll(selectAllZpjYa(bh, mc,ngr,qssj,jssj));
        return new PageInfo<>(list);
    }

    @Override
    public YjyaZdVO selectOneYjyaByBh(String bh) {
        YjyaZdVO vo = mapper.selectOneYjyaByBh(bh);
        vo.setBmName(tjmapper.selectBmNameByBmid(vo.getYjyaFbbm()));
        return vo;
    }

    private YjyaZdExample getSameExample(String bh, String mc, String ngr, Date qssj, Date jssj){

        bh= DelSpaceUtils.deleteSpace(bh);
        mc= DelSpaceUtils.deleteSpace(mc);
        ngr= DelSpaceUtils.deleteSpace(ngr);
        YjyaZdExample example = new YjyaZdExample();
        YjyaZdExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank
                (bh)){
            criteria.andYjyaBhLike("%"+bh+"%");
        }

        if(StringUtils.isNotBlank(mc)){
            criteria.andYjyaNameLike("%"+mc+"%");
        }

        if(StringUtils.isNotBlank(ngr)){
            criteria.andYjyaNgrLike("%"+ngr+"%");
        }
        if(qssj!=null){
            criteria.andYjyaNgrqGreaterThanOrEqualTo(qssj);
        }

        if(jssj!=null){
            criteria.andYjyaNgrqLessThanOrEqualTo(jssj);
        }
        example.setOrderByClause("yjya_bh");
        return example;
    }


}
