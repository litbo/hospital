package com.litbo.hospital.security.service.impl;

import com.litbo.hospital.security.bean.FwWxf;
import com.litbo.hospital.security.dao.FwBaoxiuDao;
import com.litbo.hospital.security.dao.FwPjqlDao;
import com.litbo.hospital.security.dao.FwWxfDao;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.service.FwWxfService;
import com.litbo.hospital.security.vo.FwNameVo;
import com.litbo.hospital.security.vo.PjVo;
import com.litbo.hospital.security.vo.WxfIndexVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
