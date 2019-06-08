package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.WordToPinYin;
import com.litbo.hospital.security.bean.FwPjzd;
import com.litbo.hospital.security.dao.FwPjzdDao;
import com.litbo.hospital.security.service.FwPjzdService;
import com.litbo.hospital.security.vo.ListFwPjzdVo;
import com.litbo.hospital.security.vo.SelectFwPjzdVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FwPjzdServiceImpl implements FwPjzdService {

    @Autowired
    private FwPjzdDao pjzdDao;
    @Override
    public int insertFwPjzd(FwPjzd pjzd) {
        pjzd.setPjCjTime(new Date());
        pjzd.setPjSzm(WordToPinYin.toPinYin(pjzd.getPjName()));
        return pjzdDao.insertPjzd(pjzd);

    }

    @Override
    public PageInfo listFwPjzd(String pjSzm,int pageNum,int pageSize,String pjfl) {
        PageHelper.startPage(pageNum,pageSize);
        List<ListFwPjzdVo> res = pjzdDao.listFwPjzd(pjSzm.toUpperCase(),pjfl);
        for (ListFwPjzdVo v:res) {//把配件数量设置为默认为1
            v.setPjsgCount(1);
        }
        return new PageInfo(res);


    }

    @Override
    public List<ListFwPjzdVo> listFwPjzdExport(String pjSzm, String pjfl) {
        return pjzdDao.listFwPjzd(pjSzm,pjfl);
    }

    @Override
    public SelectFwPjzdVo selectFwPjzdById(Integer id) {
        SelectFwPjzdVo pjzdVo = new SelectFwPjzdVo();
        FwPjzd pjzd = pjzdDao.selectFwPjzdById(id);
        BeanUtils.copyProperties(pjzd,pjzdVo);
        pjzdVo.setEqId(pjzd.getSbId());
        pjzdVo.setSbcsId(pjzd.getPjScqyId());
        pjzdVo.setSbcsId1(pjzd.getPjGhsId());
        return pjzdVo;
    }

    @Override
    public Integer deleteFwPjzdById(Integer id) {
        return pjzdDao.deleteFwPjzdById(id);
    }
    @Override
    public Integer updateFwPjzd(Integer id){
        return null;
    }
}
