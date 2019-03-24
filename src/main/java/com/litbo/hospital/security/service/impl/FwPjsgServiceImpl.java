package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.task.bean.Task;
import com.litbo.hospital.common.task.dao.TaskDao;
import com.litbo.hospital.security.bean.FwPjk;
import com.litbo.hospital.security.bean.FwPjsg;
import com.litbo.hospital.security.bean.FwPjsgZjb;
import com.litbo.hospital.security.dao.FwPjkDao;
import com.litbo.hospital.security.dao.FwPjsgDao;
import com.litbo.hospital.security.dao.FwPjsgZjbDao;
import com.litbo.hospital.security.enums.EnumApplyStatus;
import com.litbo.hospital.security.enums.EnumURL;
import com.litbo.hospital.security.service.FwPjsgService;
import com.litbo.hospital.security.vo.ExaminePjsgVO;
import com.litbo.hospital.security.vo.InsertFwPjsgVo;
import com.litbo.hospital.security.vo.PjsgZjbExamineVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
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
    @Autowired
    private TaskDao taskDao;
    @Override
    @Transactional
    public int insertFwPjsg(InsertFwPjsgVo insertFwPjsgVo) {
        int res = 0;
        FwPjsg pjsg = insertFwPjsgVo.getFwPjsg();
        pjsg.setSgStatus(EnumApplyStatus.WAIT_EXAMINE.getCode());
        res = pjsgDao.insertFwPjsg(pjsg);
        List<FwPjsgZjb> fwPjsgZjbs = insertFwPjsgVo.getFwPjsgZjbs();
        for (FwPjsgZjb p:fwPjsgZjbs) {
            p.setPjsgId(pjsg.getId());
        }
        res = pjsgZjbDao.insertFwPjsgZjbList(fwPjsgZjbs);
        //添加审核数据到task表
        Task task = new Task();
        task.setCreatTime(new Date());
        task.setWorkName("配件申购审核");
        task.setStatus(EnumApplyStatus.WAIT_EXAMINE.getCode().toString());
        task.setUrl(EnumURL.EXAMINE_PURCHASE.getMessage());
        task.setActionName("配件申购");
        task.setOther(pjsg.getId().toString());
        task.setJsrId(pjsg.getUserId2());
        taskDao.insertTask(task);
        return res;
    }

    @Override
    public PageInfo listFwPjsg(FwPjsg pjsg,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(pjsgDao.listFwPjsg(pjsg));
    }

    @Override
    @Transactional
    public int updateFwPjsgStatus(Integer sgStatus, String currentUserId,Integer id,Integer taskId) {
        if(sgStatus == EnumApplyStatus.APPLY_APPROVAL.getCode()){//申购审核同意，就吧配件入库
            List<FwPjsgZjb> pjsgZjbs = pjsgZjbDao.listFwPjsgZjbByPjsgId(id);
            for (FwPjsgZjb pjsgZjb:pjsgZjbs){
                if(pjkDao.selectFwPjkIsHaveById(pjsgZjb.getPjzdId())!=null){
                    //判断配件库是否有该配件
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
        taskDao.updateTaskById(taskId);
        return pjsgDao.updateFwPjsgStatus(new Date(),sgStatus,currentUserId,id,0);
    }

    @Override
    public PageInfo listFwPjsgZjb(int pageNum, int pageSize, String pjRkTimeStart, String pjRkTimeEnd, String pjName) {
        PageHelper.startPage(pageNum,pageSize);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date end = null;
        try {
            if(pjRkTimeStart!=null)
             start = formatter.parse(pjRkTimeStart);
            if(pjRkTimeEnd!=null)
             end = formatter.parse(pjRkTimeEnd);
        }catch (Exception e){
            return null;
        }
        return new PageInfo(pjsgZjbDao.listFwPjsgZjb(start,end,pjName));
    }

    @Override
    public ExaminePjsgVO selectFwPjsgById(Integer id, Integer taskId) {
        ExaminePjsgVO vo = pjsgDao.selectFwPjsgById(id);
        List<PjsgZjbExamineVO> pjsgZjbExamineVOS =  pjsgZjbDao.listFwPjsgZjbExamine(id);
        vo.setPjsgZjbs(pjsgZjbExamineVOS);
        return vo;
    }
}
