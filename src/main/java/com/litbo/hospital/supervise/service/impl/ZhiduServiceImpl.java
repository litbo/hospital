package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SZhidu;
import com.litbo.hospital.supervise.bean.SZhiduzhizeZt;
import com.litbo.hospital.supervise.dao.ZhiduDao;
import com.litbo.hospital.supervise.enums.ShProcessConstants;
import com.litbo.hospital.supervise.enums.ZdCzztEnumProcess;
import com.litbo.hospital.supervise.enums.ZdShZtEnumProcess;
import com.litbo.hospital.supervise.enums.ZdztEnumProcess;
import com.litbo.hospital.supervise.service.ZhiduService;
import com.litbo.hospital.supervise.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;



@Service
public class ZhiduServiceImpl implements ZhiduService {
    @Autowired
    private ZhiduDao zhiduDao;
    @Override
    public PageInfo getZds(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SZhidu> date =  zhiduDao.getZds();
        return new PageInfo(date);
    }

    @Override
    public void saveZd(SZhidu zd) {
        zhiduDao.saveZd(zd);
    }

    @Override
    public void deteleZd(int zd_id) {
        zhiduDao.deteleZd(zd_id);
    }


    @Override
    public void updateZd(SZhidu zd) {
        zhiduDao.updateZd(zd);
    }


    



    private void insertZdZt(Integer zdId,String shrId,Boolean isTg){
        // 准备 制度id  审核人id  制度操作名称 制度操作状态

        SZhiduzhizeZt ztc = new SZhiduzhizeZt();
        //设置制度ID
        ztc.setZdId(zdId);
        //设置审核人
        if(shrId!=null) ztc.setUserId(shrId);

        //获得审核名字
        String dclCzztName = getDclCzztName(zdId);
        String dqCzztName = ShProcessConstants.autoGetProcessName(dclCzztName,isTg);

        //设置审核状态名字
        ztc.setZtCzname(ShProcessConstants.SH_PROCESS.get(ShProcessConstants.PROCESS_CODE));
        //设置状态为待审核
        ztc.setZtCzzt(ZdCzztEnumProcess.ZD__CZZT_DSH.getCode());
        ztc.setZtShyj("");
        zhiduDao.saveZdZt(ztc);
    }

    private void updateZdZt(Integer zdId, Integer ztCzzt, Date ztDate,String ZtShyj){
        // 获取需要修改的制度
        List<SZhiduzhizeZt> zdzts= zhiduDao.listZdztDescByZtid(zdId);
        SZhiduzhizeZt dqZt = zdzts.get(0);

        dqZt.setZtCzzt(ztCzzt);
        dqZt.setZtDate(ztDate);
        dqZt.setZtShyj(ZtShyj);
        //更新状态
//        SZhiduzhizeZt sZhiduzhizeZt = new SZhiduzhizeZt();
//        //组装状态
//        sZhiduzhizeZt.setZtId(shMsgVO.getZtId());
//        sZhiduzhizeZt.setZtCzzt(shMsgVO.getZtCzzt());
//        sZhiduzhizeZt.setZtDate(shMsgVO.getZtDate());
//        sZhiduzhizeZt.setZtShyj(shMsgVO.getZtShyj());
//        //更新状态
//        zhiduDao.updateZdzt(sZhiduzhizeZt);
        zhiduDao.updateZdzt(dqZt);

    }

    private String getDclCzztName(Integer zdId) {
        List<SZhiduzhizeZt> zdzts = zhiduDao.listZdztDescByDate(zdId);
        if(zdzts==null) return ShProcessConstants.SH_PROCESS.get(ShProcessConstants.PROCESS_CODE);
        return zdzts.get(0).getZtCzname();
    }


    @Override
    public void submit(ZhiduSubmitVO zhiduSubmitVO) {
        SZhidu  zd = zhiduSubmitVO.getsZhidu();
        //填充信息
        zd.setZdZt(ZdztEnumProcess.ZD__ZT_SHZ.getCode());  //审核中  3 备案 2 试用 1 审核中 0 审核失败
        zd.setSyTianshu(0);  //试用时间
        zd.setSySyts(0);    //试用剩余时间
        zd.setZdXgcs(0);   //修改次数为0
        //先保存制度信息
        zhiduDao.saveZd(zd);

        //封装状态审核信息   提交状态
        SZhiduzhizeZt ztc = new SZhiduzhizeZt();
        ztc.setZdId(zd.getZdId());
        ztc.setUserId(zd.getUserId());
        ztc.setZtDate(zd.getCreateTime());
        ztc.setZtCzname(ShProcessConstants.SH_PROCESS.get(ShProcessConstants.ZD_SHZT_KEMUBX));  //编写
        ztc.setZtCzzt(ZdCzztEnumProcess.ZD__CZZT_TG.getCode());    //操作状态 2 通过 1 不通过  0 待处理
        ztc.setZtShyj("");
        zhiduDao.saveZdZt(ztc);


        //封装状态审核信息  待审核状态
//        SZhiduzhizeZt zt = new SZhiduzhizeZt();
//        zt.setZdId(zd.getZdId());
//
//        zt.setUserId(zhiduSubmitVO.getShrId());   //设置状态审核人
//        zt.setZtDate(zd.getCreateTime());
//        zt.setZtCzname("科长审核");
//        zt.setZtCzzt(ZdCzztEnumProcess.ZD__CZZT_DSH.getCode());  //操作状态 1 通过 0 不通过  2 待处理
//        zt.setZtShyj("默认");
//        zhiduDao.saveZdZt(zt);
          insertZdZt(zd.getZdId(),zhiduSubmitVO.getShrId(),true);

    }

    @Override
    public void reSubmit(ZhiduSubmitVO zhiduSubmitVO) {
        //判断是否是在使用期修改
//        SZhidu gzd = zhiduDao.getZdByZdId(zhiduSubmitVO.getsZhidu().getZdId());
//        if(gzd.getZdZt()==ZdztEnumProcess.ZD__ZT_SY.getCode()){//试用期修改
//
//        }
        //更新制度信息
        SZhidu  zd = zhiduSubmitVO.getsZhidu();
        //填充信息
        zd.setZdZt(ZdztEnumProcess.ZD__ZT_SHZ.getCode());  //审核中  3 备案 2 试用 1 审核中 0 审核失败
        zd.setSyTianshu(0);  //试用时间
        zd.setSySyts(0);    //试用剩余时间
        zd.setZdXgcs(0);   //修改次数为0
        //先保存制度信息
        zhiduDao.updateZd(zd);
        //更新老状态
        updateZdZt(zd.getZdId(),ZdCzztEnumProcess.ZD__CZZT_TG.getCode(),new Date(),"");
        //插入新状态
        insertZdZt(zd.getZdId(),zhiduSubmitVO.getShrId(),true);
    }

    @Override
    public PageInfo listZdsByShr(int pageNum, int pageSize, String shr_id) {
        PageHelper.startPage(pageNum,pageSize);
        List<SelectAsBaseShMsg> date =  zhiduDao.listZdsByShr(shr_id);
        return new PageInfo(date);
    }


    @Override
    public ShDetailMsg getShDetailMgsByZdId(Integer zdId, String shrId) {
        // 通过id 获取制度信息
        SZhiduSelect zd = zhiduDao.getZdSelectByZdId(zdId);
        // 通过id 获取审核信息
        List<SZhiduzhizeZtSelect> zts = zhiduDao.listZtsByZdId(zdId);
        ShDetailMsg shDetailMsg = new ShDetailMsg();
        //获取当前审核状态
        SZhiduzhizeZtSelect dqShMsg = zhiduDao.getDqShMsg(zdId,shrId);
        shDetailMsg.setsZhidu(zd);
        shDetailMsg.setZts(zts);
        shDetailMsg.setDqshzt(dqShMsg);
        return shDetailMsg;
    }

    @Override
    public void submitShMsg(ShMsgVO shMsgVO) {     // 审核提交  先更新  然后根据审核状态添加的状态

//        SZhiduzhizeZt sZhiduzhizeZt = new SZhiduzhizeZt();
//        //组装状态
//        sZhiduzhizeZt.setZtId(shMsgVO.getZtId());
//        sZhiduzhizeZt.setZtCzzt(shMsgVO.getZtCzzt());
//        sZhiduzhizeZt.setZtDate(shMsgVO.getZtDate());
//        sZhiduzhizeZt.setZtShyj(shMsgVO.getZtShyj());
//        //更新状态
//        zhiduDao.updateZdzt(sZhiduzhizeZt);
        //更新状态
        updateZdZt(shMsgVO.getZdId(),shMsgVO.getZtCzzt(),shMsgVO.getZtDate(),shMsgVO.getZtShyj());

        if(shMsgVO.getZtCzzt()==ZdCzztEnumProcess.ZD__CZZT_TG.getCode() && shMsgVO.getNextShrId()!=null){   //审核通过且继续审核
            //插入新的审核状态
//            SZhiduzhizeZt new_sZhiduzhizeZt = new SZhiduzhizeZt();
//            new_sZhiduzhizeZt.setZdId(shMsgVO.getZdId());
//            new_sZhiduzhizeZt.setUserId(shMsgVO.getNextShrId());
//            new_sZhiduzhizeZt.setZtCzzt(ZdCzztEnumProcess.ZD__CZZT_DSH.getCode()); // 待审核状态
//            new_sZhiduzhizeZt.setZtShyj("默认");
//            new_sZhiduzhizeZt.setZtCzname("处长审核");
//            zhiduDao.saveZdZt(new_sZhiduzhizeZt);

            insertZdZt(shMsgVO.getZdId(),shMsgVO.getNextShrId(),true);


        } else if(shMsgVO.getZtCzzt()==ZdCzztEnumProcess.ZD__CZZT_TG.getCode() && shMsgVO.getNextShrId()==null){ //审核通过且结束

            zhiduDao.setZhiDuZt(shMsgVO.getZdId(),ZdztEnumProcess.ZD__ZT_SY.getCode(),shMsgVO.getSyDays());  //插入试用状态
            //当试用时间通过 修改时间  修改状态0-》2
            insertZdZt(shMsgVO.getZdId(),null,true); //更新制度表的审核状态和试用时间


        } else if(shMsgVO.getZtCzzt()==ZdCzztEnumProcess.ZD__CZZT__BTG.getCode()){//审核不通过
//            zhiduDao.setZhiDuZt(shMsgVO.getZdId(),"0",0);
            //更新制度状态 为0未通过
            insertZdZt(shMsgVO.getZdId(),null,false);
        }

    }

}
