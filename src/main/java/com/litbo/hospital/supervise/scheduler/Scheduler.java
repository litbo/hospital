package com.litbo.hospital.supervise.scheduler;

import com.litbo.hospital.common.utils.DeleteFileUtils;
import com.litbo.hospital.supervise.bean.SGangwei;
import com.litbo.hospital.supervise.bean.SZhidu;
import com.litbo.hospital.supervise.bean.SZhiduzhizeZt;
import com.litbo.hospital.supervise.dao.GangweiDao;
import com.litbo.hospital.supervise.dao.ZhiduDao;
import com.litbo.hospital.supervise.enums.ZdCzztEnumProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class Scheduler {


    @Autowired
    private ZhiduDao zhiduDao;
    @Autowired
    private GangweiDao gangweiDao;

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
}
