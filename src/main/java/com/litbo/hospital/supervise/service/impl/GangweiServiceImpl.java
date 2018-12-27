package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SGangwei;
import com.litbo.hospital.supervise.bean.SZhiduzhizeZt;
import com.litbo.hospital.supervise.dao.GangweiDao;
import com.litbo.hospital.supervise.dao.ZhiduDao;
import com.litbo.hospital.supervise.enums.GwZzShProcessConstants;
import com.litbo.hospital.supervise.enums.ZDShProcessConstants;
import com.litbo.hospital.supervise.enums.ZdCzztEnumProcess;
import com.litbo.hospital.supervise.enums.ZdztEnumProcess;
import com.litbo.hospital.supervise.service.GangweiService;
import com.litbo.hospital.supervise.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GangweiServiceImpl implements GangweiService {

    @Autowired
    private GangweiDao gangweiDao;
    @Autowired
    private ZhiduDao zhiduDao;


    @Override
    public void saveGw(SGangwei gw) {
        gangweiDao.saveGw(gw);
    }

    @Override
    public void deleteGwByGwId(String gw_id) {
        gangweiDao.deleteGwByGwId(gw_id);
    }

    @Override
    public PageInfo getGws(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SGangwei> list =  gangweiDao.getGws();
        return new PageInfo(list);
    }

    @Override
    public SGangwei getGwsByGwId(int pageNum, int pageSize, String gw_id) {
        PageHelper.startPage(pageNum,pageSize);
        SGangwei gw =  gangweiDao.getGwsByGwId(gw_id);
        return gw;
    }

    @Override
    public PageInfo getGwsByGwZzZt(int pageNum, int pageSize, Integer gwZzZt) {
        PageHelper.startPage(pageNum,pageSize);
        List<SGangwei> gws =  gangweiDao.getGwsByGwZzZt(gwZzZt);
        return new PageInfo(gws);
    }

    @Override
    public void updateGw(SGangwei gw) {
        gangweiDao.updateGw(gw);

    }

    @Override
    public GWReadyResourcesVO readyResources() {
        GWReadyResourcesVO readyResourcesVO = new GWReadyResourcesVO();
        List<SGangwei> gws = gangweiDao.getGws();
        readyResourcesVO.setGws(gws);

        return readyResourcesVO;
    }

    @Override
    public void gwzzSubmit(GWSubmitVO gwSubmitVO) {
        SGangwei gw = gwSubmitVO.getsGangwei();
        //填充信息
        gw.setGwZzZt(ZdztEnumProcess.ZD__ZT_SHZ.getCode());  //审核中  3 备案 2 试用 1 审核中 0 审核失败
        gw.setSyTianshu(0);  //试用时间
        gw.setSySyts(0);    //试用剩余时间
        gw.setZdXgcs(0);   //修改次数为0
        //先保存制度信息
        gangweiDao.insertGwZz(gw);
        //封装状态审核信息   提交状态
        SZhiduzhizeZt ztc = new SZhiduzhizeZt();
        ztc.setZdId(gw.getGwId());
        ztc.setUserId(gw.getUserId());
        ztc.setZtDate(gw.getCreateTime());
        ztc.setZtCzname(GwZzShProcessConstants.SH_PROCESS.get(ZDShProcessConstants.ZD_SHZT_KEMUBX));  //编写
        ztc.setZtCzzt(ZdCzztEnumProcess.ZD__CZZT_TG.getCode());    //操作状态 2 通过 1 不通过  0 待处理
        ztc.setZtShyj("");
        gangweiDao.saveZzZt(ztc);

        insertZdZt(gw.getGwId(),gwSubmitVO.getShrId(),true);
    }
    private void insertZdZt(Integer gwId,String shrId,Boolean isTg){
        // 准备 制度id  审核人id  制度操作名称 制度操作状态
        SZhiduzhizeZt ztc = new SZhiduzhizeZt();
        //设置制度ID
        ztc.setZdId(gwId);
        //设置审核人
        if(shrId!=null) ztc.setUserId(shrId);
        //获得审核名字
        String dclCzztName = getDclCzztName(gwId);
        String dqCzztName = GwZzShProcessConstants.autoGetProcessName(dclCzztName,isTg);
        //设置审核状态名字
        ztc.setZtCzname(GwZzShProcessConstants.SH_PROCESS.get(GwZzShProcessConstants.PROCESS_CODE));
        //设置状态为待审核
        ztc.setZtCzzt(ZdCzztEnumProcess.ZD__CZZT_DSH.getCode());
        ztc.setZtShyj("");
        gangweiDao.saveZzZt(ztc);
    }
    private String getDclCzztName(Integer gwId) {
        List<SZhiduzhizeZt> zdzts = gangweiDao.listZzZtDescByDate(gwId);
        if(zdzts==null) return GwZzShProcessConstants.SH_PROCESS.get(GwZzShProcessConstants.PROCESS_CODE);
        return zdzts.get(0).getZtCzname();
    }

    @Override
    public PageInfo listZdsByShr(int pageNum, int pageSize, String shr_id) {
        PageHelper.startPage(pageNum,pageSize);
        List<ZZSelectAsBaseShMsg> date =  gangweiDao.listZdsByShr(shr_id);
        return new PageInfo(date);
    }

    @Override
    public GwShDetailMsg getShDetailMgsByZdId(Integer gwId, String shrId) {
        // 通过id 获取制度信息
        SGangweiSelect gw = gangweiDao.getGwSelectByGwId(gwId);
        // 通过id 获取审核信息
        List<SZhiduzhizeZtSelect> zts = gangweiDao.listZtsByGwId(gwId);
        GwShDetailMsg shDetailMsg = new GwShDetailMsg();
        //获取当前审核状态
        SZhiduzhizeZtSelect dqShMsg = gangweiDao.getDqShMsg(gwId,shrId);
        shDetailMsg.setsGangwei(gw);
        shDetailMsg.setZts(zts);
        shDetailMsg.setDqshzt(dqShMsg);
        return shDetailMsg;

    }

    private void updateZzZt(Integer zzId, Integer ztCzzt, Date ztDate, String ZtShyj){
        // 获取需要修改的制度
        List<SZhiduzhizeZt> zdzts= gangweiDao.listZdztDescByZzId(zzId);
        SZhiduzhizeZt dqZt = zdzts.get(0);

        dqZt.setZtCzzt(ztCzzt);
        dqZt.setZtDate(ztDate);
        dqZt.setZtShyj(ZtShyj);

        gangweiDao.updateZzzt(dqZt);


    }


    @Override
    public void submitShMsg(ShMsgVO shMsgVO) {

        updateZzZt(shMsgVO.getZdId(),shMsgVO.getZtCzzt(),shMsgVO.getZtDate(),shMsgVO.getZtShyj());

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

            gangweiDao.updateGwZt(shMsgVO.getZdId(),ZdztEnumProcess.ZD__ZT_SY.getCode(),shMsgVO.getSyDays());  //插入试用状态
            //当试用时间通过 修改时间  修改状态0-》2
            insertZdZt(shMsgVO.getZdId(),null,true); //更新制度表的审核状态和试用时间


        } else if(shMsgVO.getZtCzzt()==ZdCzztEnumProcess.ZD__CZZT__BTG.getCode()){//审核不通过
//            zhiduDao.setZhiDuZt(shMsgVO.getZdId(),"0",0);
            //更新制度状态 为0未通过
            insertZdZt(shMsgVO.getZdId(),null,false);
        }

    }

    @Override
    public PageInfo listGwsByShrAndZzZt(int pageNum, int pageSize, String shr_id, Integer gwZzZt) {
        PageHelper.startPage(pageNum,pageSize);
        List<ZZSelectAsBaseShMsg> date =  gangweiDao.listGwsByShrAndZzZt(shr_id,gwZzZt);
        return new PageInfo(date);
    }

    @Override
    public GwZzReadyForXgVO readyForXgByGwId(Integer gwId) {
        GwZzReadyForXgVO xgVO = new GwZzReadyForXgVO();
        List<SZhiduzhizeZt> zts = gangweiDao.listZzZtDescByDate(gwId);
        xgVO.setXgyj(zts.get(0).getZtShyj());
        SGangwei gw = gangweiDao.getGwsByGwId(Integer.toString(gwId));
        xgVO.setsGangwei(gw);
        return xgVO;
    }

    @Override
    public void reSubmit(GWSubmitVO gwSubmitVO) {

        //更新制度信息
        SGangwei gw = gwSubmitVO.getsGangwei();
        //填充信息
        gw.setGwZzZt(ZdztEnumProcess.ZD__ZT_SHZ.getCode());  //审核中  3 备案 2 试用 1 审核中 0 审核失败
        gw.setSyTianshu(0);  //试用时间
        gw.setSySyts(0);    //试用剩余时间
        gw.setZdXgcs(0);   //修改次数为0
        //先保存制度信息
        gangweiDao.insertGwZz(gw);
        //更新老状态
        updateZzZt(gw.getGwId(),ZdCzztEnumProcess.ZD__CZZT_TG.getCode(),new Date(),"");
        //插入新状态
        insertZdZt(gw.getGwId(),gwSubmitVO.getShrId(),true);
    }
}
