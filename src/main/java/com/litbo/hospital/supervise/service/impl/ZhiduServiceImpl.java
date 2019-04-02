package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.UploadFile;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.bean.SZhidu;
import com.litbo.hospital.supervise.bean.SZhiduzhizeZt;
import com.litbo.hospital.supervise.dao.BmDao;
import com.litbo.hospital.supervise.dao.EmpDao;
import com.litbo.hospital.supervise.dao.ZhiduDao;
import com.litbo.hospital.supervise.enums.ZDShProcessConstants;
import com.litbo.hospital.supervise.enums.ZdCzztEnumProcess;
import com.litbo.hospital.supervise.enums.ZdztEnumProcess;
import com.litbo.hospital.supervise.service.ZhiduService;
import com.litbo.hospital.supervise.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



@Service
public class ZhiduServiceImpl implements ZhiduService {
    @Autowired
    private ZhiduDao zhiduDao;
    @Autowired
    private EmpDao empDao;
    @Autowired
    private BmDao bmDao;
    @Override
    public PageInfo getZds(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SZhidu> date =  zhiduDao.getZds();
        return new PageInfo(date);
    }

    @Override
    public SZhidu getZdById(String id) {
        SZhidu zhidu=zhiduDao.getZdById(id);
        String path = System.getProperty("user.dir");
        zhidu.setDocUrl(zhidu.getDocUrl().replace(path,""));
        zhidu.setBmName(bmDao.getBmBybmid(zhidu.getBmId()).getBmName());
        return zhidu;
    }

    @Override
    public PageInfo listZdsByZdZt(int pageNum, int pageSize, String zdZt) {
        PageHelper.startPage(pageNum,pageSize);
        List<ZhuduAndZdZzVO> vos =  zhiduDao.listZdsByZdZt(zdZt);
        for (ZhuduAndZdZzVO vo:vos){
            setZhuduAndZdZzVO(vo);
        }
        return new PageInfo(vos);
    }

    @Override
    public PageInfo listZdsByTimeAndZdNameAndZt(int pageNum, int pageSize, String startTime, String endTime, String zdName, String zdZt,String reFlag)throws  Exception {
        PageHelper.startPage(pageNum,pageSize);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(endTime!=null && !endTime.equals("")){
            Date date = sdf.parse(endTime);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, 1);
            endTime=sdf.format(cal.getTime()).toString();
        }

        List<ZhuduAndZdZzVO> vos =  zhiduDao.listZdsByTimeAndZdNameAndZt(startTime,endTime,zdName,zdZt,reFlag);
        for (ZhuduAndZdZzVO vo:vos){
            setZhuduAndZdZzVO(vo);
        }

        return new PageInfo(vos);
    }

    private void setZhuduAndZdZzVO(ZhuduAndZdZzVO vo){
        List<SZhiduzhizeZt> zts = zhiduDao.listZdztDescByZtId(vo.getZdId());
        vo.setZtCzname(zts.get(0).getZtCzname());
        if(zts.get(0).getZtDate()!=null)
            vo.setZtDate(zts.get(0).getZtDate());
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
        if (dclCzztName.equals("试用")) isTg = false;
        String dqCzztName = ZDShProcessConstants.autoGetProcessName(dclCzztName,isTg);

        if(dqCzztName.equals("试用")||dqCzztName.equals("科室秘书编写")||dqCzztName.equals("试用期修改")){
            ztc.setZtDate(new Date());
        }
        //设置审核状态名字
        ztc.setZtCzname(ZDShProcessConstants.SH_PROCESS.get(ZDShProcessConstants.PROCESS_CODE));
        if(dqCzztName.equals("试用期修改")){
            ztc.setZtCzzt(ZdCzztEnumProcess.ZD__CZZT_TG.getCode());
        }else{
            //设置状态为待审核
            ztc.setZtCzzt(ZdCzztEnumProcess.ZD__CZZT_DSH.getCode());
        }
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
        zhiduDao.updateZdzt(dqZt);

    }

    private String getDclCzztName(Integer zdId) {
        List<SZhiduzhizeZt> zdzts = zhiduDao.listZdztDescByDate(zdId);
        if(zdzts==null) return ZDShProcessConstants.SH_PROCESS.get(ZDShProcessConstants.PROCESS_CODE);
        return zdzts.get(0).getZtCzname();
    }


    @Override
    public void submit(ZhiduSubmitVO zhiduSubmitVO) {

        if(zhiduSubmitVO.getZdId()!=null){
            reSubmit(zhiduSubmitVO);
            return;
        }

        SZhidu zd = new SZhidu();
        zd.setZdName(zhiduSubmitVO.getZdName());
        Date date = new Date();
        zd.setCreateTime(date);
        zd.setZdContent(zhiduSubmitVO.getZdContent());
        zd.setUserId(zhiduSubmitVO.getUserId());
        zd.setBmId(zhiduSubmitVO.getBmId());
        zd.setDocUrl(zhiduSubmitVO.getDocUrl());
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
        ztc.setZtDate(date);
//        ztc.setZtDate(zd.getCreateTime());
        ztc.setZtCzname(ZDShProcessConstants.SH_PROCESS.get(ZDShProcessConstants.ZD_SHZT_KEMUBX));  //编写
        ztc.setZtCzzt(ZdCzztEnumProcess.ZD__CZZT_TG.getCode());    //操作状态 2 通过 1 不通过  0 待处理
        ztc.setZtShyj("");
        zhiduDao.saveZdZt(ztc);

        insertZdZt(zd.getZdId(),zhiduSubmitVO.getShrId(),true);

    }

    @Override
    public void reSubmit(ZhiduSubmitVO zhiduSubmitVO) {
        SZhidu zd = new SZhidu();
        zd.setZdId(zhiduSubmitVO.getZdId());
        zd.setZdName(zhiduSubmitVO.getZdName());
        zd.setCreateTime(new Date());
        zd.setZdContent(zhiduSubmitVO.getZdContent());
        zd.setUserId(zhiduSubmitVO.getUserId());
        zd.setBmId(zhiduSubmitVO.getBmId());
        zd.setDocUrl(zhiduSubmitVO.getDocUrl());

        //填充信息
        zd.setZdZt(ZdztEnumProcess.ZD__ZT_SHZ.getCode());  //审核中  3 备案 2 试用 1 审核中 0 审核失败
        zd.setSyTianshu(0);  //试用时间
        zd.setSySyts(0);    //试用剩余时间
        //先保存制度信息
        zhiduDao.updateZd(zd);
        //更新老状态
        updateZdZt(zd.getZdId(),ZdCzztEnumProcess.ZD__CZZT_TG.getCode(),new Date(),"");
        //插入新状态
        insertZdZt(zd.getZdId(),zhiduSubmitVO.getShrId(),true);
        //判断是否是在试用期修改
        if(getDclCzztName(zd.getZdId()).equals("试用期修改")){
            insertZdZt(zd.getZdId(),zhiduSubmitVO.getShrId(),true);
        }
        //更新制度信息
    }

    @Override
    public PageInfo listZdsByShr(int pageNum, int pageSize, String shr_id,String zdZt,String reFlag,String zdName) {
        PageHelper.startPage(pageNum,pageSize);
        List<ZDSelectAsBaseShMsg> date =  zhiduDao.listZdsByShr(shr_id,zdZt,reFlag,zdName);
        return new PageInfo(date);
    }


    @Override
    public ZdShDetailMsg getShDetailMgsByZdId(Integer zdId, String shrId) {
        // 通过id 获取制度信息
        SZhiduSelect zd = zhiduDao.getZdSelectByZdId(zdId);
        // 通过id 获取审核信息
        List<SZhiduzhizeZtSelect> zts = zhiduDao.listZtsByZdId(zdId);
        ZdShDetailMsg shDetailMsg = new ZdShDetailMsg();
        //获取当前审核状态
        SZhiduzhizeZtSelect dqShMsg = zhiduDao.getDqShMsg(zdId,shrId);
        shDetailMsg.setsZhidu(zd);
        shDetailMsg.setZts(zts);
        shDetailMsg.setDqshzt(dqShMsg);
        return shDetailMsg;
    }

    @Override
    public void submitShMsg(ShMsgVO shMsgVO) {     // 审核提交  先更新  然后根据审核状态添加的状态

        if(shMsgVO.getZtShyj()==null)shMsgVO.setZtShyj("");
        updateZdZt(shMsgVO.getZdId(),shMsgVO.getZtCzzt(),new Date(),shMsgVO.getZtShyj());

        if(shMsgVO.getZtCzzt()==ZdCzztEnumProcess.ZD__CZZT_TG.getCode() && shMsgVO.getNextShrId()!=null){   //审核通过且继续审核

            insertZdZt(shMsgVO.getZdId(),shMsgVO.getNextShrId(),true);


        } else if(shMsgVO.getZtCzzt()==ZdCzztEnumProcess.ZD__CZZT_TG.getCode() && shMsgVO.getNextShrId()==null){ //审核通过且结束

            zhiduDao.setZhiDuZt(shMsgVO.getZdId(),ZdztEnumProcess.ZD__ZT_SY.getCode(),shMsgVO.getSyDays());  //插入试用状态
            //当试用时间通过 修改时间  修改状态0-》2
            insertZdZt(shMsgVO.getZdId(),zhiduDao.getZdById(shMsgVO.getZdId().toString()).getUserId(),true); //更新制度表的审核状态和试用时间

        } else if(shMsgVO.getZtCzzt()==ZdCzztEnumProcess.ZD__CZZT__BTG.getCode()){//审核不通过
//            zhiduDao.setZhiDuZt(shMsgVO.getZdId(),"0",0);
            //更新制度状态 为0未通过
            insertZdZt(shMsgVO.getZdId(),zhiduDao.getZdById(shMsgVO.getZdId().toString()).getUserId(),false);
            zhiduDao.setZhiDuZt(shMsgVO.getZdId(),ZdztEnumProcess.ZD__ZT_SHSB.getCode(),0);
        }

    }

    @Override
    public PageInfo getShProcesses(int pageNum, int pageSize, Integer zdId) {
        PageHelper.startPage(pageNum,pageSize);
        List<SZhiduzhizeZt> zts= zhiduDao.getShProcesses(zdId);
        SZhidu zd = zhiduDao.getZdById(zdId.toString());
        List<ZhiduShProcessDetailVO> processes = new ArrayList<>();
        int i=1;
        for(SZhiduzhizeZt zt:zts){
            ZhiduShProcessDetailVO vo = new ZhiduShProcessDetailVO();
            vo.setId(i);
            vo.setZdName(zd.getZdName());
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

    @Override
    public void dpjSubmitMsg(ZpjSumbitVO zpjSumbitVO) {
        if(zpjSumbitVO.getZpjReason()==null) zpjSumbitVO.setZpjReason("");
        //修改制度状态为待修改
        zhiduDao.setZhiDuZtIncludeReflag(Integer.parseInt(zpjSumbitVO.getZdId()),ZdztEnumProcess.ZD__ZT_DPJ.getCode(),1);

        //插入审核状态
        SZhiduzhizeZt ztc = new SZhiduzhizeZt();
        //设置制度ID
        ztc.setZdId(Integer.parseInt(zpjSumbitVO.getZdId()));
        //设置审核状态名字
        ztc.setZtCzname("待评价");
        ztc.setZtDate(new Date());

        ztc.setUserId(zpjSumbitVO.getUserId1());
        ztc.setZtCzzt(ZdCzztEnumProcess.ZD__CZZT_DSH.getCode());
        ztc.setZtShyj(zpjSumbitVO.getZpjReason());
        zhiduDao.saveZdZt(ztc);
    }

    @Override
    public ZpjMsgVO getZpjMsgByZdId(String zdId) {
        ZpjMsgVO zpjMsgVO = new ZpjMsgVO();
        SZhidu zd = zhiduDao.getZdById(zdId);
        zpjMsgVO.setZdId(zdId);
        zpjMsgVO.setZdName(zd.getZdName());
        zpjMsgVO.setBmId(zd.getBmId());
        zpjMsgVO.setDocUrl(zd.getDocUrl());
        zpjMsgVO.setZdContent(zd.getZdContent());

        List<SZhiduzhizeZt> zts = zhiduDao.listZdztDescByZtId(Integer.parseInt(zdId));
        SZhiduzhizeZt sZhiduzhizeZt = zts.get(0);
        zpjMsgVO.setZpjReason(sZhiduzhizeZt.getZtShyj());
        zpjMsgVO.setSqUserId(sZhiduzhizeZt.getUserId());
        zpjMsgVO.setSqUserName(empDao.getEmpByUserId(sZhiduzhizeZt.getUserId()).getUserXm());
        zpjMsgVO.setSqDate(sZhiduzhizeZt.getZtDate());

        return zpjMsgVO;
    }

    @Override
    public void dpjSubmitShMsg(ShMsgVO shMsgVO) {

        if(shMsgVO.getZtShyj()==null) shMsgVO.setZtShyj("");
        if(shMsgVO.getZtCzzt()==1){
            zhiduDao.setZhiDuZt(shMsgVO.getZdId(),ZdztEnumProcess.ZD__ZT_BA.getCode(),0);
            updateZdZt(shMsgVO.getZdId(),shMsgVO.getZtCzzt(),new Date(),shMsgVO.getZtShyj());
        }else if(shMsgVO.getZtCzzt()==2){
            zhiduDao.setZhiDuZt(shMsgVO.getZdId(),ZdztEnumProcess.ZD__ZT_SHSB.getCode(),0);
            updateZdZt(shMsgVO.getZdId(),shMsgVO.getZtCzzt(),new Date(),shMsgVO.getZtShyj());

            //插入审核状态
            SZhiduzhizeZt ztc = new SZhiduzhizeZt();
            //设置制度ID
            ztc.setZdId(shMsgVO.getZdId());
            //设置审核状态名字
            ztc.setZtCzname("科室秘书编写");
            ztc.setZtCzzt(ZdCzztEnumProcess.ZD__CZZT_DSH.getCode());
            ztc.setUserId(zhiduDao.getZdById(shMsgVO.getZdId().toString()).getUserId());
            ztc.setZtShyj("");
            zhiduDao.saveZdZt(ztc);
        }

    }

    @Override
    public String importZdDoc(MultipartFile file) {
        String path = System.getProperty("user.dir");
        String filePath =path+"/zd/";
        String url = UploadFile.upload(filePath,file);
        return url;
    }

}
