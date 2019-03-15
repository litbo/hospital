package com.litbo.hospital.security.service.impl;

import com.litbo.hospital.security.bean.*;
import com.litbo.hospital.security.dao.*;
import com.litbo.hospital.security.enums.EnumProcess;
import com.litbo.hospital.security.service.FwWeixiuService;
import com.litbo.hospital.security.utils.WxGetNameUtils;
import com.litbo.hospital.security.vo.*;
import com.litbo.hospital.supervise.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author zjc
 * @create 2018-12-06 13:05
 */
@Service
public class FwWeixiuServiceImpl implements FwWeixiuService {

    @Autowired
    private FwWeixiuDao fwWeixiuDao;

    @Autowired
    private FwLcjlDao fwLcjlDao;

    @Autowired
    private FwBaoxiuDao fwBaoxiuDao;

    @Autowired
    private FwShouLiDao fwShouLiDao;

    @Autowired
    private FwWxnrzdDao fwWxnrzdDao;

    @Autowired
    private EmpDao empDao;

    @Autowired
    private FwPjqlDao fwPjqlDao;

    @Autowired
    private FwPjqlZjbDao fwPjqlZjbDao;

    @Override
    public int jumpYwwx(FwYwwx fwYwwx) {
        int i = fwWeixiuDao.addFwYwwx(fwYwwx);
        fwBaoxiuDao.updateBaoxiuStatus(fwYwwx.getFwId(),100);
        FwLcjl fwLcjl = new FwLcjl();
        fwLcjl.setUserId(fwYwwx.getWxrId());
        fwLcjl.setCreatTime(new Date());
        fwLcjl.setBxId(fwYwwx.getFwId());
        fwLcjl.setLc(EnumProcess.FW_GZ_JX.getMessage());
        fwLcjlDao.insertFwLcjl(fwLcjl);
        return i;
    }

    @Override
    public int jumpPj(String userId,String fwId) {
        int i = fwBaoxiuDao.updateBaoxiuStatus(fwId, 5);
        FwLcjl fwLcjl = new FwLcjl();
        fwLcjl.setUserId(userId);
        fwLcjl.setCreatTime(new Date());
        fwLcjl.setBxId(fwId);
        fwLcjl.setLc(EnumProcess.FW_GZ_JX.getMessage());
        fwLcjlDao.insertFwLcjl(fwLcjl);
        return i;
    }

    @Override
    public FwWxqsShIndexVo wxqsShIndexVo(String userId, String fwId) {
        FwWxqsShIndexVo wxqsShIndexVo = fwWeixiuDao.wxqsShIndexVo(fwId);
        String userXm = empDao.getUserXmById(userId);
        wxqsShIndexVo.setShName(userXm);
        wxqsShIndexVo.setQsShr(userId);
        List<PjqlZjbExamineVO> pjqlZjbExamineVOS = fwPjqlZjbDao.selectFwPjqlByFwId(fwId);
        wxqsShIndexVo.setPjList(pjqlZjbExamineVOS);
        return wxqsShIndexVo;
    }

    @Override
    public FwWxqrIndexVo wxqrIndexVo(String userId, String fwId) {
        FwWxqrIndexVo wxqrIndexVo = fwWeixiuDao.wxqrIndexVo(fwId);
        String userXm = empDao.getUserXmById(userId);
        System.out.println(userXm);
        wxqrIndexVo.setQrName(userXm);
        wxqrIndexVo.setQsUser(userId);
        List<PjqlZjbExamineVO> pjqlZjbExamineVOS = fwPjqlZjbDao.selectFwPjqlByFwId(fwId);
        wxqrIndexVo.setPjList(pjqlZjbExamineVOS);
        return wxqrIndexVo;
    }

    @Override
    public String pjqlWxIndex(String userId) {
        return empDao.getUserXmById(userId);
    }

    /**
     * 过时
     * @param fwId
     * @return
     */
    @Override
    public WxqrIndex wxqsIndex(String fwId){
        WxqrIndex wxqrIndex = new WxqrIndex();
        FwInfoVo fwInfo = fwWeixiuDao.findFwInfo(fwId);
        wxqrIndex.setFwInfoVo(fwInfo);
        List<PjVo> pjVos = fwPjqlDao.selectPjVo(fwId);
        wxqrIndex.setPjVoList(pjVos);
        return wxqrIndex;
    }

    /**
     * 过时
     * @param fwId
     * @return
     */
    @Override
    public WeixiuIndexVo weixiuIndex(String fwId) {
        WeixiuIndexVo weixiuIndexVo = new WeixiuIndexVo();
        FwBaoxiu fwBaoxiu = fwBaoxiuDao.findFwBaoxiu(fwId);
        weixiuIndexVo.setFwBaoxiu(fwBaoxiu);

        FwVo fwVo = WxGetNameUtils.getName(fwBaoxiu.getBxrId(), fwBaoxiu.getEqId());
        weixiuIndexVo.setFwVo(fwVo);

        List<FwWxnrzd> fwWxnrzds1 = fwWxnrzdDao.selectFwWxnrzd(0);
        weixiuIndexVo.setWxnrList1(fwWxnrzds1);

        List<FwWxnrzd> fwWxnrzds2 = null;
        if(fwWxnrzds1 != null){
            fwWxnrzds2 = fwWxnrzdDao.selectFwWxnrzd(fwWxnrzds1.get(0).getId());
            weixiuIndexVo.setWxnrList2(fwWxnrzds2);
        }
        weixiuIndexVo.setWxnrList2(fwWxnrzds2);

        List<FwWxnrzd> fwWxnrzds3 = null;
        if(fwWxnrzds2 != null){
            fwWxnrzds3 = fwWxnrzdDao.selectFwWxnrzd(fwWxnrzds2.get(0).getId());
        }
        weixiuIndexVo.setWxnrList3(fwWxnrzds3);

        return weixiuIndexVo;
    }

    @Override
    public FwWeiXiuIndexVo weixiuIndexVo(String fwId,String userId) {
        FwWeiXiuIndexVo fwWeiXiuIndexVo = fwWeixiuDao.weixiuIndexVo(fwId);
        fwWeiXiuIndexVo.setWxrId(userId);
        return fwWeiXiuIndexVo;
    }

    @Override
    @Transactional
    public void addFwWeixiu(FwWeixiu fwWeixiu,String userId) {
        fwWeixiuDao.addFwWeiXiu(fwWeixiu);
        fwBaoxiuDao.updateBaoxiuStatus(fwWeixiu.getFwId(),EnumProcess.FW_WX_QR.getCode());
        FwLcjl fwLcjl = new FwLcjl();
        fwLcjl.setUserId(userId);
        fwLcjl.setCreatTime(new Date());
        fwLcjl.setBxId(fwWeixiu.getFwId());
        fwLcjl.setLc(EnumProcess.FW_GZ_JX.getMessage());
        fwLcjlDao.insertFwLcjl(fwLcjl);
    }



    @Override
    @Transactional
    public void addFwWxqs(FwWxqs fwWxqs,String userId) {
        fwWeixiuDao.addFwWxqr(fwWxqs);
        fwBaoxiuDao.updateBaoxiuStatus(fwWxqs.getFwId(),EnumProcess.FW_WX_SH.getCode());
        FwLcjl fwLcjl = new FwLcjl(userId,new Date(),fwWxqs.getFwId(),EnumProcess.FW_WX_QR.getMessage());
        fwLcjlDao.insertFwLcjl(fwLcjl);
    }

    @Override
    public void updateFwWxqs(String userId,String fwId) {
        fwWeixiuDao.updateFwWxsh(userId,fwId);
        fwBaoxiuDao.updateBaoxiuStatus(fwId,EnumProcess.FW_WX_OVER.getCode());
        FwLcjl fwLcjl = new FwLcjl(userId,new Date(),fwId,EnumProcess.FW_WX_QR.getMessage());
        fwLcjlDao.insertFwLcjl(fwLcjl);
    }


}
