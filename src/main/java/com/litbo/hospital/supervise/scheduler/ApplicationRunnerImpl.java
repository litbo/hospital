package com.litbo.hospital.supervise.scheduler;

import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.dao.BmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    @Autowired
    private BmDao bmDao;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        autoCreateBasicBm();
    }

    private void autoCreateBasicBm(){
        saveBmIfNotEx("0100000000","1000000000","机构领导");
        saveBmIfNotEx("0101000000","0100000000","医学装备管理委员会");
        saveBmIfNotEx("0200000000","1000000000","管理部门");
        saveBmIfNotEx("0300000000","1000000000","使用部门");
        saveBmIfNotEx("0201000000","0200000000","医工");
        saveBmIfNotEx("0202000000","0200000000","后勤");
        saveBmIfNotEx("0203000000","0200000000","信息科");
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
            bmDao.saveBm(bm);
        }
    }
}
