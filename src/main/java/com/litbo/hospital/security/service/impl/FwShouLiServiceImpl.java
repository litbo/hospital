package com.litbo.hospital.security.service.impl;

import com.litbo.hospital.security.bean.FwBaoxiu;
import com.litbo.hospital.security.bean.FwLcjl;
import com.litbo.hospital.security.bean.FwShouli;
import com.litbo.hospital.security.dao.FwBaoxiuDao;
import com.litbo.hospital.security.dao.FwLcjlDao;
import com.litbo.hospital.security.dao.FwShouLiDao;
import com.litbo.hospital.security.enums.EnumProcess;
import com.litbo.hospital.security.service.FwShouLiService;
import com.litbo.hospital.security.utils.WxGetNameUtils;
import com.litbo.hospital.security.vo.FwShouLiIndexVo;
import com.litbo.hospital.security.vo.FwVo;
import com.litbo.hospital.security.vo.ShouliIndexVo;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.dao.BmDao;
import com.litbo.hospital.supervise.dao.EmpDao;
import com.litbo.hospital.user.dao.EqDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author zjc
 * @create 2018-12-06 9:28
 */
@Service
public class FwShouLiServiceImpl implements FwShouLiService {

    @Autowired
    private FwShouLiDao fwShouLiDao;

    @Autowired
    private FwLcjlDao fwLcjlDao;

    @Autowired
    private FwBaoxiuDao fwBaoxiuDao;

    @Autowired
    private EqDao eqDao;

    @Autowired
    private EmpDao empDao;

    @Autowired
    private BmDao bmDao;

    @Override
    public FwShouLiIndexVo shouLiIndexVo(String fwId, String userId) throws Exception{
        int size = fwShouLiDao.getShouliByFwId(fwId);
        if(size > 0){
            throw new RuntimeException("该设备已被维修人员处理");
        }
        FwShouLiIndexVo shouLiIndexVo = fwShouLiDao.shouLiIndexVo(fwId);
        shouLiIndexVo.setSlrId(userId);
        shouLiIndexVo.setSlrName(empDao.getUserXmById(userId));
        return shouLiIndexVo;
    }

    @Override
    public ShouliIndexVo shouliIndex(String fwId,String userId) {
        FwBaoxiu fwBaoxiu = fwBaoxiuDao.findFwBaoxiu(fwId);
        ShouliIndexVo shouliIndexVo = new ShouliIndexVo();
        shouliIndexVo.setFwBaoxiu(fwBaoxiu);

        FwVo fwVo = WxGetNameUtils.getName(fwBaoxiu.getBxrId(), fwBaoxiu.getEqId());
        shouliIndexVo.setFwVo(fwVo);

        FwShouli fwShouli = new FwShouli();
        fwShouli.setSlrId(userId);
        fwShouli.setXyStatus(1);
        fwShouli.setGztjStatus(1);
        shouliIndexVo.setFwShouli(fwShouli);

        SEmp empByUserId = empDao.getEmpByUserId(userId);
        shouliIndexVo.setSlrUserName(empByUserId.getUserXm());
        return shouliIndexVo;
    }

    @Transactional
    @Override
    public void addShouli(FwShouli fwShouli) {
        fwShouLiDao.addShouLi(fwShouli);
        fwBaoxiuDao.updateBaoxiuStatus(fwShouli.getId(),EnumProcess.FW_GZ_JX.getCode());
        FwLcjl fwLcjl = new FwLcjl();
        fwLcjl.setCreatTime(new Date());
        fwLcjl.setBxId(fwShouli.getId());
        fwLcjl.setUserId(fwShouli.getSlrId());
        fwLcjl.setLc(EnumProcess.FW_BX_SL.getMessage());
        fwLcjlDao.insertFwLcjl(fwLcjl);
    }

    @Override
    public List<String> getFWIdBySlrId(String userId) {
        List<String> fwIdList = fwShouLiDao.findFwId(userId);
        return fwIdList;
    }
}
