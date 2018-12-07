package com.litbo.hospital.security.service.impl;

import com.litbo.hospital.security.bean.FwLcjl;
import com.litbo.hospital.security.bean.FwPjql;
import com.litbo.hospital.security.bean.FwPjqlZjb;
import com.litbo.hospital.security.dao.FwBaoxiuDao;
import com.litbo.hospital.security.dao.FwLcjlDao;
import com.litbo.hospital.security.dao.FwPjqlDao;
import com.litbo.hospital.security.dao.FwPjqlZjbDao;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.enums.EnumProcess;
import com.litbo.hospital.security.service.FwBaoxiuService;
import com.litbo.hospital.security.service.FwPjqlService;
import com.litbo.hospital.security.vo.InsertFwPjqlVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class FwPjqlServiceImpl implements FwPjqlService {
    @Autowired
    private FwPjqlDao pjqlDao;
    @Autowired
    private FwPjqlZjbDao pjqlZjbDao;
    @Autowired
    private FwBaoxiuDao baoxiuDao;
    @Autowired
    private FwLcjlDao lcjlDao;
    /***
     *
     * @param insertFwPjqlVo
     * @return
     */
    @Override
    @Transactional
    public int insertFwPjql(InsertFwPjqlVo insertFwPjqlVo) {
        int res = 0;
        //配件请领表插入数据
        FwPjql pjql = insertFwPjqlVo.getFwPjql();
        pjql.setQlTime(new Date());
        pjql.setSqStatus(EnumApplyStatus.WAIT_EXAMINE.getCode());
        res = pjqlDao.insertFwPjql(pjql);
        //配件请领中间表插入数据
        List<FwPjqlZjb> fwPjqlZjbs = insertFwPjqlVo.getFwPjqlZjbs();
        if(null != fwPjqlZjbs && fwPjqlZjbs.size() !=0 && res>0){
            for (FwPjqlZjb pjqlZjb:fwPjqlZjbs){
                pjqlZjb.setPjqlId(pjql.getId());//把配件请领表的主键存入中间表 当作外键
            }
            res = pjqlZjbDao.insertFwPjqlZjbList(fwPjqlZjbs);
        }
        //修改报修表状态
        baoxiuDao.updateBaoxiuStatus(pjql.getFwId(),EnumProcess.FW_PJ_QL.getCode());
        //流程表记录
        lcjlDao.insertFwLcjl(new FwLcjl(pjql.getQlrId(),new Date(), pjql.getFwId(),EnumProcess.FW_PJ_QL.getMessage()));
        return res;
    }
}
