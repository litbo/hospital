package com.litbo.hospital.security.service.impl;

import com.litbo.hospital.common.task.bean.Task;
import com.litbo.hospital.common.task.dao.TaskDao;
import com.litbo.hospital.security.bean.*;
import com.litbo.hospital.security.dao.*;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.enums.EnumProcess;
import com.litbo.hospital.security.enums.EnumURL;
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

    @Autowired
    private TaskDao taskDao;

    @Override
    public int jumpYwwx(FwYwwx fwYwwx) {
        if(fwBaoxiuDao.findFwBaoxiu(fwYwwx.getFwId()).getBxStatus()==4){
            int i = fwWeixiuDao.addFwYwwx(fwYwwx);
            fwBaoxiuDao.updateBaoxiuStatus(fwYwwx.getFwId(),14);
            FwLcjl fwLcjl = new FwLcjl();
            fwLcjl.setUserId(fwYwwx.getWxrId());
            fwLcjl.setCreatTime(new Date());
            fwLcjl.setBxId(fwYwwx.getFwId());
            fwLcjl.setLc(EnumProcess.FW_GZ_JX.getMessage());
            fwLcjlDao.insertFwLcjl(fwLcjl);
            return i;
        }
        return 0;
    }

    @Override
    public int jumpPj(String userId,String fwId) {
        if(fwBaoxiuDao.findFwBaoxiu(fwId).getBxStatus()==4){
            int i = fwBaoxiuDao.updateBaoxiuStatus(fwId, 5);
            FwLcjl fwLcjl = new FwLcjl();
            fwLcjl.setUserId(userId);
            fwLcjl.setCreatTime(new Date());
            fwLcjl.setBxId(fwId);
            fwLcjl.setLc(EnumProcess.FW_GZ_JX.getMessage());
            fwLcjlDao.insertFwLcjl(fwLcjl);
            return i;
        }
        return 0;
    }

    @Override
    public FwWxqsShIndexVo wxqsShIndexVo(String userId, String fwId) {
        FwWxqsShIndexVo wxqsShIndexVo = fwWeixiuDao.wxqsShIndexVo(fwId);
        System.out.println(wxqsShIndexVo);
        String userXm = empDao.getUserXmById(userId);
        System.out.println(userXm);
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
        //System.out.println(userXm);
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
    public int addFwWeixiu(FwWeixiu fwWeixiu,String userId) {
        if(fwBaoxiuDao.findFwBaoxiu(fwWeixiu.getFwId()).getBxStatus() == 4){
            int i = fwWeixiuDao.addFwWeiXiu(fwWeixiu);
            fwBaoxiuDao.updateBaoxiuStatus(fwWeixiu.getFwId(),EnumProcess.FW_WX_QR.getCode());
            FwLcjl fwLcjl = new FwLcjl();
            fwLcjl.setUserId(userId);
            fwLcjl.setCreatTime(new Date());
            fwLcjl.setBxId(fwWeixiu.getFwId());
            fwLcjl.setLc(EnumProcess.FW_GZ_JX.getMessage());
            fwLcjlDao.insertFwLcjl(fwLcjl);

            Task task = new Task();
            String eqName = fwBaoxiuDao.findEqNameByFwId(fwWeixiu.getFwId());

            task.setWorkName(eqName+" "+ "维修完成确认");
            task.setStatus(EnumApplyStatus.WAIT_EXAMINE.getCode().toString());
            task.setUrl(EnumURL.REPAIR_CONFIRM.getMessage());
            task.setActionName("维修确认");
            task.setCreatTime(new Date());
            task.setOther(fwWeixiu.getFwId());
            task.setJsrId(fwBaoxiuDao.findBxrIdByFwId(fwWeixiu.getFwId()));
            taskDao.insertTask(task);
            return i;
        }
        return 0;
    }



    @Override
    @Transactional
    public void addFwWxqs(FwWxqsVo fwWxqsVo,String userId) {
        FwWxqs fwWxqs = fwWxqsVo.getFwWxqs();
        fwWeixiuDao.addFwWxqr(fwWxqs);
        fwBaoxiuDao.updateBaoxiuStatus(fwWxqs.getFwId(),EnumProcess.FW_WX_SH.getCode());
        FwLcjl fwLcjl = new FwLcjl(userId,new Date(),fwWxqs.getFwId(),EnumProcess.FW_WX_QR.getMessage());
        fwLcjlDao.insertFwLcjl(fwLcjl);
        Task task = new Task();
        String eqName = fwBaoxiuDao.findEqNameByFwId(fwWxqs.getFwId());

        taskDao.updateTaskById(fwWxqsVo.getTaskId());

        task.setWorkName(eqName+" "+ "维修确认审核");
        task.setStatus(EnumApplyStatus.WAIT_EXAMINE.getCode().toString());
        task.setUrl(EnumURL.REPAIR_EXAMINE.getMessage());
        task.setCreatTime(new Date());
        task.setActionName("维修确认审核");
        task.setOther(fwWxqs.getFwId());
        List<String> shrList = fwBaoxiuDao.shrList();
        for (String shr : shrList) {
            task.setJsrId(shr);
            taskDao.insertTask(task);
        }

    }

    @Override
    public void updateFwWxqs(String userId,String fwId,Integer taskId) {
        fwWeixiuDao.updateFwWxsh(userId,fwId);
        FwBaoxiu fwBaoxiu = fwBaoxiuDao.findFwBaoxiu(fwId);
        fwBaoxiuDao.updateBaoxiuStatus(fwId,EnumProcess.FW_WX_OVER.getCode());
        FwLcjl fwLcjl = new FwLcjl(userId,new Date(),fwId,EnumProcess.FW_WX_SH.getMessage());
        fwLcjlDao.insertFwLcjl(fwLcjl);
        fwBaoxiuDao.updateEqStatussy(fwBaoxiu.getEqId());
        //taskDao.updateTaskById(taskId);
        Task task = taskDao.getTaskById(taskId);
        //System.out.println(task);
        Date date = taskDao.selectCreateTimeByTaskId(taskId);
        //System.out.println(date);
        List<Task> tasks = taskDao.selectTaskListByCreatTime(date);
        //System.out.println(tasks);
        for (Task t : tasks) {
            if(t.equals(task)){
                taskDao.updateTaskById(t.getTaskId());
            }
        }
        /*List<String> shrList = fwBaoxiuDao.shrList();
        for (String shr : shrList) {
            task.setJsrId(shr);
            taskDao.insertTask(task);
        }*/
    }


}
