package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.dao.WxhfDao;
import com.litbo.hospital.supervise.service.BmService;
import com.litbo.hospital.supervise.service.EmpService;
import com.litbo.hospital.supervise.service.WxhfService;
import com.litbo.hospital.supervise.vo.*;
import com.litbo.hospital.user.dao.EqDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxhfServiceImpl implements WxhfService {
    @Autowired
    private WxhfDao wxhfDao;
    @Autowired
    private BmService bmService;
    @Autowired
    private EmpService empService;
    @Autowired
    private EqDao eqDao;

    @Override
    public WxhfReadyResouceVO getWxhfReadyResouceVO() {
        WxhfReadyResouceVO wxhfReadyResouceVO = new WxhfReadyResouceVO();

        List<SBm> wxBms =  bmService.getWxBms();   //维修科室
        List<SEmp> wxEmps = empService.getWxEmps();//维修人员
        List<SBm> fwxBms = bmService.getFwxBms();//科室
//        List<EqInfo> allEq = eqDao.;//科室设备

        wxhfReadyResouceVO.setWxbms(wxBms);
        wxhfReadyResouceVO.setWxemps(wxEmps);
        wxhfReadyResouceVO.setKes(fwxBms);
//        wxhfReadyResouceVO.setEqInfos(allEq);
        return wxhfReadyResouceVO;
    }

    @Override
    public void wxrBmHf(WxrBmInsertVO wxrBmInsertVO) {
        String wxrId = wxrBmInsertVO.getUserId();
        String[] bmIds = wxrBmInsertVO.getBmIds();
        for (String bmId : bmIds){
            wxhfDao.saveWxrBm(wxrId,bmId);
        }
    }

    @Override
    public void wxrBmXcHf(String[] gbids) {
        for (String gbid : gbids){
            wxhfDao.wxrBmXcHf(gbid);
        }
    }

    @Override
    public PageInfo getWxbmGcsEqMSG() {

        return new PageInfo(wxhfDao.getWxbmGcsEqMSG());
    }

    @Override
    public PageInfo getGcsBmMSG(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(wxhfDao.getGcsBmMSG());
    }

    @Override
    public PageInfo getGcsBmMSGByGcsNameAndBmName(int pageNum, int pageSize, String userXm, String bmName) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(wxhfDao.getGcsBmMSGByGcsNameAndBmName(userXm,bmName));
    }

    @Override
    public void wxBmGcsEqHf(WxBmGcsEqInsertVO wxBmGcsEqInsertVO) {
        String bmId = wxBmGcsEqInsertVO.getBmId();
        String gcsId = wxBmGcsEqInsertVO.getUserId();
        String[] eqIds = wxBmGcsEqInsertVO.getEqIds();
        for (String eqId : eqIds){
            wxhfDao.wxBmGcsEqHf(bmId,gcsId,eqId);
        }
    }

    @Override
    public void wxBmGcsEqXcHf(String[] bgids) {
        for (String bgId : bgids){
            wxhfDao.wxBmGcsEqXcHf(bgId);
        }
    }

    @Override
    public PageInfo getBmGcsEqByX(int pageNum, int pageSize, BmGcsEqSelectXVO xvo) {
        PageHelper.startPage(pageNum,pageSize);
        List<SWxbmGcsEqSelect> data = wxhfDao.getBmGcsEqByX(xvo);
        return new PageInfo(data);
    }

    @Override
    public Boolean isxzd(String userId, String bmId) {
        int ct= wxhfDao.isxzd(userId,bmId);
        if (ct>0) return true;
        return false;
    }
}
