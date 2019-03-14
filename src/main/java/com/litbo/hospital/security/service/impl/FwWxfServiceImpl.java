package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwWxf;
import com.litbo.hospital.security.dao.FwBaoxiuDao;
import com.litbo.hospital.security.dao.FwPjqlDao;
import com.litbo.hospital.security.dao.FwPjqlZjbDao;
import com.litbo.hospital.security.dao.FwWxfDao;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.service.FwWxfService;
import com.litbo.hospital.security.vo.*;
import com.litbo.hospital.supervise.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zjc
 * @create 2018-12-09 9:45
 */
@Service
public class FwWxfServiceImpl implements FwWxfService {

    @Autowired
    private FwWxfDao fwWxfDao;

    @Autowired
    private FwBaoxiuDao fwBaoxiuDao;

    @Autowired
    private FwPjqlDao fwPjqlDao;

    @Autowired
    private FwPjqlZjbDao fwPjqlZjbDao;

    @Autowired
    private EmpDao empDao;

    @Override
    public int updateWxf(Integer id, String wxfSpyj, Date wxfSptime) {
        int i = fwWxfDao.updateWxfById(id, wxfSpyj, wxfSptime);
        return i;
    }

    @Override
    public FwWxfShIndexVo wxfShIndex(Integer id, String userId) {
        FwWxfShIndexVo wxfSh = fwWxfDao.getWxfShById(id);
        String username = empDao.getUserXmById(userId);
        wxfSh.setShrName(username);
        List<PjqlZjbExamineVO> pjList = fwPjqlZjbDao.selectFwPjqlByFwId(wxfSh.getFwId());
        wxfSh.setPjList(pjList);
        return wxfSh;
    }

    @Override
    public PageInfo<WxfListVo> WxfList(String userId,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<WxfListVo> pageInfo = new PageInfo<>(fwWxfDao.WxfList(userId));
        return pageInfo;
    }

    @Override
    public List<FwIdSelectVo> wxfGetEq(String userId) {
        List<FwIdSelectVo> list = fwWxfDao.wxfGetEq(userId);
        return list;
    }

    @Override
    public WxfIndexVo wxfShIndex(Integer id) {
        WxfIndexVo wxfIndexVo = new WxfIndexVo();
        FwWxf wxf = fwWxfDao.findWxf(id);
        wxfIndexVo.setFwWxf(wxf);
        FwNameVo fwNameVO = fwBaoxiuDao.findFwNameVO(wxf.getFwId(), wxf.getUser1Id());
        wxfIndexVo.setFwNameVo(fwNameVO);
        List<PjVo> pjVos = fwPjqlDao.selectPjVo(wxf.getFwId());
        wxfIndexVo.setPjList(pjVos);
        return wxfIndexVo;
    }

    @Override
    public FwWxfIndexVo fwWxfIndex(String fwId, String userId) {
        FwWxfIndexVo fwWxfIndexVo = fwWxfDao.fwWxfIndex(fwId, userId);
        List<PjqlZjbExamineVO> pjList = fwPjqlZjbDao.selectFwPjqlByFwId(fwId);
        fwWxfIndexVo.setPjList(pjList);
        return fwWxfIndexVo;
    }

    @Override
    public WxfIndexVo wxfIndex(String fwId,String userId) {
        WxfIndexVo wxfIndexVo = new WxfIndexVo();

        FwNameVo fwNameVO = fwBaoxiuDao.findFwNameVO(fwId, userId);
        wxfIndexVo.setFwNameVo(fwNameVO);
        List<PjVo> pjVos = fwPjqlDao.selectPjVo(fwId);
        wxfIndexVo.setPjList(pjVos);

        return wxfIndexVo;
    }

    @Override
    public void addFwWxf(FwWxf fwWxf) {
        fwWxf.setWxfStatus(EnumApplyStatus.WAIT_EXAMINE.getCode());
        fwWxfDao.addFwWxf(fwWxf);
    }

    @Override
    public void updateFwWxf(String userId, int status, String spyj, String fwId) {
        fwWxfDao.updateFwWxf(userId,status,spyj,fwId);
    }
}
