package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.common.utils.poi.ChangeFile;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwFk;
import com.litbo.hospital.security.bean.FwHt;
import com.litbo.hospital.security.dao.FwHtDao;
import com.litbo.hospital.security.service.FwHtService;
import com.litbo.hospital.security.vo.FwHtXqVo;
import com.litbo.hospital.security.vo.HtVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author zjc
 * @create 2018-11-29 19:36
 */
@Service
public class FwHtServiceImpl implements FwHtService {

    @Autowired
    private FwHtDao fwHtDao;

    @Override
    public FwHtXqVo findHtxq(String id) {
        FwHtXqVo fwHtxq = fwHtDao.getFwHtxq(id);
        fwHtxq.setFwFkVo(fwHtDao.findFkList(id));
        return fwHtxq;
    }

    @Override
    public int addFwHt(FwHt fwHt) {
        String path = System.getProperty("user.dir");
        String filePath = path+"/eq/";
        String pjUrl =null;
        java.io.File file = new java.io.File(filePath);
        if(fwHt.getHtFjurl()!=null){
            pjUrl = filePath+ UUID.randomUUID().toString()+fwHt.getHtFjurl().substring(fwHt.getHtFjurl().lastIndexOf("."));
            if(!file.exists()){
                file.mkdirs();
            }
            try {
                ChangeFile.changeFile(fwHt.getHtFjurl(),pjUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ChangeFile.deleteDir(path+"/tmp/");
        String id = IDFormat.getIdByIDAndTime("fw_ht", "id");
        fwHt.setId(id);
        fwHt.setHtStatus(0);
        int i = fwHtDao.addFwHt(fwHt);
        return i;
    }

    @Override
    public int addFwFk(FwFk fwFk) {
        int i = fwHtDao.addFwFk(fwFk);
        int fkCs = fwHtDao.findFkCs(fwFk.getFkHtbh());
        int count = fwHtDao.findFkCountByHtId(fwFk.getFkHtbh());
        if(i>0){
            if(fkCs == count) {
                fwHtDao.updateHtStatus(fwFk.getFkHtbh(), 1);
            }
        }
        return i;
    }

    @Override
    public Result getAllFwHt(Integer pageNum, Integer pageSize, String htName, String sbcsName) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<HtVo> pageInfo = new PageInfo<>(fwHtDao.getAllFwHt(htName,sbcsName));
        return Result.success(pageInfo);
    }

    @Override
    public PageInfo getHtZfList(Integer pageNum, Integer pageSize, String htName, String sbcsName) {
        PageHelper.startPage(pageNum,pageSize);
        List<HtVo> fwHtByStatus = fwHtDao.getFwHtByStatus(0,htName,sbcsName);
        for (HtVo ht : fwHtByStatus) {
            Integer count = fwHtDao.findFkCountByHtId(ht.getId());
            ht.setFkcs(count.toString());
        }
        PageInfo<HtVo> htVoPageInfo = new PageInfo<>(fwHtByStatus);
        return htVoPageInfo;
    }

    @Override
    public HtVo getHtVoById(String id) {
        return fwHtDao.getFwHt(id);
    }
}
