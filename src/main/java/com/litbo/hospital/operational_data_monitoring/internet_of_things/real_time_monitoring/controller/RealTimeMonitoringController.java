package com.litbo.hospital.operational_data_monitoring.internet_of_things.real_time_monitoring.controller;

import com.litbo.hospital.operational_data_monitoring.internet_of_things.real_time_monitoring.service.RealTimeMonitoringService;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.real_time_monitoring.vo.SearchOV;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实时监视
 */
@RestController
@RequestMapping("/realtimemonitoring")
public class RealTimeMonitoringController {


    @Autowired
    private RealTimeMonitoringService realTimeMonitoringService;

    /**
     * 根据条件显示实时数据
     */
    @RequestMapping("/show1")
    public Result show(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                       @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                       SearchOV searchOV ) {
        if (searchOV!=null){
            if (searchOV.getBmId()!=null&&"".equals(searchOV.getBmId())){
                searchOV.setBmId(null);
            }
            if (searchOV.getCAName()!=null&&"".equals(searchOV.getCAName())){
                searchOV.setCAName(null);
            }
            if (searchOV.getCIsLife()!=null&&"".equals(searchOV.getCIsLife())){
                searchOV.setCIsLife(null);
            }
            if (searchOV.getEqstatus()!=null&&"".equals(searchOV.getEqstatus())){
                searchOV.setEqstatus(null);
            }
            if (searchOV.getCEquCate()!=null&&"".equals(searchOV.getCEquCate())){
                searchOV.setCEquCate(null);
            }
            if (searchOV.getEqsyzt()!=null&&"".equals(searchOV.getEqsyzt())){
                searchOV.setEqsyzt(null);
            }
        }
        System.out.println(searchOV);
        return Result.success(realTimeMonitoringService.show1(pageNum,pageSize,searchOV));
    }

    /**显示设备完好信息*/
    @RequestMapping("/show2")
    public Result show2(){
        return Result.success(realTimeMonitoringService.show2());
    }

    /**
     * 显示设备运行状态
     */
    @RequestMapping("/show3")
    public Result show3(){
        return Result.success(realTimeMonitoringService.show3());
    }
}
