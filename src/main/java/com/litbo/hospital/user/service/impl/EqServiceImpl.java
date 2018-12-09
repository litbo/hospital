package com.litbo.hospital.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.UploadFile;
import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.bean.EqPm;
import com.litbo.hospital.user.dao.EqDao;
import com.litbo.hospital.user.dao.PmDao;
import com.litbo.hospital.user.service.EqService;
import com.litbo.hospital.user.vo.EqShowVo;
import com.litbo.hospital.user.vo.EqVo;
import com.litbo.hospital.user.vo.SelectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class EqServiceImpl implements EqService {

    @Autowired
    EqDao eqDao;
    @Autowired
    PmDao pmDao;
    @Override
    public List<EqVo> getAllEq() {
        return eqDao.getAllEq();
    }

    @Override
    public PageInfo listShowEqs(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqDao.listShowEqs());
    }

    @Override
    public int addEq(EqInfo eqInfo, MultipartFile sbzp, MultipartFile mpzp) {
        //文件上传
        String path = "F:\\img";
        String eqSbzp =  UploadFile.upload(path,sbzp);
        String eqMpzp =  UploadFile.upload(path,mpzp);
        eqInfo.setEqSbzp(eqSbzp);
        eqInfo.setEqMpzp(eqMpzp);
        //初始化设备流水号
        if(eqDao.countEq()==0){
           String eqId ="10000";
           eqInfo.setEqId(eqId);
        }else{
            Integer eqId1 = Integer.parseInt(eqDao.getLastId())+1;
            String  eqId = eqId1.toString();
            eqInfo.setEqId(eqId);
        }

        //初始化设备编号
        //年月1812 + pm编号68031409 + 级别 1 + 流水号eqId
        //获取当前时间
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
        String time1 = sf.format(new Date());
        String time = time1.substring(2,4)+time1.substring(5,time1.length());
        EqPm pm = pmDao.getPmById(eqInfo.getEqPmId());
        String sbbh =time+pm.getPid()+pm.getGlh()+eqInfo.getEqId();
        eqInfo.setEqSbbh(sbbh);
        //存
        return eqDao.addEq(eqInfo);
    }


    @Override
    public PageInfo listEqByX(int pageNum, int pageSize, SelectVo selectVo) {
        PageHelper.startPage(pageNum,pageSize);

        return new PageInfo(eqDao.listEqByX(selectVo));
    }


}
