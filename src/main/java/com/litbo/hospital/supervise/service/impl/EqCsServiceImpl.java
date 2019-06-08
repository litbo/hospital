package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.UploadFile;
import com.litbo.hospital.security.bean.Cszj;
import com.litbo.hospital.supervise.bean.CsZjDeleteVO;
import com.litbo.hospital.supervise.bean.EqCszjVO;
import com.litbo.hospital.supervise.dao.EqCsDao;
import com.litbo.hospital.supervise.service.EqCsService;
import com.litbo.hospital.supervise.vo.*;
import com.litbo.hospital.user.bean.EqCs;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EqCsServiceImpl implements EqCsService {
    @Autowired
    private EqCsDao eqCsDao;

    @Override
    public List<EqCs> listEqCs(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<EqCs> eqcss = eqCsDao.listEqCs();
        return eqcss;
    }

    @Override
    public List<EqCsVO> listEqCsVO(EqCsSelectVO selectVo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<EqCsVO> eqCsVOS = eqCsDao.listEqCsVO(selectVo);
        return eqCsVOS;
    }

    @Override
    public List<EqCszjVO> listEqCszjVOByX(EqCsSelectVO selectVo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<EqCszjVO> cszjVOS = eqCsDao.listEqCszjVOByX(selectVo);
        return cszjVOS;
    }

    @Override
    public EqCsInsertReadyVO readyResource() {
        EqCsInsertReadyVO readyVO = new EqCsInsertReadyVO();
//        List<Eqcs> = eqCsDao.listEqCslb();
        return null;

    }

    @Override
    public void insertEqCs(EqCs eqCs) {

        eqCs.setSbcsId(UUID.randomUUID().toString());
        eqCsDao.insertEqCs(eqCs);
    }

    @Override
    public PageInfo listEqcsByX(int pageNum, int pageSize, EqCsSelectVO selectVo) {
        PageHelper.startPage(pageNum,pageSize);
        List<EqCs> date = eqCsDao.listEqcsByX(selectVo);
        return new PageInfo(date);
    }

    @Override
    public PageInfo listEqcsByX1(int pageNum, int pageSize, EqCsSelectVO selectVo) {
        PageHelper.startPage(pageNum,pageSize);
        selectVo.setEqCslb("3");
        List<EqCsVO> date = eqCsDao.listEqcsByX1(selectVo);
        List res = new ArrayList();
        for(EqCsVO eq:date){
            EqCsVO1 s = new EqCsVO1();
            BeanUtils.copyProperties(eq,s);
            s.setSbcsId1(eq.getSbcsId());
            res.add(s);
        }
        return new PageInfo(res);
    }
    @Override
    public PageInfo listEqcsByX2(int pageNum, int pageSize, EqCsSelectVO selectVo) {
        PageHelper.startPage(pageNum,pageSize);
        selectVo.setEqCslb("1");
        List<EqCs> date = eqCsDao.listEqcsByX(selectVo);
        return new PageInfo(date);
    }

    @Override
    public PageInfo listEqcsByX3(int pageNum, int pageSize, EqCsSelectVO selectVo) {
        PageHelper.startPage(pageNum,pageSize);
        selectVo.setEqCslb("2");
        List<EqCs> date = eqCsDao.listEqcsByX(selectVo);
        return new PageInfo(date);
    }

    @Override
    public void deleteEqCs(CsDeleteVO deleteVO) {
        String[] sbcsIds = deleteVO.getSbcsIds();
        for(String sbcsId:sbcsIds){
            eqCsDao.deleteEqCs(sbcsId);
        }

    }

    @Override
    public EqCs getEqCsById(String sbcsId) {
        if (sbcsId==null||sbcsId.equals("")) return null;
        return eqCsDao.getEqCsById(sbcsId);
    }

    @Override
    public EqCszjVO getCszjByCszjId(String cszjId) {
        if (cszjId==null||cszjId.equals("")) return null;
        return eqCsDao.getCszjByCszjId(cszjId);
    }

    @Override
    public void updateEqCs(EqCs eqCs) {
        eqCsDao.updateEqCs(eqCs);
    }

    @Override
    public void insertCszj(Cszj cszj) {
        eqCsDao.insertCszj(cszj);
    }

    @Override
    public void deleteEqCsZj(CsZjDeleteVO deleteVO) {
        for(String cszjID:deleteVO.getCszjIds())
            eqCsDao.deleteEqCsZj(cszjID);
    }

    @Override
    public void upDateCszj(Cszj cszj) {
        eqCsDao.upDateCszj(cszj);
    }

    @Override
    public String batchImportCszjs(MultipartFile[] files) {
        String path = System.getProperty("user.dir");
        String filePath =path+"/cs/cszj/";
        StringBuffer imgurls=new StringBuffer();
        for(MultipartFile file:files){
            String url = UploadFile.upload(filePath,file);
            url = url.replaceAll("/","\\\\");
            url=url.replace(path+"\\cs","");
            imgurls.append(url+",");
        }
        return imgurls.toString();
    }
}
