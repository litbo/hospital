package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.bean.SGangwei;
import com.litbo.hospital.supervise.bean.SZhidu;
import com.litbo.hospital.supervise.bean.SZhiduzhizeZt;
import com.litbo.hospital.supervise.dao.EmpDao;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class GangweiServiceImpl implements GangweiService {

    @Autowired
    private GangweiDao gangweiDao;
    @Autowired
    private ZhiduDao zhiduDao;

    @Autowired
    private EmpDao empDao;

    @Override
    public void saveGw(SGangwei gw) {
        gw.setGwZzZt(ZdztEnumProcess.ZD__ZT_WBX.getCode());
        gw.setZdXgcs(0);
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
    public PageInfo listGwsByGwZt(int pageNum, int pageSize, String gwZt) {

        PageHelper.startPage(pageNum,pageSize);
        List<GangWeiAndZtVO> vos =  gangweiDao.listGwsByGwZt(gwZt);
        for (GangWeiAndZtVO vo:vos){
            setGangWeiAndZtVO(vo);
        }
        return new PageInfo(vos);
    }
    private void setGangWeiAndZtVO(GangWeiAndZtVO vo){
        List<SZhiduzhizeZt> zts = gangweiDao.listZdztDescByZzId(vo.getGwId());
        if(zts.size()<=0) return;
        vo.setZtCzname(zts.get(0).getZtCzname());
        if(zts.get(0).getZtDate()!=null)
            vo.setZtDate(zts.get(0).getZtDate());
    }

    @Override
    public PageInfo listGwsByTimeAndZdNameAndZt(int pageNum, int pageSize, String startTime, String endTime, String gwName, String gwZt,String reFlag) throws  Exception{
        PageHelper.startPage(pageNum,pageSize);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(endTime!=null && !endTime.equals("")){
            Date date = sdf.parse(endTime);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, 1);
            endTime=sdf.format(cal.getTime()).toString();
        }

        List<GangWeiAndZtVO> vos =  gangweiDao.listGwsByTimeAndZdNameAndZt(startTime,endTime,gwName,gwZt,reFlag);
        for (GangWeiAndZtVO vo:vos){
            setGangWeiAndZtVO(vo);
        }
        return new PageInfo(vos);
    }


    @Override
    public PageInfo getGwsByGwLevelAndGwName(int pageNum, int pageSize, String gwLevel, String gwName) {
        PageHelper.startPage(pageNum,pageSize);
        List<SGangwei> list =  gangweiDao.getGwsByGwLevelAndGwName(gwLevel,gwName);
        return new PageInfo(list);
    }

    @Override
    public SGangwei getGwsByGwId(String gw_id) {
        SGangwei gw =  gangweiDao.getGwsByGwId(gw_id);
        return gw;
    }

    @Override
    public List<SGangwei> getGwByGwLevel(String gw_level) {

        return gangweiDao.getGwByGwLevel(gw_level);
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
        if(gangweiDao.getGwsByGwId(gwSubmitVO.getGwId().toString()).getGwZzZt()!=null){
            reSubmit(gwSubmitVO);
            return;
        }
//        SGangwei gw = gwSubmitVO.getsGangwei();
        SGangwei gw = new SGangwei();
        gw.setGwId(gwSubmitVO.getGwId());
        gw.setGwName(gwSubmitVO.getGwName());
        gw.setGwZz(gwSubmitVO.getGwZz());
        gw.setUserId(gwSubmitVO.getUserId());
        gw.setCreateTime(new Date());
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
        if (dclCzztName.equals("试用")) isTg = false;
        String dqCzztName = GwZzShProcessConstants.autoGetProcessName(dclCzztName,isTg);
        //设置审核状态名字
        if(dqCzztName.equals("试用")||dqCzztName.equals("科室秘书编写")||dqCzztName.equals("试用期修改")){
            ztc.setZtDate(new Date());
        }
        ztc.setZtCzname(GwZzShProcessConstants.SH_PROCESS.get(GwZzShProcessConstants.PROCESS_CODE));
        //设置状态为待审核
        if(dqCzztName.equals("试用期修改")){
            ztc.setZtCzzt(ZdCzztEnumProcess.ZD__CZZT_TG.getCode());
        }else{
            ztc.setZtCzzt(ZdCzztEnumProcess.ZD__CZZT_DSH.getCode());
        }
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

        updateZzZt(shMsgVO.getZdId(),shMsgVO.getZtCzzt(),new Date(),shMsgVO.getZtShyj());

        if(shMsgVO.getZtCzzt()==ZdCzztEnumProcess.ZD__CZZT_TG.getCode() && shMsgVO.getNextShrId()!=null){   //审核通过且继续审核
            insertZdZt(shMsgVO.getZdId(),shMsgVO.getNextShrId(),true);


        } else if(shMsgVO.getZtCzzt()==ZdCzztEnumProcess.ZD__CZZT_TG.getCode() && shMsgVO.getNextShrId()==null){ //审核通过且结束

            gangweiDao.updateGwZt(shMsgVO.getZdId(),ZdztEnumProcess.ZD__ZT_SY.getCode(),shMsgVO.getSyDays());  //插入试用状态
            //当试用时间通过 修改时间  修改状态0-》2
            insertZdZt(shMsgVO.getZdId(),null,true); //更新制度表的审核状态和试用时间


        } else if(shMsgVO.getZtCzzt()==ZdCzztEnumProcess.ZD__CZZT__BTG.getCode()){//审核不通过
            gangweiDao.updateGwZt(shMsgVO.getZdId(),ZdztEnumProcess.ZD__ZT_SHSB.getCode(),shMsgVO.getSyDays());
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
        SGangwei gw = new SGangwei();
        gw.setGwId(gwSubmitVO.getGwId());
        gw.setGwName(gwSubmitVO.getGwName());
        gw.setGwZz(gwSubmitVO.getGwZz());
        gw.setUserId(gwSubmitVO.getUserId());
        gw.setCreateTime(new Date());
        //填充信息
        gw.setGwZzZt(ZdztEnumProcess.ZD__ZT_SHZ.getCode());  //审核中  3 备案 2 试用 1 审核中 0 审核失败
        gw.setSyTianshu(0);  //试用时间
        gw.setSySyts(0);    //试用剩余时间
        //先保存制度信息
        gangweiDao.insertGwZz(gw);
        //更新老状态
        updateZzZt(gw.getGwId(),ZdCzztEnumProcess.ZD__CZZT_TG.getCode(),new Date(),"");
        //插入新状态
        insertZdZt(gw.getGwId(),gwSubmitVO.getShrId(),true);
        //判断是否是在试用期修改
        if(getDclCzztName(gw.getGwId()).equals("试用期修改")){
            insertZdZt(gw.getGwId(),gwSubmitVO.getShrId(),true);
        }
    }

    @Override
    public void dpjSubmitMsg(ZpjSumbitVO zpjSumbitVO) {
        //修改制度状态为待评价
        gangweiDao.updateGwZtIncludeReFlag(Integer.parseInt(zpjSumbitVO.getGwId()),ZdztEnumProcess.ZD__ZT_DPJ.getCode(),1);

        //插入审核状态
        SZhiduzhizeZt ztc = new SZhiduzhizeZt();
        //设置制度ID
        ztc.setZdId(Integer.parseInt(zpjSumbitVO.getGwId()));
        //设置审核状态名字
        ztc.setZtCzname("待评价");
        ztc.setZtDate(new Date());
        ztc.setUserId(zpjSumbitVO.getUserId());
        ztc.setZtCzzt(ZdCzztEnumProcess.ZD__CZZT_DSH.getCode());
        ztc.setZtShyj(zpjSumbitVO.getZpjReason());
        gangweiDao.saveZzZt(ztc);
    }

    @Override
    public GwZpjMsgVO getZpjMsgByGwId(String gwId) {
        GwZpjMsgVO gwZpjMsgVO = new GwZpjMsgVO();
        SGangwei gw = gangweiDao.getGwsByGwId(gwId);
        gwZpjMsgVO.setGwId(gwId);
        gwZpjMsgVO.setGwName(gw.getGwName());
        gwZpjMsgVO.setGwZz(gw.getGwZz());
        gwZpjMsgVO.setDocUrl(gw.getDocUrl());
        List<SZhiduzhizeZt> zts = gangweiDao.listZdztDescByZzId(Integer.parseInt(gwId));
        SZhiduzhizeZt zt = zts.get(0);
        gwZpjMsgVO.setSqDate(zt.getZtDate());
        gwZpjMsgVO.setSqUserId(zt.getUserId());
        gwZpjMsgVO.setZpjReason(zt.getZtShyj());
        return gwZpjMsgVO;
    }

    @Override
    public void dpjSubmitShMsg(GwZpjSubmitVO gwZpjSubmitVO) {
        if(gwZpjSubmitVO.getZtCzzt()==1){
            gangweiDao.updateGwZt(Integer.parseInt(gwZpjSubmitVO.getGwId()),ZdztEnumProcess.ZD__ZT_BA.getCode(),0);
            updateZzZt(Integer.parseInt(gwZpjSubmitVO.getGwId()),gwZpjSubmitVO.getZtCzzt(),new Date(),gwZpjSubmitVO.getZtShyj());
        }else if(gwZpjSubmitVO.getZtCzzt()==2){
            gangweiDao.updateGwZt(Integer.parseInt(gwZpjSubmitVO.getGwId()),ZdztEnumProcess.ZD__ZT_SHSB.getCode(),0);
            updateZzZt(Integer.parseInt(gwZpjSubmitVO.getGwId()),gwZpjSubmitVO.getZtCzzt(),new Date(),gwZpjSubmitVO.getZtShyj());

            //插入审核状态
            SZhiduzhizeZt ztc = new SZhiduzhizeZt();
            //设置制度ID
            ztc.setZdId(Integer.parseInt(gwZpjSubmitVO.getGwId()));
            //设置审核状态名字
            ztc.setZtCzname("科室秘书编写");
            ztc.setZtCzzt(ZdCzztEnumProcess.ZD__CZZT_DSH.getCode());
            ztc.setZtShyj("");
            gangweiDao.saveZzZt(ztc);
        }
    }

    @Override
    public PageInfo getShProcesses(int pageNum, int pageSize, Integer gwId) {
        PageHelper.startPage(pageNum,pageSize);
        List<SZhiduzhizeZt> zts= gangweiDao.getShProcesses(gwId);

        SGangwei gw = gangweiDao.getGwsByGwId(gwId.toString());
        List<GwShProcessDetailVO> processes = new ArrayList<>();
        int i=1;
        for(SZhiduzhizeZt zt:zts){
            GwShProcessDetailVO vo = new GwShProcessDetailVO();
            vo.setId(i);
            vo.setGwName(gw.getGwName());
            vo.setZtCzname(zt.getZtCzname());
            SEmp shr = empDao.getEmpsById(zt.getUserId());
            if(shr!=null)
                vo.setShr(shr.getUserXm());
            vo.setZtDate(zt.getZtDate());
            if(zt.getZtCzzt()==2){
                vo.setIsTg("通过");
            }else if(zt.getZtCzzt()==1){
                vo.setIsTg("不通过");
            }else{
                vo.setIsTg("待审核");
            }
            vo.setYj(zt.getZtShyj());
            processes.add(vo);
            i++;
        }
        return new PageInfo(processes);
    }
}
