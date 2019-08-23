package com.litbo.hospital.efficiency.controller;

import com.litbo.hospital.efficiency.bean.KpiBean;
import com.litbo.hospital.efficiency.service.RadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description: 定时处理kpi数据
* @author: sz
 * @date: 2019/8/3 15:39
 */
@RestController
@RequestMapping("/kpi/radio")
public class RadioController {

    @Autowired
    private RadioService radioService;

    /**
     *  将机时利用率的数据插入数据库中
     */
    public void handUsing(){
        List<KpiBean> beanList = radioService.selectUsing();
        if (!beanList.isEmpty()){
            radioService.insertKpi(beanList);
        }
    }

    /**
     *  将空转率的数据插入数据库中
     */
    public void handIdling(){
        List<KpiBean> beanList = radioService.selectIdling();
        if (!beanList.isEmpty()){
            radioService.insertKpi(beanList);
        }
    }

    /**
     *  将开机率的数据插入数据库中
     */
    public void handOpen(){
        List<KpiBean> beanList = radioService.selectOpen();
        if (!beanList.isEmpty()){
            radioService.insertKpi(beanList);
        }
    }

    /**
     *  将平均日闲置时间的数据插入数据库中
     */
    public void handIdlTime(){
        List<KpiBean> beanList = radioService.selectIdlTime();
        if (!beanList.isEmpty()){
            radioService.insertKpi(beanList);
        }
    }

    /**
     *  将完好率的数据插入数据库中
     */
    public void handIntegrity(){
        List<KpiBean> beanList = radioService.selectIntegrity();
        System.out.println(beanList);
        if (!beanList.isEmpty()){
            radioService.insertKpi(beanList);
        }
    }

    /**
     *  每天晚上 23:55 导入数据
     */
//    @Scheduled(cron = "0 55 23 1/1 * ?")
//    public void handDay(){
//        handUsing();
//        handIdling();
//    }
//
//    /**
//     *  每月最后一天23:55运行
//     */
//    @Scheduled(cron = "0 55 23 L * ?")
//    public void handMonth(){
//        handOpen();
//        handIdlTime();
//        handIntegrity();
//    }

    public void handDay(){
        handUsing();
        handIdling();
    }

    public void month(){
        handOpen();
        handIdlTime();
        handIntegrity();
    }
}
