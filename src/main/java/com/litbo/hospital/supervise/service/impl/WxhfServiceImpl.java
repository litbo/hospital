package com.litbo.hospital.supervise.service.impl;

import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.dao.WxhfDao;
import com.litbo.hospital.supervise.service.BmService;
import com.litbo.hospital.supervise.service.EmpService;
import com.litbo.hospital.supervise.service.WxhfService;
import com.litbo.hospital.supervise.vo.WxhfReadyResouceVO;
import java.util.List;

import com.litbo.hospital.supervise.vo.WxrBmInsertVO;
import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.dao.EqDao;
import com.litbo.hospital.user.service.EqService;
import com.litbo.hospital.user.vo.EqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        List<SBm> wxBms =  bmService.getWxBms();   //维修部门
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
    public void wxrBmXcHf(String[] bms) {
        for (String bmId : bms){
            wxhfDao.wxrBmXcHf(bmId);
        }
    }
}
