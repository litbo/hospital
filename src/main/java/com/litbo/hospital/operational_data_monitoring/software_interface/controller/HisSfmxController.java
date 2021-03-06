package com.litbo.hospital.operational_data_monitoring.software_interface.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.HisSflbService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.controller
 * @Author: looli
 * @CreateTime: 2019-07-27 17:55
 * @Description: HIS收费明细
 */
@RestController
@RequestMapping("/HIS")
public class HisSfmxController {
    @Autowired
    private HisSflbService sflbService;

    /**
     * 初始化日期，获取当前日期的前一天数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/showHIS")
    public Result showHIS(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                          @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                          SearchVO searchVO){
        if (searchVO.getBeginTime() == null ){
            //获取当前时间前一天,并转换为字符串
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            String yesterday = new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
            //封装日期
            searchVO.setBeginTime(yesterday);
            PageInfo pageInfo = sflbService.showHisSflbByTime(pageNum, pageSize, searchVO);
            return Result.success(pageInfo);
        }else {
            if (searchVO.getPatientType().equals("")){
                searchVO.setPatientType(null);
            }
            if (searchVO.getPatientId().equals("")){
                searchVO.setPatientId(null);
            }
            PageInfo pageInfo = sflbService.showHisSflbByTime(pageNum, pageSize, searchVO);
            return Result.success(pageInfo);
        }
    }

}
