package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.task.bean.Task;
import com.litbo.hospital.common.task.dao.TaskDao;
import com.litbo.hospital.security.bean.FwBlsj;
import com.litbo.hospital.security.bean.FwLcjl;
import com.litbo.hospital.security.dao.FwBaoxiuDao;
import com.litbo.hospital.security.dao.FwBlsjDao;
import com.litbo.hospital.security.dao.FwLcjlDao;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.enums.EnumBlsj;
import com.litbo.hospital.security.enums.EnumProcess;
import com.litbo.hospital.security.enums.EnumURL;
import com.litbo.hospital.security.service.FwBlsjService;
import com.litbo.hospital.user.vo.LiveEmpVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class FwBlsjServiceImpl implements FwBlsjService {
    @Autowired
    private FwBlsjDao blsjDao;
    @Autowired
    private FwLcjlDao lcjlDao;
    @Autowired
    private FwBaoxiuDao baoxiuDao;
    @Autowired
    private TaskDao taskDao;
    @Override
    @Transactional
    public int insertFwBlsj(FwBlsj blsj, LiveEmpVo sEmp) {
        blsj.setCjrq(new Date());
        blsj.setBgrq(new Date());
        blsj.setStatus(EnumApplyStatus.WAIT_EXAMINE.getCode());
        blsj.setBgrId(sEmp.getUserId());
        blsj.setLb(EnumBlsj.FW_BLSJ_SB.getCode());
        if(StringUtils.isNotBlank(blsj.getFwId())){//如果保修单号不为空，存入流程
            FwLcjl lcjl = new FwLcjl();
            lcjl.setCreatTime(new Date());
            lcjl.setLc(EnumProcess.FW_BLSJ.getMessage());
            lcjl.setBxId(blsj.getFwId());
            lcjl.setUserId(blsj.getBgrId());
            lcjlDao.insertFwLcjl(lcjl);
//            baoxiuDao.updateBaoxiuStatus(blsj.getFdId(),EnumProcess.FW_BLSJ.getCode());//报修单状态更改
        }
        int res = blsjDao.insertFwBlsj(blsj);
        //存入任务表进行审核
        Task task = new Task();
        task.setCreatTime(new Date());
        task.setWorkName(sEmp.getBmName()+" "+sEmp.getUserXm()+" "+"不良事件审核");
        task.setStatus(EnumApplyStatus.WAIT_EXAMINE.getCode().toString());
        task.setUrl(EnumURL.EXAMINE_SUSPICIOUS.getMessage());
        task.setActionName("不良事件");
        task.setOther(blsj.getId().toString());
        task.setJsrId(blsj.getShr());
        taskDao.insertTask(task);
        return res;
    }

    @Override
    public PageInfo listFwBlsj(int pageNum, int pageSize, String cpmc, String bgrXm) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(blsjDao.listFwBlsj( EnumApplyStatus.APPLY_APPROVAL.getCode(),EnumBlsj.FW_BLSJ_SB.getCode(),cpmc, bgrXm));
    }

    @Override
    public PageInfo listFwBlsjWaitExamine(int pageNum, int pageSize, String cpmc, String bgrXm) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(blsjDao.listFwBlsj( EnumApplyStatus.WAIT_EXAMINE.getCode(), EnumBlsj.FW_BLSJ_SB.getCode(), cpmc, bgrXm));
    }

    @Override
    public FwBlsj selectFwBlsjById(Integer id) {
        return blsjDao.selectFwBlsjById(id);
    }

    @Override
    @Transactional
    public int updateFwBlsjStatus(Integer status, Integer id, Integer taskId) {
        taskDao.updateTaskById(taskId);
        return blsjDao.updateFwBlsjStatus(status,id);

    }
}
