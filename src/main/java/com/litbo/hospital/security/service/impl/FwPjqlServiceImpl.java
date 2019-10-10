package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.task.bean.Task;
import com.litbo.hospital.common.task.dao.TaskDao;
import com.litbo.hospital.common.task.service.TaskService;
import com.litbo.hospital.security.bean.*;
import com.litbo.hospital.security.dao.*;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.enums.EnumProcess;
import com.litbo.hospital.security.enums.EnumURL;
import com.litbo.hospital.security.service.FwPjqlService;
import com.litbo.hospital.security.vo.ExaminePjqlVO;
import com.litbo.hospital.security.vo.InsertFwPjqlVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private FwPjkDao pjkDao;
    @Autowired
    private FwPjckDao pjckDao;
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private FwPjzdDao pjzdDao;
@Autowired
private FwBaoxiuDao fwBaoxiuDao;
    /***
     *插入配件请领信息
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
        baoxiuDao.updateBaoxiuStatus(pjql.getFwId(),EnumProcess.FW_PJ_QL_SH.getCode());
        //流程表记录
        res = lcjlDao.insertFwLcjl(new FwLcjl(pjql.getQlrId(),new Date(), pjql.getFwId(),EnumProcess.FW_PJ_QL.getMessage()));

        Task task = new Task();
        task.setActionName("配件请领");
        task.setCreatTime(new Date());
        task.setStatus(EnumApplyStatus.WAIT_EXAMINE.getCode().toString());
        task.setUrl(EnumURL.EXAMINE_APPLY.getMessage());
        task.setJsrId(pjql.getQlrId());
        task.setOther(pjql.getId().toString());
        task.setWorkName(insertFwPjqlVo.getSEmp().getBmName() + " " + insertFwPjqlVo.getSEmp().getUserXm() + " " + "配件请领审核");
        List<String> list = fwBaoxiuDao.zlshrList();
        for (String s : list) {
            task.setJsrId(s);
            taskDao.insertTask(task);
        }

        return res;
    }
    @Transactional
    @Override
    public Map<String, Integer> updateFwPjqlSqStatus(Integer status, Integer id, String qrrId, String shyy, Integer taskId) {
        //根据主键查询报修单id
        String fwId = pjqlDao.selectFwIdById(id);
        if(status == EnumApplyStatus.APPLY_APPROVAL.getCode()){//同意
            //检查配件库库存是否足够
            Map<String,Integer> map = new HashMap();
            List<FwPjqlZjb> pjqlZjbs = pjqlZjbDao.listFwPjqlByBjqlId(id);
            Boolean flag = false;
            boolean reduce=true;
            for(FwPjqlZjb pjqlZjb:pjqlZjbs) {
                if (pjqlZjb.getPjsgCount() - pjkDao.selectpjslById(pjqlZjb.getPjzdId()) > 0) {
                    reduce = false;
                }
                if(!reduce) {
                    //如果数量不足，则回滚事务，并返回 审核失败
                    String pjName = pjzdDao.selectFwPjzdName(pjqlZjb.getPjzdId());
                    Integer num = pjkDao.selectpjslById(pjqlZjb.getPjzdId());
                    if (num == null) {
                        num = 0;
                    }
                    int i = pjqlZjb.getPjsgCount() - num;
                    if(i>0){
                        map.put(pjName,i);
                    }

                    flag = true;

                }

            }
            if(reduce){
                for(FwPjqlZjb pjqlZjb:pjqlZjbs) {
                    pjkDao.reduceFwPjkSl(pjqlZjb.getPjzdId(),pjqlZjb.getPjsgCount());
                }
            }
            if(flag){
                return map;
            }
            //库存如果足够，完成出库，并存入出库信息
            FwPjck pjck = new FwPjck();
            pjck.setShyy(shyy);
            pjck.setPjCkTime(new Date());
            pjck.setUserId(qrrId);
            pjck.setQlId(id);


            if(pjckDao.insertFwPjck(pjck)==0){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
            //流程表记录
            lcjlDao.insertFwLcjl(new FwLcjl(qrrId,new Date(),fwId,EnumProcess.FW_PJ_QL_SH_TG.getMessage()));
            //修改报修表状态
            if(baoxiuDao.updateBaoxiuStatus(fwId,EnumProcess.FW_GZ_JX.getCode())==0){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
            //任务列表进行完成
            if(taskDao.updateTaskById(taskId)==0){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }else {
            //流程表记录
            lcjlDao.insertFwLcjl(new FwLcjl(qrrId,new Date(),fwId,EnumProcess.FW_PJ_QL_SH_WTG.getMessage()));
            //修改报修表状态
            baoxiuDao.updateBaoxiuStatus(fwId,EnumProcess.FW_GZ_JX.getCode());
            //任务列表进行完成
            if(taskDao.updateTaskById(taskId)==0){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        pjqlDao.updateFwPjqlSqStatus(status,id,qrrId,new Date());
        return null;
    }
    @Override
    public PageInfo listFwPjqlZjb(int pageNum, int pageSize, String pjRkTimeStart, String pjRkTimeEnd, String pjName) {
        PageHelper.startPage(pageNum,pageSize);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date end = null;
        try {
            if(pjRkTimeStart!=null){
                start = formatter.parse(pjRkTimeStart);
            }
            if(pjRkTimeEnd!=null){
                end = formatter.parse(pjRkTimeEnd);
            }
        }catch(Exception e){
            return null;
        }
        return new PageInfo(pjqlZjbDao.listFwPjqlZjb(start,end,pjName));
    }

    @Override
    public ExaminePjqlVO selectFwPjqlById(Integer id) {
        ExaminePjqlVO vo = pjqlDao.selectFwPjqlById(id);
        vo.setPjqlZjbs(pjqlZjbDao.listFwPjqlZjbExamine(id));
        return vo;
    }
}
