package com.litbo.hospital.supervise.scheduler;

import com.litbo.hospital.common.utils.DeleteFileUtils;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.bean.SGangwei;
import com.litbo.hospital.supervise.bean.SZhidu;
import com.litbo.hospital.supervise.bean.SZhiduzhizeZt;
import com.litbo.hospital.supervise.dao.*;
import com.litbo.hospital.supervise.enums.ZdCzztEnumProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class Scheduler {


    @Autowired
    private ZhiduDao zhiduDao;
    @Autowired
    private GangweiDao gangweiDao;
    @Autowired
    private EmpDao empDao;
    @Autowired
    private EqCsDao csDao;
    @Autowired
    private BmDao bmDao;

    //每天凌晨执行一次
    @Scheduled(cron = "0 00 00 * * ?")
//    @Scheduled(fixedDelay=30000)
    public void tasks() {

        //制度试用状态修改
        setZdZt();
        //职责试用状态修改
        setZzZt();
        //日常清理html文件
        clearHtml();

        refreshStaticFile();

    }

    private void refreshStaticFile(){
        String path = System.getProperty("user.dir");
        //清理emp/qzzp里没有更新到数据的图片
        System.out.println("emp文件清理中");
        String empQzzpPath=path+"\\emp\\qzzp\\";
        File empQzzpfile = new File(empQzzpPath);
        String[]  empQzzpfileNames= empQzzpfile.list();
        for(String empQzzpfileName:empQzzpfileNames){
            if(empDao.countEmpByQzzpName(empQzzpfileName)==0){
                String dd=path+"\\emp\\qzzp\\"+empQzzpfileName;
                DeleteFileUtils.deleteFolder(dd);
            }
        }
        //清理cs/cszj里和数据保存的地址不一样的照片
        System.out.println("cs文件清理中");
        String csCszj=path+"\\cs\\cszj\\";
        File csCszjFile = new File(csCszj);
        String[]  csCszjFileNames= csCszjFile.list();
        for(String csCszjFileName:csCszjFileNames){
            if(csDao.countCsZjByimgName(csCszjFileName)==0){
                String dd=path+"\\cs\\cszj\\"+csCszjFileName;
                DeleteFileUtils.deleteFolder(dd);
            }
        }

        //清理zd里和数据保存的地址不一样的照片
        System.out.println("zd文件清理中");
        String zdpath=path+"\\zd\\";
        File zdpathFile = new File(zdpath);
        String[]  zdpathFileNames= zdpathFile.list();
        for(String zdpathFileName:zdpathFileNames){
            if(zhiduDao.countZdByUrlName(zdpathFileName)==0){
                String dd=path+"\\zd\\"+zdpathFileName;
                DeleteFileUtils.deleteFolder(dd);
            }
        }

        System.out.println("文件清理中");


    }


    private void setZdZt(){
        System.out.println("制度设置中");
        //获取制度
        zhiduDao.scheUpdateSyTs();   //修改天数
        List<SZhidu> sZhidus = zhiduDao.scheSelectZtDxgZd();  //修改之前获取待修改对象
        zhiduDao.scheUpdateZt();
        for (SZhidu zhidu:sZhidus){
            zhiduDao.scheUpdateZtsh(zhidu.getZdId().toString()); //修改试用的审核状态

            //插入备案状态
            SZhiduzhizeZt ztc = new SZhiduzhizeZt();
            //设置制度ID
            ztc.setZdId(zhidu.getZdId());
            //设置审核状态名字
            ztc.setZtCzname("备案");
            ztc.setZtDate(new Date());
            ztc.setZtCzzt(ZdCzztEnumProcess.ZD__CZZT_TG.getCode());
            ztc.setUserId(zhiduDao.getZdById(zhidu.getZdId().toString()).getUserId());
            ztc.setZtShyj("");
            zhiduDao.saveZdZt(ztc);
        }
    }
    private void setZzZt(){
        System.out.println("职责设置中");
        //获取制度
        gangweiDao.scheUpdateSyTs();   //修改天数
        List<SGangwei> sGangweis = gangweiDao.scheSelectZtDxgZd();  //修改之前获取待修改对象
        gangweiDao.scheUpdateZt();
        for (SGangwei gangwei:sGangweis){
            gangweiDao.scheUpdateZtsh(gangwei.getGwId()); //修改试用的审核状态

            //插入备案状态
            SZhiduzhizeZt ztc = new SZhiduzhizeZt();
            //设置制度ID
            ztc.setZdId(gangwei.getGwId());
            //设置审核状态名字
            ztc.setZtCzname("备案");
            ztc.setZtDate(new Date());
            ztc.setZtCzzt(ZdCzztEnumProcess.ZD__CZZT_TG.getCode());
            ztc.setUserId(gangweiDao.getGwsByGwId(gangwei.getGwId().toString()).getUserId());
            ztc.setZtShyj("");
            gangweiDao.saveZzZt(ztc);
        }
    }

    private void clearHtml(){
        System.out.println("文件清理中");
        String path = System.getProperty("user.dir");
        String htmlp= path+"\\zdhtml\\";
        DeleteFileUtils.deleteFolder(htmlp);
    }

    private void autoCreateBasicBm(){

        saveBmIfNotEx("0100000000","1000000000","机构领导");
        saveBmIfNotEx("0101000000","0100000000","医学装备管理委员会");

        saveBmIfNotEx("0200000000","1000000000","管理科室");
        saveBmIfNotEx("0201000000","0200000000","医工");
        saveBmIfNotEx("0202000000","0200000000","后勤");
        saveBmIfNotEx("0203000000","0200000000","信息科");

        saveBmIfNotEx("0300000000","1000000000","使用科室");
        saveBmIfNotEx("0301000000","0300000000","临床");
        saveBmIfNotEx("0302000000","0300000000","医技");
        saveBmIfNotEx("0303000000","0300000000","医辅");
    }
    private void saveBmIfNotEx(String bmId,String pbmId,String bmName){
        if(bmDao.getBmBybmid(bmId)==null){
            SBm bm = new SBm();
            bm.setObmId(UUID.randomUUID().toString());
            bm.setBmId(bmId);
            bm.setBmName(bmName);
            bm.setpBmId(pbmId);
            bm.setInitFlag("0");
            bmDao.saveBm(bm);
        }
    }
}
