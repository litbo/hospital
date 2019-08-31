package com.litbo.hospital.lifemanage.service.impl.MyServiceImpl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgYs;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SgHzYsVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SgJsYsVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SgLcYsVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SgSwYsVO;
import com.litbo.hospital.lifemanage.bean.vo.SgYsListVO;
import com.litbo.hospital.lifemanage.dao.MyMapper.SgYsMapper2;
import com.litbo.hospital.lifemanage.service.MyService.SgYsService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
public class SqYsService2impl implements SgYsService2 {
    @Autowired
    private SgYsMapper2 sgYsMapper2;


    @Override
    public PageInfo<SgYsListVO> sgWaitSwYsList(Integer pageNum, Integer pageSize, String ksid, String htid) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(sgYsMapper2.sgWaitSwYsList(ksid, htid));
    }

    @Override
    public int insertSw(SgSwYsVO sw) {
        sw.setYsId(UUID.randomUUID().toString());
        int i = sgYsMapper2.insertSw(sw);
        return i;
    }

    @Override
    public PageInfo<SgYsListVO> sgWaitJsYsList(Integer pageNum, Integer pageSize, String ksid, String htid) {
        PageHelper.startPage(pageNum,pageSize);
        List<SgYsListVO> vos = sgYsMapper2.sgWaitJsYsList(ksid, htid);
        return new PageInfo<>(vos);
    }

    @Override
    public int insertJs(SgJsYsVO js) {
        return sgYsMapper2.insertJs(js);
    }

    @Override
    public PageInfo<SgYsListVO> sgWaitLcYsList(Integer pageNum, Integer pageSize, String ksid, String htid) {
        PageHelper.startPage(pageNum,pageSize);
        List<SgYsListVO> vos = sgYsMapper2.sgWaitLcYsList(ksid, htid);
        for (int i = 0; i < vos.size(); i++) {
            SgYsListVO vo = vos.get(i);
            String id = vo.getYsId();
            SgYs ys = sgYsMapper2.selectByPrimaryKey(id);
            Date date = ys.getYsYsrq();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, 1);
            if (new Date().getTime() < cal.getTime().getTime()) {
                vos.remove(i);
            }
        }
        return new PageInfo<>(vos);
    }

    @Override
    public int insertLc(SgLcYsVO lc) {
        return sgYsMapper2.insertLc(lc);
    }

    @Override
    public PageInfo<SgYsListVO> sgWaitHzYsList(Integer pageNum, Integer pageSize, String ksid, String htid) {
        PageHelper.startPage(pageNum,pageSize);
        List<SgYsListVO> vos = sgYsMapper2.sgWaitHzYsList(ksid, htid);
        return new PageInfo<>(vos);
    }

    @Override
    public int insertHz(SgHzYsVO hz) {
        return sgYsMapper2.insertHz(hz);
    }

    @Override
    public PageInfo sgBenBmSwYsList(Integer pageNum, Integer pageSize,
                                    String ksid, String htid, String xnsb) {
        PageHelper.startPage(pageNum, pageSize);
        List<SgYsListVO> vos = sgYsMapper2.sgBenBmSwYsList(ksid, htid, xnsb);
        return new PageInfo(vos);
    }

    @Override
    public PageInfo sgBenBmJsYsList(Integer pageNum, Integer pageSize, String ksid, String htid, String xnsb) {
        PageHelper.startPage(pageNum, pageSize);

        List<SgYsListVO> vos = sgYsMapper2.sgBenBmJsYsList(ksid, htid, xnsb);
        return new PageInfo(vos);
    }

    @Override
    public PageInfo sgBenBmLcYsList(Integer pageNum, Integer pageSize, String ksid, String htid, String xnsb) {
        PageHelper.startPage(pageNum, pageSize);
        List<SgYsListVO> vos = sgYsMapper2.sgBenBmLcYsList(ksid, htid, xnsb);
        return new PageInfo(vos);
    }

    @Override
    public PageInfo sgBenBmHzYsList(Integer pageNum, Integer pageSize, String ksid, String htid, String xnsb) {
        PageHelper.startPage(pageNum,pageSize);
        List<SgYsListVO> vos = sgYsMapper2.sgBenBmHzYsList(ksid, htid, xnsb);
        return new PageInfo(vos);
    }

    @Override
    public PageInfo selectAllYsJl(Integer pageNum, Integer pageSize, String htid, String bmid) {
        PageHelper.startPage(pageNum,pageSize);
        List<SgYsListVO> vos = sgYsMapper2.selectAllYsJl(htid, bmid);
        return new PageInfo(vos);
    }

    @Override
    public List<Map<String, String>> selectAllBmIdAndName() {
        return sgYsMapper2.selectAllBmIdAndName();
    }
    @Override
    public SgYs slectOneYsJl(String ysid) {

        SgYs ys = sgYsMapper2.selectByPrimaryKey(ysid);
        return ys;
    }


}
