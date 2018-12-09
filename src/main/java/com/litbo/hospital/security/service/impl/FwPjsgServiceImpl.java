package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwPjk;
import com.litbo.hospital.security.bean.FwPjqlZjb;
import com.litbo.hospital.security.bean.FwPjsg;
import com.litbo.hospital.security.bean.FwPjsgZjb;
import com.litbo.hospital.security.dao.FwPjkDao;
import com.litbo.hospital.security.dao.FwPjsgDao;
import com.litbo.hospital.security.dao.FwPjsgZjbDao;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.service.FwPjkService;
import com.litbo.hospital.security.service.FwPjsgService;
import com.litbo.hospital.security.vo.InsertFwPjsgVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class FwPjsgServiceImpl implements FwPjsgService {

    @Autowired
    private FwPjsgDao pjsgDao;
    @Autowired
    private FwPjsgZjbDao pjsgZjbDao;
    @Autowired
    private FwPjkDao pjkDao;
    @Override
    @Transactional
    public int insertFwPjsg(InsertFwPjsgVo insertFwPjsgVo) {
        int res = 0;
        FwPjsg pjsg = new FwPjsg();
        pjsg.setPjRkTime(new Date());
        pjsg.setSgStatus(EnumApplyStatus.WAIT_EXAMINE.getCode());
        res = pjsgDao.insertFwPjsg(pjsg);
        List<FwPjsgZjb> fwPjsgZjbs = insertFwPjsgVo.getFwPjsgZjbs();
        for (FwPjsgZjb p:fwPjsgZjbs) {
            p.setPjsgId(pjsg.getId());
        }
        res = pjsgZjbDao.insertFwPjsgZjbList(fwPjsgZjbs);
        return res;
    }

    @Override
    public PageInfo listFwPjsg(FwPjsg pjsg,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(pjsgDao.listFwPjsg(pjsg));
    }

    @Override
    @Transactional
    public int updateFwPjsgStatus(int sgStatus, String currentUserId,int id) {
        if(sgStatus == EnumApplyStatus.APPLY_APPROVAL.getCode()){//申购审核同意，就吧配件入库
            List<FwPjsgZjb> pjsgZjbs = pjsgZjbDao.listFwPjsgZjbByPjsgId(id);
            for (FwPjsgZjb pjsgZjb:pjsgZjbs){
                if(pjkDao.selectFwPjkIsHaveById(pjsgZjb.getPjzdId())!=null){
                    pjkDao.addFwPjkSl(pjsgZjb.getPjzdId(),pjsgZjb.getPjsgCount());
                }else {
                    FwPjk pjk = new FwPjk();
                    pjk.setCreateTime(new Date());
                    pjk.setId(pjsgZjb.getPjzdId());
                    pjk.setPjkSl(pjsgZjb.getPjsgCount());
                    pjkDao.insertFwPjk(pjk);
                }
            }
        }
        return pjsgDao.updateFwPjsgStatus(sgStatus,currentUserId,id);
    }
}
