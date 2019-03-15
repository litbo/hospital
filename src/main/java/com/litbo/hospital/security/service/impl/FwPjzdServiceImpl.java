package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.WordToPinYin;
import com.litbo.hospital.security.bean.FwPjzd;
import com.litbo.hospital.security.dao.FwPjzdDao;
import com.litbo.hospital.security.service.FwPjzdService;
import com.litbo.hospital.security.vo.ListFwPjzdVo;
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
        for (ListFwPjzdVo v:res) {
            v.setPjsgCount(1);
        }
        return new PageInfo(res);


    }

    @Override
    public List<ListFwPjzdVo> listFwPjzdExport(String pjSzm, String pjfl) {
        return pjzdDao.listFwPjzd(pjSzm,pjfl);
    }
}
